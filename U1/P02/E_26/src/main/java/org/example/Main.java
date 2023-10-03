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
        /*String textoTarget = texto.replace(palabra, remplazo);
        String[] texto2 = texto.split(palabra);
        System.out.println(texto2.length);
        String textoFinal = "";
        for (int i = 0; i < texto2.length; i++) {
            if ( i != texto2.length-1) textoFinal = textoFinal.concat(texto2[i] + remplazo);
            else textoFinal = textoFinal.concat(texto2[i]);
        }*/

        // TODO


    }

    private static int coincidencias(String texto, String palabra) {
            int coincidencias  =texto.split(palabra).length - 1;
            if (texto.endsWith(palabra)) coincidencias++;
        return coincidencias;
    }
}