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
        ArrayList<Double> notas2 = new ArrayList<>();

        double media = 0;
        int count = 1;
        for (Double i : notas) {
            media += i;
        }
        media /= notas.size();
        for (Double i : notas){
            if (i > media){
                System.out.println("Nota " + count + ": " + (i+1));
                notas2.add(i+1);
            }else {
                System.out.println("Nota " + count + ": " + i);
                notas2.add(i);
            }
            count++;
        }
        System.out.println("Media: " + media);
        System.out.print("Notas superiores a la media: ");
        for (Double i : notas2) {
            if(i > media){
                System.out.print(i + " ");
            }
        }
        System.out.println();
        Collections.sort(notas2);
        System.out.println("Peor Nota: " + notas2.get(0));
        System.out.println("Mejor Nota: " + notas2.get(notas2.size()-1));
    }
}