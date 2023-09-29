package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer número: ");
        long numero1 = teclado.nextLong();
        System.out.println("Introduce el segundo número: ");
        long numero2 = teclado.nextLong();
        for (long i = numero1; i <= numero2; i++) {
            if (esPrimo(i)) {
                System.out.println(i);
            }
        }

    }
    public static boolean esPrimo(long numero){
        boolean esPrimo = true;
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                esPrimo = false;
                break;
            }
        }
        return esPrimo;
    }
}