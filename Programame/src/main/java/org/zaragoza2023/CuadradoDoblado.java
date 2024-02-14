package org.zaragoza2023;

import java.util.Scanner;

public class CuadradoDoblado {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numDeCasos = Integer.parseInt(s.nextLine());
        for (int i = 0; i < numDeCasos; i++) {
            int n = Integer.parseInt(s.nextLine());
            int[][] cuadrado = new int[n][n];
            for (int j = 0; j < n; j++) {
                String[] fila = s.nextLine().split(" ");
                for (int k = 0; k < fila.length; k++) {
                    cuadrado[j][k] = Integer.parseInt(fila[k]);
                }
            }
            System.out.println(esDoblado(cuadrado) ? "SI" : "NO");
        }
    }

    private static boolean esDoblado(int[][] cuadrado){
        int max = Integer.MIN_VALUE;
        int[] coords = new int[]{-1,-1};
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[0].length; j++) {
                if (cuadrado[i][j] > max) {
                    max = cuadrado[i][j];
                    coords = new int[]{i,j};
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j <cuadrado[0].length; j++) {
                if (i != coords[0] || j != coords[1]){
                    sum += cuadrado[i][j];
                }
            }
        }
        return sum == max;
    }
}
