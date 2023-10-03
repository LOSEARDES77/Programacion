package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Introduce un texto: ");
        String texto = t.nextLine();
        System.out.print("Que palabra quieres buscar?: ");
        String palabra = t.nextLine();
        System.out.println("He encontrado " + coincidencias(texto, palabra) + " coincidencias");
        System.out.print("Por que lo quieres remplazar?: ");
        String remplazo = t.nextLine();
        System.out.println("Texto reemplazado:\n" + reemplazar(texto, palabra, remplazo));

    }

    private static String reemplazar(String texto, String palabra, String remplazo) {
        StringBuilder textoReemplazado = new StringBuilder();
        int posicion = 0;
        int posicionAnterior = 0;
        while (posicion != -1) {
            posicion = texto.indexOf(palabra, posicionAnterior);
            if (posicion != -1) {
                textoReemplazado.append(texto, posicionAnterior, posicion).append(remplazo);
                posicionAnterior = posicion + palabra.length();
            } else {
                textoReemplazado.append(texto.substring(posicionAnterior));
            }
        }
        return textoReemplazado.toString();

    }

    private static int coincidencias(String texto, String palabra) {
            int coincidencias  =texto.split(palabra).length - 1;
            if (texto.endsWith(palabra)) coincidencias++;
        return coincidencias;
    }
}