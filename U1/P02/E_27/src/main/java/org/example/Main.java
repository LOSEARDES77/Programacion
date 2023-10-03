package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String[][] diccionario = {
            {"casa", "house"},
            {"perro", "dog"},
            {"gato", "cat"},
            {"coche", "car"},
            {"ordenador", "computer"},
            {"mesa", "table"},
            {"silla", "chair"},
            {"ventana", "window"},
            {"puerta", "door"},
            {"pared", "wall"}
    };

    public static void main(String[] args) {
        if (!hayDiccionario()) guardarDiccionario();
        else cargarDiccionario();
        Scanner teclado = new Scanner(System.in);
        while (true) {
            System.out.print("Introduce una palabra en español para traducirla al inglés: ");
            String palabra = teclado.nextLine();
            if(palabra.isEmpty()) break;
            int posicion = buscaPalabra(palabra);
            if (posicion != -1) System.out.println("La palabra " + palabra + " en inglés es: " + diccionario[posicion][1]);
            else {
                System.out.println("La palabra " + palabra + " no está en el diccionario.");
                System.out.print("¿Quieres añadirla? (S/N)");
                String respuesta = teclado.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    String[][] diccionarioAuxiliar = new String[diccionario.length + 1][2];
                    System.arraycopy(diccionario, 0, diccionarioAuxiliar, 0, diccionario.length);
                    diccionarioAuxiliar[diccionarioAuxiliar.length - 1][0] = palabra;
                    System.out.print("Introduce la traducción de la palabra " + palabra + ": ");
                    diccionarioAuxiliar[diccionarioAuxiliar.length - 1][1] = teclado.nextLine();
                    // System.out.println("Debug: " + Arrays.deepToString(diccionario));
                    diccionario = diccionarioAuxiliar;
                    // System.out.println("Debug: " + Arrays.deepToString(diccionarioAuxiliar));
                    guardarDiccionario(true);
                }
            }
        }
    }
//optional debug default to false
    private static void guardarDiccionario(){
        guardarDiccionario(false);
    };
    private static void guardarDiccionario(boolean debug) {
        try {
            PrintWriter writer = new PrintWriter("diccionario.txt");
            for (String[] entrada : diccionario) {
                writer.println(entrada[0] + "," + entrada[1]);
            }
            writer.close();
            if(debug) System.out.println("Diccionario guardado en el archivo diccionario.txt.");
        } catch (IOException e) {
            if(debug) System.err.println("Error al guardar el diccionario: " + e.getMessage());
        }

    }
    private static void cargarDiccionario() {
        try {
            File archivo = new File("diccionario.txt");
            Scanner scanner = new Scanner(archivo);

            List<String[]> nuevaLista = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] entrada = linea.split(",");
                if (entrada.length == 2) {
                    nuevaLista.add(entrada);
                } else {
                    System.err.println("Error en el formato del diccionario en línea: " + linea);
                }
            }

            diccionario = nuevaLista.toArray(new String[0][0]);

            scanner.close();
            System.out.println("Diccionario cargado desde el archivo diccionario.txt.");
        } catch (FileNotFoundException e) {
            System.err.println("Se cargo el diccionario por defecto.");
        }
    }

    private static boolean hayDiccionario() {
        return new File("diccionario.txt").exists();
    }


    private static int buscaPalabra(String palabra) {
        int posicion = -1;
        for (int i = 0; i < diccionario.length; i++) if (diccionario[i][0].equals(palabra)) posicion = i;
        return posicion;
    }
}