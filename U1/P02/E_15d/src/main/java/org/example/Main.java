package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Cuentos alumnos hay?: ");
        int numero = teclado.nextInt();
        ArrayList<Double> notas = new ArrayList<>();
        for (int i = 0; i < numero; i++) {
            System.out.print("Introduce una nota: ");
            double tmp = teclado.nextDouble();
            notas.add(tmp);
        }
        double media = 0;
        int count = 1;
        for (Double i :
                notas) {
            System.out.println("Nota " + count + ": " + i);
            media += i;
            count++;
        }
        media /= notas.size();
        System.out.println("Media: " + media);
        System.out.print("Notas superiores a la media: ");
        for (Double i : notas) {
            if(i > media){
                System.out.print(i + " ");
            }
        }
        System.out.println();
        Collections.sort(notas);
        System.out.println("Peor Nota: " + notas.get(0));
        System.out.println("Mejor Nota: " + notas.get(notas.size()-1));
    }
}