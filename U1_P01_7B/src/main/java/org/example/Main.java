package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce los yenes: ");
        double yenes = teclado.nextDouble();
        double euros = yenes * 0.00633910;
        // 1 JPY = 0.00633910
        System.out.println("Euros: " + euros);
    }
}