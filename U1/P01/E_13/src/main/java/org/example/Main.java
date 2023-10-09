package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        double numero = teclado.nextDouble();
        if(numero < 0){
            numero = numero * -1;
        }
        System.out.println("Valor absoluto: " + numero);
    }
}