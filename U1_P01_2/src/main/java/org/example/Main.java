package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int numero = teclado.nextInt();
        if (numero == 0){
            System.out.println("Numero es 0");
        } else if (numero > 0) {
            System.out.println("Numero es positivo");
        } else if (numero < 0) {
            System.out.println("Numero es negativo");
        }

    }
}