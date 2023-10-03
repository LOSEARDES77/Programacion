package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        char[] frase = teclado.nextLine().toCharArray();
        ArrayList<Integer> count = new ArrayList<>(); // Cuenta [a, e, i, o, u]
        for (int i = 0; i < 5; i++){
            count.add(0);
        }
        for (char i : frase) {
            switch (String.valueOf(i)) {
                case "a" -> count.set(0, count.get(0) + 1);
                case "e" -> count.set(1, count.get(1) + 1);
                case "i" -> count.set(2, count.get(2) + 1);
                case "o" -> count.set(3, count.get(3) + 1);
                case "u" -> count.set(4, count.get(4) + 1);
            }
        }
        System.out.println(" a  e  i  o  u");
        for (int i : count) {
            System.out.print(" " + i + " ");
        }
    }
}