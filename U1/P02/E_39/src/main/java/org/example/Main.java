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
        while(coef != 0){
            System.out.print("Introduce el siguinete coeficiente: ");
            coef = t.nextDouble();
            if (coef != 0)
                coeficientes.add(coef);
        }
        ArrayList<Double> resultRufini = ruffini(coeficientes);

    }

    public static ArrayList<Double> ruffini(ArrayList<Double> coeficientes){
        ArrayList<Double> resultado = new ArrayList<>();
        resultado.add(coeficientes.get(0));
        int multiplyer = 1;

        for (int i = 1; i < coeficientes.size(); i++) {
            resultado.add(
                    coeficientes.get(i) - (multiplyer * resultado.get(i-1))
            );
        }

        return resultado;
    }


}