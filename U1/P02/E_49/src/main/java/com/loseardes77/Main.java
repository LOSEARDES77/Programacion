package com.loseardes77;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] a = JOptionPane.showInputDialog("Introduce la primera fila de la matriz 3x3\nSepara los numeros con comas (,)\nSepara las columnas con punto y coma (;)").replace(" ", "").split(";");
        int[][] A = getMatrix(a);
        String[] b = JOptionPane.showInputDialog("Introduce la primera fila de la matriz 3x3\nSepara los numeros con comas (,)\nSepara las columnas con punto y coma (;)").replace(" ", "").split(";");
        int[][] B = getMatrix(b);
        JOptionPane.showMessageDialog(null,"Suma de matrices: " + matrixToString(calcMultiplicacion(A,B)));
    }

    private static int[][] calcMultiplicacion(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = multiplyMatricesCell(a, b, i, j);
            }
        }
        return result;
    }

    private static int multiplyMatricesCell(int[][] a, int[][] b, int row, int col) {
        int cell = 0;
        for (int i = 0; i < b.length; i++) {
            cell += a[row][i] * b[i][col];
        }
        return cell;
    }

    private static String matrixToString(int[][] matrix){
        StringBuilder result = new StringBuilder();
        result.append("\n");
        for (int[] line : matrix)
            result.append("   ").append(Arrays.toString(line)).append("\n");
        return result.toString();
    }
    private static int[][] getMatrix(String[] matriz) {
        String[] fila1 = matriz[0].split(",");
        String[] fila2 = matriz[1].split(",");
        String[] fila3 = matriz[2].split(",");
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++)
            result[0][i] = Integer.parseInt(fila1[i]);
        for (int i = 0; i < 3; i++)
            result[1][i] = Integer.parseInt(fila2[i]);
        for (int i = 0; i < 3; i++)
            result[2][i] = Integer.parseInt(fila3[i]);
        return result;
    }
}