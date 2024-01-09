package org.example;

import java.util.Scanner;

public class E05_Fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int n = s.nextInt();
        System.out.println("El fibonacci de " + n + " es " + fibonacci(n));
    }

    private static long fibonacci(int num){
        if (num <= 1)
            return 1;
        return fibonacci(num-1) + fibonacci(num - 2);
    }
}
