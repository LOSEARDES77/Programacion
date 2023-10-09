package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el coeficiente a: ");
        double a = teclado.nextDouble();
        System.out.print("Introduce el coeficiente b: ");
        double b = teclado.nextDouble();
        System.out.print("Introduce el coeficiente c: ");
        double c = teclado.nextDouble();
        double[] resultado = solve(a, b, c);
        if (Double.isNaN(resultado[0]) && Double.isNaN(resultado[1]))
            System.out.println("Solucion: " + handleComplexNumbers(a,b,c));
        else
            System.out.println("Soluciones: " + resultado[0] + " y " + resultado[1]);
    }

    private static double[] solve(double a, double b, double c) {
        if (Math.pow(b, 2) < (4*a*c))
            return new double[]{Double.NaN, Double.NaN};

        double raiz = Math.sqrt(Math.pow(b, 2.0) - (4 * a * c));
        return new double[]{
                (-b + raiz) / (2 * a),
                (-b - raiz) / (2 * a)
        };
    }

    private static String handleComplexNumbers(double a, double b, double c) {
        // TODO fix this method
        double parteReal = -b/(2*a);
        double raiz = Math.pow(b, 2.0) - (4 * a * c) * -1 ;
        double icoef =  Math.sqrt(raiz) / -2;
        return parteReal + " + " + icoef + " i  y  " + parteReal + " - " + icoef + " i";
    }
}