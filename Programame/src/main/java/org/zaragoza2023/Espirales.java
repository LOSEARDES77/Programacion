package org.zaragoza2023;

import java.util.Arrays;
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
            System.out.println(espiralGalactica(matriz));
            entrada = s.nextLine();
        }
    }

    private static int espiralGalactica(int[][] matriz) {
        int n = matriz.length;
        int[] casillaCentral = new int[]{n / 2, n / 2};
        int[] siguienteCasilla = new int[]{0, 0};
        int suma = 0;

        while (!Arrays.equals(siguienteCasilla, new int[]{-1, -1})) {
            suma += matriz[siguienteCasilla[0] + casillaCentral[0]][siguienteCasilla[1] + casillaCentral[1]];

            siguienteCasilla = calcularSiguienteCasilla(n, siguienteCasilla);
        }

        return suma;
    }

    private static int[] calcularSiguienteCasilla(int n, int[] casillaActual) {
        // TODO
        return null;
    }


}
