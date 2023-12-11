package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static String[] readFile(){
        String filename = "input.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            List<String> lines = new ArrayList<String>();
            while (( line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            return lines.toArray(new String[0]);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return null;
    }
}