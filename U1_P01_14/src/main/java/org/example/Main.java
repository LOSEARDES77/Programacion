package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un año: ");
        long año = teclado.nextLong();
        if (año < 0){
            System.out.println("No valen años negativos!");
            return;
        }
        if (esBisiesto(año)){
            System.out.println("El año " + año + " es bisiesto");
            return;
        }
        System.out.println("El año " + año + " no es bisiesto");

    }

    public static boolean esBisiesto(long año){
        return año % 4 == 0;
    }
}