package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int numero = teclado.nextInt();
        int numeroInvertido = 0;
        while (numero > 0) {
            numeroInvertido = numeroInvertido * 10 + numero % 10;
            numero /= 10;
        }
        System.out.println("El numero invertido es: " + numeroInvertido);
    }
}