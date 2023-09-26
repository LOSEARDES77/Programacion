package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        long numero = teclado.nextLong();
        System.out.println("Descomposicion factorial: " + fact(numero));
    }

    private static ArrayList<Long> fact(long numero) {
        ArrayList<Long> factores = new ArrayList<>();
        factores.add(1L);
        long div = numero;
        long i = 1;
        while (div > i){
            i++;
            if (numero % i == 0){
                if (esPrimo(i)){
                    while (div % i == 0){
                        div /= i;
                        factores.add((i));
                    }
                }
            }

        }
        return factores;
    }

    private static boolean esPrimo(long numero){
        boolean esPrimo = true;
        for (long i = 2; i < numero; i++){
            if (numero % i == 0){
                esPrimo = false;
                break;
            }
        }
        return esPrimo;
    }
}