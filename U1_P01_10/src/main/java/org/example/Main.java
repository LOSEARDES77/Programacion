package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double numero1, numero2, numero3, aux;
        System.out.print("introduce un numero: ");
        numero1 = teclado.nextDouble();
        System.out.print("introduce otro numero: ");
        numero2 = teclado.nextDouble();
        System.out.print("introduce otro numero: ");
        numero3 = teclado.nextDouble();
        while (numero1 > numero2 || numero2 > numero3){
            if (numero1 > numero2){
                aux = numero1;
                numero1 = numero2;
                numero2 = aux;
            }if (numero2 > numero3){
                aux = numero2;
                numero2 = numero3;
                numero3 = aux;
            }
        }
        System.out.println("Numero 1: " + numero1 + "\nNumero 2: " + numero2 + "\nNumero 3: " + numero3);
    }
}