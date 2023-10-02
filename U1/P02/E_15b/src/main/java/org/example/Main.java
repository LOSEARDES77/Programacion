package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Cuentos alumnos hay?: ");
        int numero = teclado.nextInt();
        ArrayList<Integer> notas = new ArrayList<>();
        for (int i = 0; i < numero; i++) {
            System.out.print("Introduce una nota: ");
            int tmp = teclado.nextInt();
            notas.add(tmp);
        }
        double media = 0;
        int count = 1;
        for (Integer i :
                notas) {
            System.out.println("Nota " + count + ": " + i);
            media += i;
            count++;
        }
        media /= notas.size();
        System.out.println("Media: " + media);
    }
}