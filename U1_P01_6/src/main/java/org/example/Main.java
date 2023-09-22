package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce las horas: ");
        double horas = teclado.nextDouble();
        System.out.println("Introduce las minutos: ");
        double minutos = teclado.nextDouble();
        System.out.println("Introduce las segundos: ");
        double segundos = teclado.nextDouble();

        double horasTotales = horas + (minutos / 60) + (segundos / 360);
        System.out.println("Horas totales: " + horasTotales);

    }
}