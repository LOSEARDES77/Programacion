package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num1, num2, respuesta, aciertos = 0, fallos = 0;
        for (int i = 0; i < 10; i++) {
            num1 = (int) (Math.random() * 10 + 1);
            num2 = (int) (Math.random() * 10 + 1);
            System.out.println("¿Cuánto es " + num1 + "x" + num2 + "?");
            respuesta = teclado.nextInt();
            while (respuesta != num1 * num2) {
                System.out.println("Incorrecto. Inténtelo de nuevo.");
                respuesta = teclado.nextInt();
                fallos++;
            }
            System.out.println("Muy bien.");
            aciertos++;
        }
        System.out.println("Ha acertado " + aciertos + " preguntas.");
        System.out.println("Ha fallado " + fallos + " preguntas.");

    }
}