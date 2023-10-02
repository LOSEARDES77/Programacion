package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Cuantos nombres quieres introducir?: ");
        int numero = teclado.nextInt();
        while (numero <= 0 || numero > 500){
            System.out.print("Numero no valido, prueba otra vez: ");
            numero = teclado.nextInt();
        }
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < numero; i++){
            System.out.print("Introduce un nombre: ");
            String tmp = teclado.next();
            lista.add(tmp);
        }
        Collections.sort(lista);
        System.out.print("Primero de la lista: " + lista.get(0));

    }
}