package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce una cadena: ");
        String cadena = teclado.nextLine();
        System.out.print("Introduce un numero: ");
        int numero = teclado.nextInt();
        while (numero >= 0){

            if (numero <= cadena.length() && numero != 0){
                System.out.println(cadena.charAt(numero-1));
            }else {
                System.out.println("Error: el numero " + numero + " es mayor que la longitud de la cadena introducida. (Longitud = " + cadena.length() + ")");
//                int tmp = numero-cadena.length();
//                while(tmp >= cadena.length()){
//                    tmp = tmp-cadena.length();
//                }
//                System.out.println(cadena.charAt(tmp));
            }
            System.out.print("Introduce un numero: ");
            numero = teclado.nextInt();
        }
    }
}