package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numero;
        do {
            Scanner teclado = new Scanner(System.in);
            System.out.print("Introduce un numero: ");
            numero = teclado.nextInt();
            if (!esValido(numero)) {
                System.out.println("El numero debe estar entre 1 y 4000");
            }
        } while (!esValido(numero));
        System.out.println("Numero romano: " + convertir(numero));

    }

    private static boolean esValido(int num){
        return num > 0 && num < 4000;
    }

    private static String convertir(int num){
        String numero = "";
        while(num > 0){
            if(num >= 1000){
                numero += "M";
                num -= 1000;
            }else if(num >= 900){
                numero += "CM";
                num -= 900;
            }else if(num >= 500){
                numero += "D";
                num -= 500;
            }else if(num >= 400){
                numero += "CD";
                num -= 400;
            }else if(num >= 100){
                numero += "C";
                num -= 100;
            }else if(num >= 90){
                numero += "XC";
                num -= 90;
            }else if(num >= 50){
                numero += "L";
                num -= 50;
            }else if(num >= 40){
                numero += "XL";
                num -= 40;
            }else if(num >= 10){
                numero += "X";
                num -= 10;
            }else if(num >= 9){
                numero += "IX";
                num -= 9;
            }else if(num >= 5){
                numero += "V";
                num -= 5;
            }else if(num >= 4){
                numero += "IV";
                num -= 4;
            }else if(num >= 1){
                numero += "I";
                num -= 1;
            }
        }
        return numero;
    }
}