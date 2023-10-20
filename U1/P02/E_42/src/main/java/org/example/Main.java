package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner t = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = t.nextLine();
        int[][] numeros = getNumeros(frase);
        // Debug System.out.println(Arrays.deepToString(numeros));
        System.out.println("Edad de fallecimiento: " + calcEdad(numeros));
        t.close();
    }
    public static String calcEdad(int[][] numeros){
        int anioMax = Math.max(numeros[0][0], numeros[0][1]);
        int anioMin = Math.min(numeros[0][0], numeros[0][1]);
        int anios = anioMax - anioMin;
        int meses;
        if (anioMax == numeros[0][0])
            meses = numeros[1][0] - numeros[1][1];
        else
            meses = numeros[1][1] - numeros[1][0];

        if (meses < 0) {
            anios--;
            meses += 12;
        }return anios + " años " + meses + " meses";
    }
    private static int[][] getNumeros(String frase){
        String[] frase2 = frase.split("[^0-9]");
        String[] frase3 = new String[4];
        int counter = 0;
        for (String s : frase2)
            if (!s.isEmpty()) {
                frase3[counter] = s;
                counter++;
            }
        int anioEncontrado = 0;
        int mesEncontrado = 0;
        int[] anios = new int[]{0, 0};
        int[] meses = new int[]{0, 0};
        for (String palabra : frase3) {
            if (anioEncontrado == 2 && mesEncontrado == 2) break;
            if (palabra.matches("[0-9]{4}")) {
                anioEncontrado++;
                if (anios[0] == 0) anios[0] = parseNumber(palabra);
                else anios[1] = parseNumber(palabra);
            }else if (palabra.matches("[0-9]{1}")) {
                mesEncontrado++;
                if (meses[0] == 0) meses[0] = parseNumber(palabra);
                else meses[1] = parseNumber(palabra);
            } else if (palabra.matches("[0-9]{2}")) {
                mesEncontrado++;
                if (meses[0] == 0) meses[0] = parseNumber(palabra);
                else meses[1] = parseNumber(palabra);
            }
        }
        return new int[][]{anios, meses};
    }
    private static int parseNumber(String s){
        int num;
        try {
            num = Integer.parseInt(s);
        }catch (NumberFormatException e){
            System.out.println("Parse error");
            num = -1;
        }
        return num;
    }
}