package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double numero1, numero2, numero3;
        System.out.println("introduce un numero: ");
        numero1 = teclado.nextDouble();
        System.out.println("introduce otro numero: ");
        numero2 = teclado.nextDouble();
        System.out.println("introduce otro numero: ");
        numero3 = teclado.nextDouble();
        if (numero1 > numero3){
            System.out.println("Numero 1 mayor que Numero 3. \n Intercambiando valores");
            double temp = numero1;
            numero1 = numero3;
            numero3 = temp;
        }
        System.out.println("Numero 1: " + numero1 + "\nNumero 2: " + numero2 + "\nNumero 3: " + numero3);
    }
}