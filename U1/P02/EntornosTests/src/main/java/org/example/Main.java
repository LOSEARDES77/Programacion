package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] alumnos = new String[5];

        alumnos[0] = "Alcober, Oscar";
        alumnos[1] = "Campaña, Marcos";
        alumnos[2] = "Casa, Derek";
        alumnos[3] = "Garcia, Africa";
        alumnos[4] = "Heredia, Joan";

        for (String i : alumnos)
            System.out.println(i + "\nNumero de e: " + numeroDeEs(i));

    }

    private static int numeroDeEs(String i) {
        int count = 0;
        for (Character j : i.toCharArray())
            if( j.equals('e') ) count++;
        return count;
    }
}