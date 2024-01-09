package org.example;

import java.util.Scanner;

public class E07_HanoiGraphics {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int n = s.nextInt();
        int[] torreO = new int[n];
        int[] torreA = new int[n];
        int[] torreD = new int[n];
        for (int i = 0; i < n; i++) {
            torreO[i] = n - i;
        }
        long start = System.currentTimeMillis();
        hanoi(n, torreO, torreA, torreD, torreO, torreA, torreD, true);
        long end  = System.currentTimeMillis();
        long timeTaken = end -start;
        long seconds = timeTaken / 1000;
        System.out.println("Took " + seconds + "s " + (timeTaken - (seconds * 1000)) + "ms");
    }
    private static void hanoi(int n, int[] o, int[] a, int[] d, int[] torreO, int[] torreA, int[] torreD, boolean initialPrint){
        if (initialPrint)
            print(torreO, torreA, torreD);

        if (n == 1) {
            mover(o, d);
            print(torreO, torreA, torreD);
            // System.out.println("Mover " + o + " a " + d);
            return;
        }
        hanoi(n - 1, o , d , a, torreO, torreA, torreD, false);
        hanoi(1, o , a , d, torreO, torreA, torreD, false);
        hanoi(n - 1, a , o , d, torreO, torreA, torreD, false);

    }

    private static void print(int[] torreO, int[] torreA, int[] torreD) {
        for (int i = torreA.length -1; i >= 0; i--) {
            System.out.println(
                    printLine(torreO, i, torreA.length) + " || " +
                    printLine(torreA, i, torreA.length) + " || " +
                    printLine(torreD, i, torreA.length));
        }

        System.out.println("\n");

    }

    private static int getTop(int[] torre) {
        for (int i = torre.length - 1; i >= 0; i--) {
            if (torre[i] != 0) {
                return i;
            }
        }
        return 0;
    }

    private static void mover(int[] o, int[] d) {
        int topO = getTop(o);
        int topD = getTop(d);
        if (topD == d.length - 1) {
            topD--;
        }
        if (topO >= o.length) {
            topO = o.length - 1;
        }

        d[topD + 1] = o[topO];
        o[topO] = 0;
    }

    private static int transformNumbers(int n){
        return n * 2 - 1;
    }

    private static String printLine(int[] torre, int indice, int tamanioMaximo) {
        int cantidadDeEspacio = tamanioMaximo + 4;
        int line = torre[indice];
        int cantidadDeEspacioIzquierda = (cantidadDeEspacio - transformNumbers(line)) / 2;
        int cantidadDeEspacioDerecha = cantidadDeEspacio - transformNumbers(line) - cantidadDeEspacioIzquierda;
        return " ".repeat(Math.max(0, cantidadDeEspacioIzquierda)) +
                "█".repeat(Math.max(0, transformNumbers(line))) +
                " ".repeat(Math.max(0, cantidadDeEspacioDerecha));
    }
}
