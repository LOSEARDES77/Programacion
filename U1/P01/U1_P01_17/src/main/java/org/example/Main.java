package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        long contador = 0;
        System.out.println("Introduce un numero: ");
        long numero = teclado.nextLong();
        long triangular = 0;
        while (contador < (numero)){
            contador++;
            triangular += contador;
        }
        System.out.println("Triangular: " + triangular);


    }
}