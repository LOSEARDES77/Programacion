package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        byte count = 0;
        double media = 0;
        while (count < 20){
            count++;
            System.out.println("Introduce un numero: ");
            media += teclado.nextDouble();
        }
        media /= 20;
        System.out.println("Media: " + media);

    }
}