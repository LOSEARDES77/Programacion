package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.println("Introduce una operacion\nIntroduce '.' para salir");
        while(true) {
            System.out.print("> ");
            String input = t.next();
            if (input.equals(".")) break;
            calculadora(input);
        }
    }


    private static void calculadora(String input){
        char operacion = 0;
        for (char i: input.toCharArray()) {
            if (String.valueOf(i).matches("[-+*/^]")){
                operacion = i;
                break;
            }
        }
        if (String.valueOf(operacion).isEmpty()){
            System.out.println("Coudn't identify the operator");
            return;
        }
        // Debug: System.out.println("Input: " + input + "\nOperacion: " + operacion);
        int index = input.indexOf(operacion);
        String[] numbers = getNumbers(index, input);
        String numero1 = numbers[0];
        String numero2 = numbers[1];

        int num1 = convertir(numero1);
        int num2 = convertir(numero2);
        int resultado;
        try {
            resultado = (int) calc(num1, num2, operacion);
        }catch (NullPointerException e){
            System.out.println("Unknow operation (" + operacion + ") ");
            return;
        }
        System.out.println("=> " + convertir(resultado));
    }

    private static String[] getNumbers(int index, String input) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for (int i = 0; i < index; i++){
            num1.append(input.charAt(i));
        }
        for (int i = index+1; i < input.length(); i++){
            num2.append(input.charAt(i));
        }
        return new String[]{num1.toString(), num2.toString()};

    }

    private static Object calc(int num1, int num2, char operacion) throws NullPointerException{
        NullPointerException exception = new NullPointerException();
        return switch (operacion){
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            case '^' -> Math.pow(num1, num2);
            default -> throw exception;
        };
    }

    private static int convertir(String numeroRomano) {
        int numero = 0;

        for (int i = 0; i < numeroRomano.length(); i++) {
            char actual = numeroRomano.charAt(i);
            char siguiente = (i < numeroRomano.length() - 1) ? numeroRomano.charAt(i + 1) : '\0';

            if (actual == 'I') {
                if (siguiente == 'V') {
                    numero += 4;
                    i++;
                } else if (siguiente == 'X') {
                    numero += 9;
                    i++;
                } else {
                    numero += 1;
                }
            } else if (actual == 'V') {
                numero += 5;
            } else if (actual == 'X') {
                if (siguiente == 'L') {
                    numero += 40;
                    i++;
                } else if (siguiente == 'C') {
                    numero += 90;
                    i++;
                } else {
                    numero += 10;
                }
            } else if (actual == 'L') {
                numero += 50;
            } else if (actual == 'C') {
                if (siguiente == 'D') {
                    numero += 400;
                    i++;
                } else if (siguiente == 'M') {
                    numero += 900;
                    i++;
                } else {
                    numero += 100;
                }
            } else if (actual == 'D') {
                numero += 500;
            } else if (actual == 'M') {
                numero += 1000;
            }
        }

        return numero;
    }

    private static String convertir(int num){
        StringBuilder numero = new StringBuilder();
        while(num > 0){
            if(num >= 1000){
                numero.append("M");
                num -= 1000;
            }else if(num >= 900){
                numero.append("CM");
                num -= 900;
            }else if(num >= 500){
                numero.append("D");
                num -= 500;
            }else if(num >= 400){
                numero.append("CD");
                num -= 400;
            }else if(num >= 100){
                numero.append("C");
                num -= 100;
            }else if(num >= 90){
                numero.append("XC");
                num -= 90;
            }else if(num >= 50){
                numero.append("L");
                num -= 50;
            }else if(num >= 40){
                numero.append("XL");
                num -= 40;
            }else if(num >= 10){
                numero.append("X");
                num -= 10;
            }else if(num >= 9){
                numero.append("IX");
                num -= 9;
            }else if(num >= 5){
                numero.append("V");
                num -= 5;
            }else if(num >= 4){
                numero.append("IV");
                num -= 4;
            }else {
                numero.append("I");
                num -= 1;
            }
        }
        return numero.toString();
    }

}