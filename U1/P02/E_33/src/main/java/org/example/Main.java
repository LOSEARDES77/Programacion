package org.example;



import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
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
        Scanner scanner = new Scanner(System.in);
        int jugar = 0;
        while (jugar == 0) {
            juego();
            System.out.print("¿Quieres volver a jugar? [S/N]: ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                jugar = 1;
                System.out.println("¡Hasta pronto!");
            }
        }
    }

    private static void juego() {
        Scanner teclado = new Scanner(System.in);
        String palabra = palabras[(int) (Math.random() * palabras.length)];
        String letras = "";
        int aciertos = 0, fallos = 0;

        while (fallos < 7) {
            System.out.println("Aciertos: " + aciertos + " | Fallos: " + fallos);
            printPalabra(palabra, letras);
            System.out.print("Introduce una letra: ");
            String letra = teclado.nextLine().toLowerCase();

            if (letra.length() != 1) {
                System.out.println("Por favor, ingresa solo una letra.");
            } else if (letras.contains(letra)) {
                System.out.println("Ya has ingresado esa letra.");
            } else {
                letras += letra + " ";
                if (palabra.contains(letra)) {
                    aciertos += palabra.length() - palabra.replace(letra, "").length();
                } else {
                    fallos++;
                }

                if (aciertos == palabra.length()) {
                    printPalabra(palabra, letras);
                    System.out.println("¡Ganaste!");
                    return;
                }
            }
        }

        printPalabra(palabra, letras);
        System.out.println("Perdiste. La palabra correcta era: " + palabra);
    }

    private static void printPalabra(String palabra, String letras) {
        char[] resultado = new char[palabra.length()];
        Arrays.fill(resultado, '-');
        for (char letra : letras.toCharArray()) {
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    resultado[i] = letra;
                }
            }
        }
        System.out.print("Letras usadas: ");
        for (int i = 0; i < letras.split(" ").length; i++) {
            if (i == 0) System.out.print(letras.split(" ")[i]);
            else System.out.print(" | " + letras.split(" ")[i]);
        }
        System.out.println("\n   " + new String(resultado));

    }
}

