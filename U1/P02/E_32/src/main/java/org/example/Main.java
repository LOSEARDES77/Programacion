package org.example;

// TODO

import java.util.Scanner;

public class Main {
    // 32.	Hacer un conversor de números romanos a arábigos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numeroRomano;
        do{
            System.out.print("Introduce un número romano: ");
            numeroRomano = scanner.nextLine().toUpperCase();
            if (esValido(numeroRomano)) {
                System.out.println("Numero no valido no es válido");
            }
        } while (esValido(numeroRomano));
        System.out.println("Numero: " + convertir(numeroRomano));
    }

    private static int convertir(String numeroRomano) {
        int numero = 0;

        for (int i = 0; i < numeroRomano.length(); i++) {
            char actual = numeroRomano.charAt(i);
            char siguiente = (i < numeroRomano.length() - 1) ? numeroRomano.charAt(i + 1) : '\0';

            if (actual == 'I') {
                if (siguiente == 'V') {
                    numero += 4;
                    i++;
                } else if (siguiente == 'X') {
                    numero += 9;
                    i++;
                } else {
                    numero += 1;
                }
            } else if (actual == 'V') {
                numero += 5;
            } else if (actual == 'X') {
                if (siguiente == 'L') {
                    numero += 40;
                    i++;
                } else if (siguiente == 'C') {
                    numero += 90;
                    i++;
                } else {
                    numero += 10;
                }
            } else if (actual == 'L') {
                numero += 50;
            } else if (actual == 'C') {
                if (siguiente == 'D') {
                    numero += 400;
                    i++;
                } else if (siguiente == 'M') {
                    numero += 900;
                    i++;
                } else {
                    numero += 100;
                }
            } else if (actual == 'D') {
                numero += 500;
            } else if (actual == 'M') {
                numero += 1000;
            }
        }

        return numero;
    }


    private static boolean esValido(String numeroRomano) {
        return !numeroRomano.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }

}