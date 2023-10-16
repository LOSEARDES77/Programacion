package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Introduce los datos: ");
        String datos = t.next();
        String comprimido = compress(datos);
        System.out.println("Datos:                 " + datos + "\nDatos Comprimidos:   " +  comprimido + "\nCompresion avanzada: " + mejorarCompresion(comprimido));
    }

    public static String compress(String input) {
        StringBuilder output = new StringBuilder();
        int count = 0;
        for (int i = 1; i < input.length(); i++) {
            if(input.charAt(i) == input.charAt(i-1)){
                count++;
                if (i == input.length()-1){
                    output.append("\\").append(count+1).append(input.charAt(i-1));
                    count = 0;
                }
            }else {
                if (count > 0){
                    output.append("\\").append(count+1).append(input.charAt(i-1));
                    count = 0;
                }else {
                    output.append(input.charAt(i-1));
                }
            }
            if (i == input.length()-1){
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }

    private static String mejorarCompresion(String comprimido){
        StringBuilder mejorado = new StringBuilder();
        int contador = 0;
        for (int i = 0; i < comprimido.length(); i++) {
            if (comprimido.charAt(i) == '\\') {
                char character = 0;
                String numeros = "";
                if (isANumber(String.valueOf(comprimido.charAt(i+1)))){
                    if(isANumber(String.valueOf(comprimido.charAt(i+2)))){
                        if (isANumber(String.valueOf(comprimido.charAt(i+3)))){
                            numeros += comprimido.charAt(i+1) + comprimido.charAt(i+2) + comprimido.charAt(i+3);
                            contador = Integer.parseInt(numeros);
                            character = comprimido.charAt(i+4);
                        }else{
                            numeros += comprimido.charAt(i+1) + comprimido.charAt(i+2);
                            contador = Integer.parseInt(numeros);
                            character = comprimido.charAt(i+3);
                        }
                    }else{
                        numeros += comprimido.charAt(i+1);
                        contador = Integer.parseInt(numeros);
                        character = comprimido.charAt(i+2);
                    }
                }
                if (contador < 3){
                    mejorado.append(String.valueOf(character).repeat(Math.max(0, contador)));
                }else {
                    mejorado.append("\\").append(contador).append(character);
                }

                i += contador;
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

    public static boolean isANumber(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}