package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int numero = teclado.nextInt();
        if (numero <= 0){
            System.out.println("Solo se admiten numeros positivos");
            return;
        }
        System.out.println("El crapulo de " + numero + " es: " + crapulo(numero));

    }

    public static int crapulo(int numero){
        int crapulo = numero;
        do{
            crapulo = sumaCifras(crapulo);
        }while (crapulo >= 10);


        return crapulo;
    }

    public static int sumaCifras(int numero){
        int suma = 0;
        for (Character i : String.valueOf(numero).toCharArray()){
            suma += Integer.parseInt(String.valueOf(i));
        }
        return suma;
    }
}