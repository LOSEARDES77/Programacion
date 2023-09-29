package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String s = sc.nextLine();
        System.out.println("Vocales: " + getVocales(s));

    }

    public static int getVocales(String s){
        String c = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < c.length(); i++){
            if (String.valueOf(c.charAt(i)).equals("a") || String.valueOf(c.charAt(i)).equals("e") || String.valueOf(c.charAt(i)).equals("i") || String.valueOf(c.charAt(i)).equals("o") || String.valueOf(c.charAt(i)).equals("u")){
                count++;
            }
        }
        return count;
    }
}