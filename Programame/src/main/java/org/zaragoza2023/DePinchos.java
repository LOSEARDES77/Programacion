package org.zaragoza2023;

import java.util.Scanner;

public class DePinchos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true){
            String[] casoDePrueba = s.nextLine().split(" ");
            int[] bares = new int[casoDePrueba.length - 1];
            for (int i = 0; i < casoDePrueba.length - 1; i++){
                bares[i] = Integer.parseInt(casoDePrueba[i]);
            }
            int min = getMinMax(bares, 1);
            int max = getMinMax(bares, 0);
            int[] numbers = new int[bares.length + 1];
            int iterator = 0;
            for (int i = min; i < max + 1; i++){
                numbers[iterator] = i;
                iterator++;
            }
            for (int i = 0; i < bares.length; i++){
                for (int j = 0; j< numbers.length; j++){
                    if (bares[i] == numbers[j]){
                        numbers[j] = -1;
                        break;
                    }
                }
            }
            for (int i : numbers){
                if (i != -1){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static int getMinMax(int[] i, int m){
        if (m == 0){
            int max = Integer.MIN_VALUE;
            for (int is : i){
                max = Math.max(is, max);
            }
            return max;
        }else {
            int min = Integer.MAX_VALUE;
            for (int is : i){
                min = Math.min(is, min);
            }
            return min;
        }
    }
}
