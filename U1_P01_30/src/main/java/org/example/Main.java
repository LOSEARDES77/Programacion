package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Cuantos numeros perfectos quieres calcular?: ");
        long cantidad = teclado.nextLong();
        ArrayList<Long> numerosPerfectos = new ArrayList<>();
        for (long i = 1; numerosPerfectos.size() < cantidad; i++){
            ArrayList<Long> divisores = getDivisores(i);
            long suma = 0;
            for (Long j : divisores){
                suma += j;
            }
            if(suma == i){
                numerosPerfectos.add(i);
            }
        }
        System.out.print("Estos son los " + cantidad + " primeros numeros perfectos: ");
        for (int i = 0; i < numerosPerfectos.size(); i++){
            if (i + 1 < numerosPerfectos.size()){
                System.out.print(numerosPerfectos.get(i) + ", ");
            }else System.out.println(numerosPerfectos.get(i) + ".");
        }
    }

    public static ArrayList<Long> getDivisores(long numero){
        ArrayList<Long> divisores = new ArrayList<>();
        for (long i = 1; i < numero; i++){
            if (numero%i == 0){
                divisores.add(i);
            }
        }
        return divisores;
    }
}