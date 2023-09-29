package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String s = sc.nextLine();
        ArrayList<String> palabras = new ArrayList<>(List.of(s.split(" ")));
        for(String i : palabras){
            System.out.println(i);
        }
        System.out.println("Cantidad de palabras: " + palabras.size());
    }
}