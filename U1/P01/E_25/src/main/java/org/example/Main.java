package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce la altura del triángulo: ");
        int altura = teclado.nextInt();
        System.out.println("Donde quieres que este el eje de simetria del triángulo: ");
        System.out.println("  1) Arriba");
        System.out.println("  2) Abajo");
        System.out.println("  3) Izquierda");
        System.out.println("  4) Derecha");
        System.out.print("Introduce la opción: ");
        int opcion = teclado.nextInt();
        switch (opcion){
            case 0:
                abajo(altura);
                System.out.println();
                arriba(altura);
                System.out.println();
                izquierda(altura);
                System.out.println();
                derecha(altura);
                break;
            case 1:
                arriba(altura);
                break;
            case 2:
                abajo(altura);
                break;
            case 3:
                izquierda(altura);
                break;
            case 4:
                derecha(altura);
                break;
            default:
                System.out.println("Opción no válida");
        }



    }

    public static void abajo(int altura){
        for (int i = altura; i >= 1; i--) {
            for (int j = 1; j <= altura - i; j++) {
                System.out.print("   ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    public static void arriba(int altura){
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= altura - i; j++) {
                System.out.print("   ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void izquierda(int altura){
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        for (int i = altura - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void derecha(int altura){
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= altura - i; j++) {
                System.out.print("   ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

        for (int i = altura - 1; i >= 1; i--) {
            for (int j = 1; j <= altura - i; j++) {
                System.out.print("   ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}