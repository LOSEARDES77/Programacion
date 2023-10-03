package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            numeros.add((int) (Math.random() * 100) + 1);
        }
        int num = -1;
        while (!numeros.contains(num)){
            System.out.print("Introduce un numero: ");
            num = teclado.nextInt();
            if(!numeros.contains(num)){
                System.out.println("Numero incorrecto\nPrueba otra vez");
            }
        }
        System.out.println("Numero correcto");
        System.out.println("Numeros: " + numeros);
    }
}