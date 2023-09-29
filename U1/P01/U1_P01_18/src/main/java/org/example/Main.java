package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        long numero = teclado.nextLong();
        long contador = 0, triangular = 0;
        while (contador < (numero)){
            contador++;
            triangular += contador;
            if(triangular == numero){
                System.out.println("El numero " + numero + " es triangular");
                System.out.println("Triangular anterior: " + (triangular - contador));
                System.out.println("Triangular posterior: " + (triangular + contador + 1));
                break;
            }
        }
        if(triangular == numero) return;
        System.out.println("El numero " +  numero + " no es triangular");

    }
}