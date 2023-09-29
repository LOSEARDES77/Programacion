package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        while (true){
            System.out.print("Introduce una cadena: ");
            String cadena = teclado.nextLine();
            System.out.println("Longitud: " + cadena.length());
            if(cadena.isEmpty()){
                break;
            }
        }
    }
}