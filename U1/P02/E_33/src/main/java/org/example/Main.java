package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static String[] palabras = {
            "Desafío",
            "Sincero",
            "Pastilla",
            "Restar",
            "Koala",
            "Bombilla",
            "Bebe",
            "Pote",
            "Templo",
            "Mosaico",
            "Preparar",
            "Duelo",
            "Turno",
            "Coser",
            "Coleccion"
    };
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int jugar = 0;
        while(jugar == 0){
            juego();
            System.out.print("Quieres volver a jugar? [S/N]: ");
            String estado = t.nextLine();
            if(estado.equalsIgnoreCase("n")){
                jugar = 1;
                System.out.println("Hasta pronto!");
            }
        }

    }

    private static void juego(){
        Scanner teclado = new Scanner(System.in);
        String palabra = palabras[(int) (Math.random() * palabras.length)];
        String letras = "";
        int aciertos = 0, fallos = 0, estado = -1;
        while(estado < 0) {
            printPalabra(palabra, letras);
            System.out.print("Introduce una letra: ");
            String letra = teclado.nextLine();
            if(letra.length() > 1){
                System.out.println("Solo una letra!");
            }else {
                letras += letra + " ";
                if (palabra.toLowerCase().contains(letra.toLowerCase()))aciertos++;
                else fallos++;
                System.out.println("Aciertos: " +  aciertos + "\nFallos: " + fallos + "\n   " + printPalabra(palabra, letras));
                if (Objects.equals(palabra, printPalabra(palabra, letras))){
                    estado = 0;
                } else if (fallos >= 7) {
                    estado = 1;
                }
            }
        }
        switch (estado){
            case 0:
                System.out.println("Ganaste!");
                break;
            case 1:
                System.out.println("Perdiste");
                break;
        }
    }
    private static String printPalabra(String palabra, String l){
        String resultado = "";
        String[] letras = l.toLowerCase().split(" ");
        ArrayList<Integer> aciertos = new ArrayList<>();
        for (String letra : letras) {
            if (palabra.toLowerCase().contains(letra.toLowerCase())) {
                aciertos.add(palabra.indexOf(letra));
            }
        }
        for (int i = 0; i < palabra.length(); i++) {
            if(aciertos.contains(i)) resultado += palabra.charAt(i);
            else resultado += "-";
        }
        System.out.println(aciertos);
        return resultado;
        //TODO fix error
    }
}