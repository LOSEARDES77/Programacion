package org.zaragoza2023;

import java.util.Objects;
import java.util.Scanner;

public class Espirales {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String entrada = s.nextLine();
        while (!Objects.equals(entrada, "0")){
            int n = Integer.parseInt(entrada);
            int[][] matriz = new int[n][n];
            for (int i = 0; i < n; i++){
                String[] fila = s.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matriz[i][j] = Integer.parseInt(fila[j]);
                }
            }
            System.out.println(galacticSpiral(matriz));
            entrada = s.nextLine();
        }
    }

    private static int galacticSpiral(int[][] matriz) {
        int n = matriz.length;
        int[] casillaCentral = new int[]{n / 2, n / 2};
        int[] siguienteCasilla = new int[]{0, 0, 0};
        int suma = 0;
        int contador = 1;
        while (siguienteCasilla[0] < n/2 +1 && siguienteCasilla[1] < n/2 +1) {
            for (int i = 0; i < contador; i++) {
                if (siguienteCasilla[0] >= n/2 && siguienteCasilla[1] >= n/2) break;
                suma += matriz[siguienteCasilla[0] + casillaCentral[0]][siguienteCasilla[1] + casillaCentral[1]];
                calcularSiguienteCasilla(siguienteCasilla);
            }
            if (siguienteCasilla[2] == 3) {
                siguienteCasilla[2] = 0;
            } else {
                siguienteCasilla[2]++;
            }
            contador++;
        }

        return suma;
    }


    private static void calcularSiguienteCasilla(int[] siguienteCasilla) {
            switch (siguienteCasilla[2]) {
                case 0: {
                    siguienteCasilla[0]--;
                }
                case 1: {
                    siguienteCasilla[1]++;
                }
                case 2: {
                    siguienteCasilla[0]++;
                }
                case 3: {
                    siguienteCasilla[1]--;
                }
            }
    }


}
