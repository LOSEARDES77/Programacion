package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce una cadena: ");
        String cadena = teclado.nextLine();
        System.out.print("Introduce un numero: ");
        int numero = teclado.nextInt();
        while (numero >= 0){
            if (numero < cadena.length()){
                System.out.println(cadena.charAt(numero));
            } else {
                int tmp = numero-cadena.length();
                while(tmp >= cadena.length()){
                    tmp = tmp-cadena.length();
                }
                System.out.println(cadena.charAt(tmp));
            }
            System.out.print("Introduce un numero: ");
            numero = teclado.nextInt();
        }
    }
}