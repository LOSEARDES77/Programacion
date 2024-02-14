package org.aceptaelreto;

import java.util.Scanner;

public class PiramidesCleopatra {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String primerNumero = t.nextLine();
        StringBuilder output = new StringBuilder();
        int numEntradas = Integer.parseInt(primerNumero);
        String[] entradas = new String[numEntradas];
        for (int i = 0; i < numEntradas; i++){
            entradas[i] = t.nextLine();
        }
        for (String entry : entradas){
            String[] arr = entry.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);

                int difAB, difCB;
                difAB = b - a;
                difCB = c - b;

                if (b > 0 && a < 0)
                    difAB--;

                if (b < 0 && c > 0)
                    difCB--;

                if (difAB == difCB)
                    output.append("EMPATE").append("\n");

                else if (difAB < difCB)
                    output.append(a).append("\n");

                else
                    output.append(c).append("\n");

        }
        System.out.print(output);
    }
}