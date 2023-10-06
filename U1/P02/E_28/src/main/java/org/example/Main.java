package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static ArrayList<Integer> numerosGanadores;
    private static ArrayList<Integer> numerosEstrella;
    private static final ArrayList<Integer> numerosJugador = new ArrayList<>();
    private static final ArrayList<Integer> numerosEstrellaJugador = new ArrayList<>();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        genNumeros(0);
        String respuesta = "";
        while(!respuesta.equalsIgnoreCase("n")) {
            for (int i = 0; i < 5; i++) {
                int j = 0;
                while (!esValido(0, j)) {
                    System.out.print("Introduce un numero (1-50): ");
                    j = teclado.nextInt();
                    if (!esValido(0, j)) System.out.println("Numero no valido");;
                }
                if (esValido(0, j)) numerosJugador.add(j);
            }
            for (int i = 0; i < 2; i++) {
                int j = 0;
                while (!esValido(1, j)) {
                    System.out.print("Introduce un numero estrella: ");
                    j = teclado.nextInt();
                    if (!esValido(1, j)) System.out.println("Numero no valido");
                }
                if (esValido(1, j)) numerosEstrellaJugador.add(j);
            }
            // Debug System.out.println("NumerosJugador: " + numerosJugador + "\nNumerosEstrellajugador: " + numerosEstrellaJugador);
            System.out.println("Aciertos Normal:   " + getAciertos(0));
            System.out.println("Aciertos Estrella: " + getAciertos(1));
            System.out.print("Quieres seguir jugando? [S/N]: ");
            respuesta = teclado.next();

        }

    }

    private static int getAciertos(int cual) {
        int aciertos = 0;
        if(cual == 0){
            for (int i = 0; i < 5; i++) {
                if (numerosGanadores.contains(numerosJugador.get(i))){
                    aciertos++;
                }
            }
        }
        if (cual == 1){
            for (int i = 0; i < 2; i++) {
                if(numerosEstrella.contains(numerosEstrellaJugador.get(i))){
                    aciertos++;
                }
            }
        }
        return aciertos;
    }

    private static boolean esValido(int cual, int num) { // 0 = numeros ganadores || 1 = numeros estrella
        if(cual == 0){
            return num >= 1 && num <= 50;
        } else if (cual == 1) {
            return num >= 1 && num <= 12;
        }
        System.out.println("Error en la validacion");
        return false;
    }

    private static void checkNumeros(int cual){
        if (cual == 1 || cual == 0) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (Objects.equals(numerosGanadores.get(i), numerosGanadores.get(j)) && j != i) {
                        genNumeros(1);
                        break;
                    }
                }
            }
        }
        if (cual == 2){
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (Objects.equals(numerosEstrella.get(i), numerosEstrella.get(j)) && j != i) {
                        genNumeros(2);
                        break;
                    }
                }
            }
        }
    }

    private static void genNumeros(int cual){
        if (cual == 1 || cual == 0) {
            numerosGanadores = new ArrayList<>();
            for (int i = 0; i < 5; i++) numerosGanadores.add((int) (Math.random() * 50) + 1);
            checkNumeros(1);
        }
        if (cual == 2 || cual == 0) {
            numerosEstrella = new ArrayList<>();
            for (int i = 0; i < 2; i++) numerosEstrella.add((int) (Math.random() * 12) + 1);
            checkNumeros(2);
        }
        // Debug System.out.println("Numeros ganadores: " + numerosGanadores + "\nNumeros estrella: " + numerosEstrella);
    }
}