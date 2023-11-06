package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int lenthX = 10000;
        int lenthY = 10000;
        int maxCellValue = 9;
        int searchRadious = 3;

        int[][] matriz = new int[lenthX][lenthY];
        for (int i = 0; i < matriz.length; i++){
           for (int j = 0;  j < matriz[0].length; j++){
               matriz[i][j] = (int) (Math.random() * (maxCellValue + 1));
           }
       }
        System.out.print("   ");
        for (int i = 0; i < matriz[0].length; i++){
           System.out.printf("%02d ", i);
       }
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {
           System.out.println(String.format("%02d ", i) + Arrays.toString(matriz[i]) + String.format(" %02d", i));
       }
        System.out.print("   ");
        for (int i = 0; i < matriz[0].length; i++){
           System.out.printf("%02d ", i);
       }
        System.out.println();
       int[] bestPos = getBestPos(matriz, searchRadious);
       double scoreAverage = ((double) (bestPos[2])/Math.pow(searchRadious,2.0)) ;
       System.out.printf("i: %d\nj: %d\ntotal score: %d\naverage score: %.3f\nsearch radious: %d", bestPos[0], bestPos[1], bestPos[2],scoreAverage, searchRadious);
       System.out.println();

       for (int i = bestPos[0]; i < bestPos[0]+searchRadious; i++){
           System.out.print("[");
           for (int j = bestPos[1]; j < bestPos[1]+searchRadious; j++){
               if(i > 0 && i < matriz.length && j > 0 && j < matriz[0].length) {
                   if (j == bestPos[1] + searchRadious - 1) System.out.printf("%d", matriz[i - 1][j - 1]);
                   else System.out.printf("%d, ", matriz[i - 1][j - 1]);
               }
           }
           System.out.println("]");
       }

    }

    public static int[] getBestPos(int[][] matrix, int searchRadious){
        int[][] possibleBestPos = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                int score = 0;
                for (int k = -(searchRadious/2); k < (searchRadious/2)+1; k++) {
                    for (int l = -(searchRadious/2); l < (searchRadious/2)+1; l++) {
                        if (i+k > 0 && i+k < matrix.length && j+l > 0 && j+l < matrix[0].length) {
                            score += matrix[i + k][j + l];
                        }
                    }
                }
                possibleBestPos[i][j] = score;
            }
        }
        int[] bestPos = new int[]{0, 0, possibleBestPos[0][0]};
        for (int i = 0; i < possibleBestPos.length; i++){
            for (int j = 0; j < possibleBestPos[0].length; j++){
                if (i == 0 && j == 0) j++;
                if( bestPos[2] < possibleBestPos[i][j])
                    bestPos = new int[]{i, j, possibleBestPos[i][j]};
            }
        }

        return bestPos;

    }


}