package org.example;

import java.util.Scanner;

public class E02_MCD {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int x = s.nextInt();
        System.out.print("Introduce otro numero: ");
        int y = s.nextInt();
        System.out.println("El mcd de " + x + " y " + y + " es " + mcd(x, y));
    }

    private static int mcd(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        if (max % min == 0) {
            return min;
        }
        return mcd(min, max % min);

    }
}
