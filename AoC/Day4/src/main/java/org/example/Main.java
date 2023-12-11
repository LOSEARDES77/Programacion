package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] fileContents = readFile();

        long points = 0;
        if (fileContents == null) {
            System.out.println("Error: file not found");
            return;
        }
        int[] cardRepeat = new int[fileContents.length];
        Arrays.fill(cardRepeat, 1);
        long cardStackSize = fileContents.length;
        for (int i = 0; i < fileContents.length; i++) {
            String[] myNumbers = fileContents[i].split(":")[1].split("[|]")[0].split(" ");
            String[] winningNumbers = fileContents[i].split(":")[1].split("[|]")[1].split(" ");
            int cardNumber = Integer.parseInt(fileContents[i].split(":")[0].replace("Card ", "").trim());
            List<String> winningNumbersList = List.of(winningNumbers);
            int cardPoints = 0;
            int winningNumbersCount = 0;
            for (String myNumber : myNumbers) {
                if (winningNumbersList.contains(myNumber) && !myNumber.isEmpty()) {
                    if (cardPoints == 0) {
                        cardPoints++;
                    }else
                        cardPoints *= 2;
                    winningNumbersCount++;
                }
            }
            for (int j = 0; j < cardRepeat[cardNumber-1]; j++) {
                for (int k = 0; k < winningNumbersCount; k++) {
                    cardRepeat[cardNumber + k]++;
                    cardStackSize++;
                }
            }
            points += cardPoints;
        }
        System.out.println(points);
        System.out.println(cardStackSize);

    }

    public static String[] readFile(){
        // String fileName = "test.txt";
        String fileName = "input.txt";
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            return lines.toArray(new String[0]);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}