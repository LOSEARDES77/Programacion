package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        while (true) {
            System.out.println("Que quieres hacer?\n   1) Cartesiano a Polar\n   2) Polar a Cartesiano\n   3) Salir");
            byte respuesta = t.nextByte();
            if (respuesta == 1) {
                System.out.print("Introduce la parte real del numero complejo: ");
                double parteReal = t.nextDouble();
                System.out.print("Introduce la parte imaginaria del numero complejo: ");
                double parteImagin = t.nextDouble();
                System.out.println("Coordenadas polares: " + Arrays.toString(convertToPolar(parteReal, parteImagin)));
                break;
            } else if (respuesta == 2) {
                System.out.print("Introduce el modulo cel vector: ");
                double modulo = t.nextDouble();
                System.out.print("Introduce el angulo del vector: ");
                double angulo = t.nextDouble();
                System.out.println("Coordenadas cartesianas: " + Arrays.toString(convertToCartesian(modulo, angulo)));
                break;
            }else if (respuesta == 3)
                break;
            else
                System.out.println("Respuesta no valida");
        }
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