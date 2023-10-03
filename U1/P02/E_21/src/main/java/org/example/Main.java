package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un dni: ");
        String dni = teclado.nextLine();
        if(esValido(dni)){
            System.out.println("DNI valido");
        }else {
            System.out.println("DNI no valido ");
        }
    }

    private static boolean esValido(String dni){
        if (dni.length() != 9) return false;
        char letra = dni.charAt(8);
        int num = Integer.parseInt(dni.split(String.valueOf(letra))[0]);
        String CADENA = "TRWAGMYFPDXBNJZSQVHLCKE";
        int posicion = 0;

        for (int i = 0; i < CADENA.length(); i++){
            if (CADENA.charAt(i) == letra){
                posicion = i;
                break;
            }
        }
        return num % 23 == posicion;
    }
}