package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un año: ");
        long anio = teclado.nextLong();
        if (anio < 0){
            System.out.println("No valen años negativos!");
            return;
        }
        if (esBisiesto(anio)){
            System.out.println("El año " + anio + " es bisiesto");
            return;
        }
        System.out.println("El año " + anio + " no es bisiesto");
    }

    public static boolean esBisiesto(long anio){
        return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0;
    }
}