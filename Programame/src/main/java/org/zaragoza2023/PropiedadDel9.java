package org.zaragoza2023;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class PropiedadDel9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String entrada = s.nextLine();
        while (!Objects.equals(entrada, "0")){
            int[] cifras = new int[entrada.length()];
            for (int i = 0; i < entrada.length(); i++) {
                cifras[i] = Character.getNumericValue(entrada.charAt(i));
            }
            Arrays.sort(cifras);
            int[] max = cifras.clone();
            for (int i = 0; i < cifras.length / 2; i++) {
                int temp = cifras[i];
                cifras[i] = cifras[cifras.length - 1 - i];
                cifras[cifras.length - 1 - i] = temp;
            }
            int[] min = cifras.clone();
            int minNum = 0;
            int maxNum = 0;
            for (int i = 0; i < cifras.length; i++) {
                minNum += (int) (min[i] * Math.pow(10, i));
                maxNum += (int) (max[i] * Math.pow(10, i));
            }
            System.out.printf("%d - %d = %d = %d x 9\n", maxNum, minNum, maxNum - minNum, (maxNum - minNum) / 9);
            entrada = s.nextLine();
        }
    }
}
