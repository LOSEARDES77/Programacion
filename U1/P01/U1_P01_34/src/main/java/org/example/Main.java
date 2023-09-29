package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Handler;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> juegos = new ArrayList<>();
        ArrayList<Integer> sets = new ArrayList<>();
        System.out.print("Introduce el numero de sets que se jugaran: ");
        int numSets = teclado.nextInt();
        for (int i = 0; i < 2; i++){
            juegos.add(0);
            sets.add(0);
        }
        while (true){
            System.out.print("Quien ha ganado este juego? (A, B): ");
            String ganador = teclado.next();
            juegos = handleJuegos(ganador, juegos);
            sets = handleSets(juegos, sets);
            if (sets.get(0) == (numSets / 2 + 1)){
                System.out.println("Ha ganado el jugador A");
                break;
            }else if (sets.get(1) == (numSets / 2 + 1)){
                System.out.println("Ha ganado el jugador B");
                break;
            }
        }
    }

    private static ArrayList<Integer> handleJuegos(String ganador, ArrayList<Integer> marcador) {
        if (ganador.equalsIgnoreCase("a")){
            marcador.set(0, (marcador.get(0) + 1));
        }else if (ganador.equalsIgnoreCase("b")){
            marcador.set(1, (marcador.get(1) + 1));
        }else {
            System.out.println("Jugador no valido (a/b)");
        }
        System.out.println("El marcador de juegos es: " + marcador.get(0) + " - " + marcador.get(1));
        return marcador;
    }

    private static ArrayList<Integer> handleSets(ArrayList<Integer> juegos, ArrayList<Integer> marcador){
        if (juegos.get(0) == 6 && juegos.get(1) <= 4){
            marcador.set(0, (marcador.get(0) + 1));
            juegos.set(0, 0);
            juegos.set(1, 0);
        }else if (juegos.get(1) == 6 && juegos.get(0) <= 4){
            marcador.set(1, (marcador.get(1) + 1));
            juegos.set(0, 0);
            juegos.set(1, 0);
        }else if (juegos.get(0) == 7){
            marcador.set(0, (marcador.get(0) + 1));
            juegos.set(0, 0);
            juegos.set(1, 0);
        }else if (juegos.get(1) == 7){
            marcador.set(1, (marcador.get(1) + 1));
            juegos.set(0, 0);
            juegos.set(1, 0);
        }
        System.out.println("El marcador de sets es: " + marcador.get(0) + " - " + marcador.get(1));
        return marcador;
    }
}