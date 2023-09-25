package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int numero = teclado.nextInt();
        ArrayList<Object> divisores = new ArrayList<>();
        for (int i = 1; i < numero; i++){
            if (numero%i == 0){
                divisores.add(i);
            }
        }
        System.out.print("Divisores: ");
        for (int i = 0; i < divisores.size(); i++){
            if (i + 1 < divisores.size()){
                System.out.print(divisores.get(i) + ", ");
            }else System.out.println(divisores.get(i) + ".");
        }
    }
}