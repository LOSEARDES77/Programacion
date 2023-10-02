package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<String> diasDeLaSemana = new ArrayList<>();
        diasDeLaSemana.add("Lunes");
        diasDeLaSemana.add("Martes");
        diasDeLaSemana.add("Miercoles");
        diasDeLaSemana.add("Juebes");
        diasDeLaSemana.add("Viernes");
        diasDeLaSemana.add("Sabado");
        diasDeLaSemana.add("Domingo");
        System.out.print("Introduce un numero: ");
        int num = teclado.nextInt();
        while(validateNumber(num)){
            System.out.println("Dia: " + diasDeLaSemana.get(num-1));
            System.out.print("Introduce un numero: ");
            num = teclado.nextInt();
        }

    }

    private static boolean validateNumber(int num) {
        return num <= 7 && num >= 1;
    }
}