package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        long numero1 = teclado.nextLong();
        System.out.print("Introduce otro numero: ");
        long numero2 = teclado.nextLong();
        ArrayList<Long> factNumero1 = fact(numero1);
        ArrayList<Long> factNumero2 = fact(numero2);
        long mcm = 1;
        for (long i = 0; i < Math.max(factNumero1.size(), factNumero2.size()); i++) {
            if (factNumero2.contains(factNumero1.get((int) i))){
                mcm *= factNumero1.get((int) i);
                factNumero2.remove(factNumero1.get((int) i));
            }
        }
        System.out.println("Minimo comun multiplo: " + mcm);
    }

    private static ArrayList<Long> fact(long numero) {
        ArrayList<Long> factores = new ArrayList<>();
        factores.add(1L);
        long div = numero;
        for (long i = 2; div > i; i++){
            if (numero % i == 0){
                if (esPrimo(i)){
                    while (div % i == 0){
                        div /= i;
                        factores.add(i);
                    }
                }
            }

        }
        return factores;
    }
    private static boolean esPrimo(long numero){
        boolean esPrimo = true;
        for (long i = 2; i < numero; i++) {
            if (numero % i == 0) {
                esPrimo = false;
                break;
            }
        }
        return esPrimo;
    }
}
