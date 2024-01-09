package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(stackSizeCalc(1L));
        System.out.println(stackSizeCalc(1L));

    }

    private static long stackSizeCalc(long num){
        try {
            return stackSizeCalc(num + 1L);
        } catch (StackOverflowError e) {
            return num;
        }
    }

    private static int factorialRecursivo(int num){
        if (num == 1 || num == 0) {
            return 1;
        }
        return num * factorialRecursivo(num -1);
    }

    private static int factrialIterativo(int num){
        int factorial = 1;
        for (int i = 2; i <= num; i++){
            factorial *= i;
        }
        return factorial;
    }
}
