package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        ArrayList<Double> coeficientes = new ArrayList<>();
        System.out.print("Introduce el primero coeficiente: ");
        double coef = t.nextDouble();
        coeficientes.add(coef);
        System.out.println("Introduce 0 para dejar de meter numeros");
        while (coef != 0) {
            System.out.print("Introduce el siguinete coeficiente: ");
            coef = t.nextDouble();
            if (coef != 0) coeficientes.add(coef);
        }
        ArrayList<Double> resultRufini = ruffini(coeficientes, new ArrayList<>());
        resultRufini.remove(resultRufini.size()-1);
        for (int i = 0; i < resultRufini.size(); i++) {
            if(i < resultRufini.size()-1)
                System.out.print(resultRufini.get(i) + " * x^" + (resultRufini.size()-i-1 + " + "));
            else
                System.out.print(resultRufini.get(i));
        }

    }

    public static ArrayList<Double> ruffini(ArrayList<Double> coeficientes, ArrayList<Double> alredyTested) {
        ArrayList<Double> resultado = new ArrayList<>();
        resultado.add(coeficientes.get(0));
        double multiplyer = getMultiplyer(coeficientes, alredyTested);
        alredyTested.add(multiplyer);
        for (int i = 1; i < coeficientes.size(); i++) {
            resultado.add(
                    coeficientes.get(i) + (resultado.get(i-1) * multiplyer)
            );
        }
        if (resultado.get(resultado.size()-1) != 0)
            ruffini(coeficientes, alredyTested);

        return resultado;
    }

    private static double getMultiplyer(ArrayList<Double> coeficientes, ArrayList<Double> alredyTested) {
        double lastCoeficient = coeficientes.get(coeficientes.size()-1);
        ArrayList<Double> factores = fact(lastCoeficient);
        ArrayList<Double> factoresdefinitivos = new ArrayList<>();
        for (double i : factores) {
            factoresdefinitivos.add(i);
            factoresdefinitivos.add(-i);
        }
        for (double i : alredyTested)
            factores.remove(i);

        return factoresdefinitivos.get(0);
    }

    private static ArrayList<Double> fact(double numero) {
        ArrayList<Double> factores = new ArrayList<>();
        factores.add(1.0);
        double div = numero;
        double i = 1;
        while (div > i){
            i++;
            if (numero % i == 0){
                if (esPrimo(i)){
                    while (div % i == 0){
                        div /= i;
                        factores.add((i));
                    }
                }
            }

        }
        return factores;
    }

    private static boolean esPrimo(double numero){
        boolean esPrimo = true;
        for(long i = 2; i < numero; i++){
            if (numero % i == 0){
                esPrimo = false;
                break;
            }
        }
        return esPrimo;
    }


}