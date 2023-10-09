package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> coeficientes = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el valor de la variable x: ");
        double x = teclado.nextDouble();
        System.out.print("Cuantos coeficientes quieres poner?: ");
        long numCoeficientes = teclado.nextLong();
        for (int i = 0; i < numCoeficientes; i++){
            System.out.print("Introduce el coeficiente " + (i + 1) + ": ");
            coeficientes.add(teclado.nextDouble());
        }

        double resultado = 0;
        for (int i = coeficientes.size(); i > 0; i--) {
            // Debug System.out.println("i: " + i);
            // Debug System.out.println("index: " + (coeficientes.size() - i));
            // Debug System.out.println("coef: " + coeficientes.get(coeficientes.size() - i));
            if(i == 1) resultado += coeficientes.get(coeficientes.size() - i);
            else resultado += coeficientes.get(coeficientes.size() - i) * x * (i-1);
            // Debug System.out.println(resultado);
        }
        System.out.println("Resultado: " + resultado);
    }
}