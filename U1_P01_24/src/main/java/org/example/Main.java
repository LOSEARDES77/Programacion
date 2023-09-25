package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int lado = teclado.nextInt();
        System.out.print("En que arista quieres que este el algulo recto? (1, 2, 3, 4): ");
        int arista = teclado.nextInt();
        switch (arista){
            case 0:
                arista1(lado);
                arista2(lado);
                arista3(lado);
                arista4(lado);
                break;
            case 1:
                arista1(lado);
                break;
            case 2:
                arista2(lado);
                break;
            case 3:
                arista3(lado);
                break;
            case 4:
                arista4(lado);
                break;
            default:
                System.out.println("Arista no valida");
        }


    }
    public static void arista1(int lado){
        for (int i = 0; i < (lado + 1); i++){
            System.out.println();
            for(int j = 0; j > (-lado + i); j--){
                System.out.print(" * ");
            }
        }
    }
    public static void arista2(int lado){
        for (int i = 0; i < (lado + 1); i++){
            System.out.println();
            for(int j = 0; j < (lado + 1); j++){
                if (j > i){
                 System.out.print(" * ");
                }else{
                    if (j != 0) System.out.print("   ");
                }
            }
        }
    }
    public static void arista3(int lado){
        for (int i = 0; i < (lado + 1); i++){
            System.out.println();
            for(int j = 0; j < i; j++){
                System.out.print(" * ");
            }
        }
    }
    public static void arista4(int lado){
        for (int i = 0; i < (lado + 1); i++){
            System.out.println();
            for(int j = 0; j < lado; j++){
                if((lado - j) > i){
                    System.out.print("   ");
                }else System.out.print(" * ");
            }
        }
    }
}