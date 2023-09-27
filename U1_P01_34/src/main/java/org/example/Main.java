package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Handler;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> juegos = new ArrayList<>();
        ArrayList<Integer> sets = new ArrayList<>();
        juegos.set(0, 0);
        juegos.set(1, 0);
        sets.set(0, 0);
        sets.set(1, 0);
        while (true){
            System.out.print("Quien ha ganado este juego? (A, B): ");
            String ganador = teclado.next();
            juegos = handleJuegos(ganador, juegos);
            sets = handleSets(juegos, sets);
        }
    }

    private static ArrayList<Integer> handleJuegos(String ganador, ArrayList<Integer> marcador) {
        if (ganador.equalsIgnoreCase("a")){
            marcador.set(0, (marcador.get(0) + 1));
        }else if (ganador.equalsIgnoreCase("b")){
            marcador.set(1, (marcador.get(1) + 1));
        }
        return marcador;
    }

    private static ArrayList<Integer> handleSets(ArrayList<Integer> juegos, ArrayList<Integer> marcador){

        return marcador;
    }
}