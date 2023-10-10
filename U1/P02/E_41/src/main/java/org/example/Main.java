package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Introduce los datos: ");
        String datos = t.next();
        System.out.println("Data: " + datos + "\nDatos Comprimidos: " +  compress(datos));
    }

    private static String compress(String datos) {
        StringBuilder resultado = new StringBuilder();
        char[] data = datos.toCharArray();
        char tmp = 0;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                tmp = data[i];
            }
            else {
                if(tmp == data[i]){
                    int contador = i;
                    while(tmp == data[contador]){
                        count++;
                        contador++;
                    }
                    resultado.append("\\").append(count).append(tmp);
                    i += contador-1;
                }else {
                    resultado.append(data[i-1]);
                    tmp = data[i];
                }

            }
        }
        return resultado.toString();
    }
}