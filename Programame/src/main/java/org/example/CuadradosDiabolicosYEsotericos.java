package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class CuadradosDiabolicosYEsotericos {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!Objects.equals(input = r.readLine(), "0")) {
            int n = Integer.parseInt(input);
            int[][] matrix = new int[n][n];
            String matrixStr = r.readLine();
            String[] matrixStrArr = matrixStr.split(" ");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(matrixStrArr[k]);
                    k++;
                }
            }
            System.out.println(isEsoteric(matrix) ? "ESOTERICO" : isDiabolic(matrix) ? "DIABOLICO" : "NO");
        }
    }

    private static boolean isEsoteric(int[][] matrix) {
        if (!isDiabolic(matrix)) {
            return false;
        }
        int cm = 0;
        for (int[] ints : matrix) {
            cm += ints[0];
        }
        int numCasillas = matrix.length * matrix.length;
        int cifras = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cifras += (int) Math.log10(matrix[i][j]) + 1;
            }
        }
        if (cifras != numCasillas) {
            return false;
        }

        int cm2 = 4 * cm / matrix.length;
        int esquinas = matrix[0][0] + matrix[0][matrix.length - 1] + matrix[matrix.length - 1][0] + matrix[matrix.length - 1][matrix.length - 1];
        if (cm2 != esquinas) {
            return false;
        }

        if (matrix.length % 2 == 1) {
            int mitad = matrix.length / 2;
            int casillas2 = matrix[mitad][0] + matrix[mitad][matrix.length - 1] + matrix[0][mitad] + matrix[matrix.length - 1][mitad];
            if (cm2 != casillas2) {
                return false;
            }
            int casillaCentral = matrix[mitad][mitad];
            return cm2 == casillaCentral * 4;

        }
        int[] mitad = new int[]{(matrix.length -1) / 2 - 1, matrix.length / 2};
        int casillas2 = matrix[mitad[0]][0] + matrix[mitad[0]][matrix.length - 1] + matrix[0][mitad[0]] + matrix[matrix.length - 1][mitad[0]] + matrix[mitad[1]][0] + matrix[mitad[1]][matrix.length - 1] + matrix[0][mitad[1]] + matrix[matrix.length - 1][mitad[1]];
        if (cm2 * 2 != casillas2) {
            return false;
        }
        int casillaCentral = matrix[mitad[0]][mitad[0]] + matrix[mitad[0]][mitad[1]] + matrix[mitad[1]][mitad[0]] + matrix[mitad[1]][mitad[1]];
        return cm2 == casillaCentral;
    }
    private static boolean isDiabolic(int[][] matrix) {
        int cm = 0;
        for (int i = 0; i < matrix.length; i++) {
            cm += matrix[i][0];
        }
        int cm2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            cm2 += matrix[0][i];
        }
        if (cm != cm2) {
            return false;
        }
        int cm3 = 0;
        for (int i = 0; i < matrix.length; i++) {
            cm3 += matrix[i][i];
        }
        if (cm != cm3) {
            return false;
        }
        int cm4 = 0;
        for (int i = 0; i < matrix.length; i++) {
            cm4 += matrix[i][matrix.length - 1 - i];
        }
        return cm == cm4;
    }
}
