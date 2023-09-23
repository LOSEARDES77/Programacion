package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero entero: ");
        int numero1 = teclado.nextInt();
        System.out.println("Introduce otro numero entero: ");
        int numero2 = teclado.nextInt();
        System.out.println("Tabla de multiplicar de " + numero1 + " hasta "+ numero2);
        int contador = 0;
        while (contador < (numero2 + 1)){
            System.out.println(numero1 + " x " + contador + " = " + (numero1 * contador));
            contador++;
        }
    }
}