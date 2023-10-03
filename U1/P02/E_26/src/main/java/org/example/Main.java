package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Cuantos caballos corren?: ");
        int caballos = teclado.nextInt();
        ArrayList<Integer> puntuacionCaballos = new ArrayList<>();
        for (int i = 0; i < caballos; i++) {
            puntuacionCaballos.add(0);
        }
        ArrayList<Integer> ganadores = new ArrayList<>();
        boolean estado = true;
        while (estado){
            for (int i = 0; i < caballos; i++) {
                if (puntuacionCaballos.get(i) >= 50){
                    ganadores.add(i+1);
                    estado = false;
                }
                puntuacionCaballos.set(i, (int) (Math.random() * 5) + 1);
            }
        }
        System.out.println("Ganadores:    " + ganadores);
        System.out.println("Puntuaciones: ");
        for (int i = 0; i < caballos; i++) {
            System.out.println("Dorsal: " + i + "Puntos: " + puntuacionCaballos);

        }
    }
}