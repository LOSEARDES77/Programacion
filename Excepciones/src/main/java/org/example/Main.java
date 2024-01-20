package org.example;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new FileReader("test.txt"));
            String line;
            while ((line = r.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}