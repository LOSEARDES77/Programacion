package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Introduce los datos: ");
        String datos = t.next();
        System.out.println("Data: " + datos + "\nDatos Comprimidos: " +  compress(datos));
    }

    public static String compress(String input) {
        StringBuilder output = new StringBuilder();
        int count = 1;
        char marker = '\\';
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == marker) {
                output.append(marker);
                output.append(1);
                output.append(marker);
                output.append(marker);
            } else {
                count = 1;
                while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                    count++;
                    i++;
                }
                if (count > 1) {
                    output.append(marker);
                    output.append(count);
                    output.append(input.charAt(i));
                } else {
                    output.append(input.charAt(i));
                }
            }
        }
        return mejorarCompresion(output.toString());
    }

    private static String mejorarCompresion(String comprimido){
        StringBuilder mejorado = new StringBuilder();
        int contador = 0;
        for (int i = 0; i < comprimido.length(); i++) {
            if (comprimido.charAt(i) == '\\') {
                contador = Integer.parseInt(String.valueOf(comprimido.charAt(i + 1)));
                if(contador < 3)
                    mejorado.append(String.valueOf(comprimido.charAt(i + 2)).repeat(Math.max(0, contador)));
                else
                    mejorado.append("\\").append(contador).append(comprimido.charAt(i));
                i += 2;
            } else {
                mejorado.append(comprimido.charAt(i));
            }
        }
        return mejorado.toString();
    }



    public static String decompress(String input) {
        StringBuilder output = new StringBuilder();
        char marker = '\\';
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == marker) {
                int count = Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                char c = input.charAt(i + 2);
                for (int j = 0; j < count; j++) {
                    output.append(c);
                }
                i += 2;
            } else {
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }
}