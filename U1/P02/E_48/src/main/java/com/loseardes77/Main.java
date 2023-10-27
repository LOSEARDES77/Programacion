package com.loseardes77;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] a = JOptionPane.showInputDialog("Introduce la primera fila de la matriz 3x3\nSepara los numeros con comas (,)\nSepara las columnas con punto y coma (;)").replace(" ", "").split(";");
        int[][] A = getMatrix(a);
        JOptionPane.showMessageDialog(null,"Suma de matrices: " + matrixToString(calcTraspuesta(A)));
    }

    private static int[][] calcTraspuesta(int[][] a) {
        int[][] resultado = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                resultado[i][j] = a[2 - i][2 - j];
        return resultado;
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