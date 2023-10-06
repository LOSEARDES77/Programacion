package org.example;

import java.util.Scanner;

// TODO

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int numero = teclado.nextInt();
        System.out.println("Numero romano: " + convertir(numero));
    }

    private static String convertir(int num){
        String numero = "";
        while(num - 1000 >= 0){
            numero += "M";
            num -= 1000;
        }
        while(num - 500 >= 0){
            numero += "D";
            num -= 500;
        }
        while(num - 100 >= 0){
            numero += "C";
            num -= 100;
        }
        while(num - 50 >= 0){
            numero += "L";
            num -= 50;
        }
        while(num - 10 >= 0){
            numero += "X";
            num -= 10;
        }
        while(num - 5 >= 0){
            numero += "V";
            num -= 5;
        }
        while(num - 1 >= 0){
            numero += "I";
            num -= 1;
        }


        return numero;
    }
}