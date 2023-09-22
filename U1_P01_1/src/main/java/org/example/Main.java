package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double base, altura;
        System.out.println("Introduce la base del triangulo: ");
        base = teclado.nextDouble();
        System.out.println("Introduce la altura del triangulo: ");
        altura = teclado.nextDouble();
        double area = (base * altura) / 2;
        System.out.println("Formula: (" + base + " x " + altura + ") / 2");
        System.out.println("Area: " + area + " m^2");

    }
}