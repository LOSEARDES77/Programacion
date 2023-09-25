package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int altura = teclado.nextInt();
        for (int i = 0; i < (altura); i++){
            System.out.println();
            for (int j = 0; j < (altura); j++){
                if (j > (altura - i)){
                    System.out.print(" * ");
                }else System.out.print("   ");
            }
        }
    }
}