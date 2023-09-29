package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        double numero = teclado.nextDouble();
        System.out.println("Math:     " + Math.sqrt(numero));
        System.out.println("Function: " +  sqrt(numero));
    }

    public static double sqrt(double num){
        double g = 1;
        double aprox = 0.5 * (g+num/g);
        while (g != aprox){
            aprox = 0.5 * (g+num/g);
            g = 0.5 * (aprox+num/aprox);
        }
        return aprox;
    }
}