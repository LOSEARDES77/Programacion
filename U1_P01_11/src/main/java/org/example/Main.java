package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce los metos: ");
        double metros = teclado.nextDouble();
        double pies = metros * 39.27 * 1/12;
        System.out.println("Pies: " + pies);
    }
}