package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ConstanteKaprekar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            System.out.println(iterate(n, 0));
        }
    }

    public static int iterate(int num, int iterations) {
        if (num == 0 || num % 1111 == 0) {
            return 8;
        }
        if (num == 6174) {
            return iterations;
        }
        String numStr = String.format("%04d", num);
        char[] digits = numStr.toCharArray();
        Arrays.sort(digits);
        int asc = Integer.parseInt(new String(digits));
        int desc = Integer.parseInt(new String(reverse(digits)));
        int difference = desc - asc;
        return iterate(difference, iterations + 1);
    }

    public static char[] reverse(char[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}
