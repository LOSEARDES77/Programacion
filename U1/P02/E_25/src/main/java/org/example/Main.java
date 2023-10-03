package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> puntuacionCaballos = new ArrayList<>();
        ArrayList<Integer> ganadores = new ArrayList<>();
        boolean estado = true;
        System.out.print("Cuantos caballos corren?: ");
        int caballos = teclado.nextInt();

        for (int i = 0; i < caballos; i++) puntuacionCaballos.add(0);
        while (estado){
            for (int i = 0; i < caballos; i++) {
                puntuacionCaballos.set(
                        i,
                        puntuacionCaballos.get(i) + (int) (Math.random() * 5) + 1
                );

                if (puntuacionCaballos.get(i) >= 50) ganadores.add(i+1);
            }
            for (int i : puntuacionCaballos)
                if (i >= 50) {
                    estado = false;
                    break;
                }
        }
        System.out.println("Ganadores: ");
        for (int i : ganadores) System.out.print("Dorsal: " + i + " ");

        System.out.println("\nPuntuaciones: ");
        for (int i = 1; i <= caballos; i++)
            System.out.println("Dorsal: " + i + " Puntos: " + puntuacionCaballos.get(i-1));
    }
}