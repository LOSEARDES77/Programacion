package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int numero = teclado.nextInt();
        for (int i = 0; i < numero; i++) {
            System.out.println();
            for (int j = 0; j < numero; j++) {
                System.out.print(" * ");
            }
        }

    }
}