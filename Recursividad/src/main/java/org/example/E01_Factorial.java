package org.example;

import java.util.Scanner;

public class E01_Factorial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int n = s.nextInt();
        System.out.println("El factorial de " + n + " es " + factorial(n));
    }
    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
