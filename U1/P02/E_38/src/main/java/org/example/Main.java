package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        double [] numero1 = introducirValores();
        double [] numero2 = introducirValores();
        System.out.print("En que formato quieres el resultado?\n  1) Polar\n  2) Cartesiano\n");
        byte formato = t.nextByte();
        System.out.println("resultado: " + Arrays.toString(multiplicar(numero1, numero2, formato)));
    }

    private static double[] multiplicar(double[] numero1, double[] numero2, byte formato) {
        double[] num1 = new double[2], num2 = new double[2];
        if (numero1[0] == 1){
            num1 = convertToCartesian(numero1[1], numero1[2]);
        }else {
            num1[0] = numero1[1];
            num1[1] = numero1[2];
        }
        if (numero2[0] == 1){
            num2 = convertToCartesian(numero2[1], numero2[2]);
        }else {
            num2[0] = numero2[1];
            num2[1] = numero2[2];
        }
        double[] resultado = new double[]{
                num1[0]*num2[0],
                num1[1]*num2[1]
        };

        if (formato == 1)
            return convertToPolar(resultado[0], resultado[1]);
        else
            return resultado;

    }

    private static double[] introducirValores(){
        Scanner t = new Scanner(System.in);
        System.out.print("En que formato lo quieres introducir?: \n  1) Polar\n  2) Cartesiano\n");
        byte eleccion = t.nextByte();
        double valor1 = 0;
        double valor2 = 0;
        if (eleccion == 1){
            System.out.print("Introduce el modulo del vector: ");
            valor1 = t.nextDouble();
            System.out.print("Introduce el angulo del vector: ");
            valor2 = t.nextDouble();
        }else if (eleccion == 2){
            System.out.print("Introduce la parte real del numero: ");
            valor1 = t.nextDouble();
            System.out.print("Introduce la parte imaginaria del numero: ");
            valor2 = t.nextDouble();
        }else {
            System.out.println("Valor no valido");
            return introducirValores();
        }
        return new double[]{
                eleccion,
                valor1,
                valor2
        };
    }

    private static double[] convertToCartesian(double modulo, double angulo) {
        return new double[] {
                modulo * Math.cos(angulo),
                modulo * Math.sin(angulo)
        };
    }

    private static double[] convertToPolar(double parteReal, double parteImagin){
        return new double[] {
                Math.sqrt(Math.pow(parteReal, 2) + Math.pow(parteImagin, 2)),
                Math.atan(parteImagin/parteReal)
        };
    }
}