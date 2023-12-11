package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] input = readFile();
        long sumOfPartNumbers = 0;
        long sumOfGearRatios = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                if (Character.isDigit(input[i].charAt(j)) && isPartNumber(input, i, j)) {
                    sumOfPartNumbers += findDigits(j, input[i]);
                }

                if (input[i].charAt(j) == '*' && isGear(input, i, j)) {
                    long gearRatio = calculateGearRatio(input, i, j);
                    sumOfGearRatios += gearRatio;
                }
            }
        }

        System.out.println("Sum of all part numbers: " + sumOfPartNumbers);
        System.out.println("Sum of all gear ratios: " + sumOfGearRatios);
    }

    private static boolean isPartNumber(String[] input, int i, int j) {
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                if (k != 0 || l != 0) {
                    int x = i + k;
                    int y = j + l;
                    if (x >= 0 && x < input.length && y >= 0 && y < input[i].length() && Character.isDigit(input[x].charAt(y))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isGear(String[] input, int i, int j) {
        int partNumberCount = 0;
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                if (k != 0 || l != 0) {
                    int x = i + k;
                    int y = j + l;
                    if (x >= 0 && x < input.length && y >= 0 && y < input[i].length() && Character.isDigit(input[x].charAt(y))) {
                        partNumberCount++;
                    }
                }
            }
        }
        return partNumberCount == 2;
    }

    private static long calculateGearRatio(String[] input, int i, int j) {
        long product = 1;
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                if (k != 0 || l != 0) {
                    int x = i + k;
                    int y = j + l;
                    if (x >= 0 && x < input.length && y >= 0 && y < input[i].length() && Character.isDigit(input[x].charAt(y))) {
                        product *= findDigits(y, input[x]);
                    }
                }
            }
        }
        return product;
    }

    private static long findDigits(int i, String line) {
        int numberStart, numberEnd;
        int j = i;
        while (Character.isDigit(line.charAt(j)) && j > 0) {
            j--;
        }
        numberStart = j + 1;
        j = i;
        while (Character.isDigit(line.charAt(j))) {
            j++;
        }
        numberEnd = j - 1;
        return Long.parseLong(line.substring(numberStart, numberEnd + 1));
    }

    public static String[] readFile() {
        String fileName = "test.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> fileContent = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.add(line);
            }
            reader.close();
            return fileContent.toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
