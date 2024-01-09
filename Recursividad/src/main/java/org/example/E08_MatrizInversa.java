package org.example;

import java.util.Scanner;

public class E08_MatrizInversa {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el tamaño de la matriz (ej: 3x3): ");
        String size = s.nextLine();
        String[] sizes = size.split("x");
        int rows = Integer.parseInt(sizes[0]);
        int columns = Integer.parseInt(sizes[1]);
        double[][] matriz = new double[rows][columns];

        if (matriz.length != matriz[0].length) {
            System.out.println("La matriz no es cuadrada. No se puede calcular la matriz inversa.");
            return;
        }
        for (int i = 0; i < rows; i++) {
            System.out.println("Introduce los valores de la matriz para la fila " + i + " (ej: 1 2 3 4 5 6 7 8 9): ");
            String[] row = s.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                matriz[i][j] = Double.parseDouble(row[j]);
            }
        }


        double determinante = calcularDeterminante(matriz);
        if (determinante == 0) {
            System.out.println("La matriz no tiene inversa porque su determinante es cero.");
            return;
        }

        double[][] matrizInversa = calcularMatrizInversa(matriz, determinante);

        System.out.println("Matriz Inversa:");
        imprimirMatriz(matrizInversa);
    }

    private static void imprimirMatriz(double[][] matriz) {
        for (double[] doubles : matriz) {
            for (double num: doubles) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static double calcularDeterminante(double[][] matriz) {
        int dimension = matriz.length;

        if (dimension == 1) {
            return matriz[0][0];
        }

        if (dimension == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }

        double determinante = 0;

        for (int j = 0; j < dimension; j++) {
            determinante += matriz[0][j] * cofactor(matriz, 0, j);
        }

        return determinante;
    }

    private static double cofactor(double[][] matriz, int fila, int columna) {
        int dimension = matriz.length;
        int signo = (fila + columna) % 2 == 0 ? 1 : -1;

        double[][] submatriz = new double[dimension - 1][dimension - 1];
        int subfila = 0;
        int subcolumna;

        for (int i = 0; i < dimension; i++) {
            if (i != fila) {
                subcolumna = 0;
                for (int j = 0; j < dimension; j++) {
                    if (j != columna) {
                        submatriz[subfila][subcolumna] = matriz[i][j];
                        subcolumna++;
                    }
                }
                subfila++;
            }
        }

        return signo * calcularDeterminante(submatriz);
    }

    private static double[][] calcularMatrizInversa(double[][] matriz, double determinante) {
        int dimension = matriz.length;
        double[][] matrizInversa = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrizInversa[i][j] = cofactor(matriz, j, i) / determinante;
            }
        }

        return matrizInversa;
    }

}
