package org.example;

import java.util.Scanner;

public class E06_ToresDeHanoi {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int n = s.nextInt();
        String o = "origen";
        String a = "auxiliar";
        String d = "destino";
        long start = System.currentTimeMillis();
        hanoi(n, o, a, d);
        long end  = System.currentTimeMillis();
        long timeTaken = end -start;
        long seconds = timeTaken / 1000;
        System.out.println("Took " + seconds + "s " + (timeTaken - (seconds * 1000)) + "ms");
    }
    private static void hanoi(int n, String o, String a, String d){
        if (n == 1) {
            System.out.println("Mover " + o + " a " + d);
            return;
        }
        hanoi(n - 1, o , d , a);
        hanoi(1, o , a , d);
        hanoi(n - 1, a , o , d);

    }
}
