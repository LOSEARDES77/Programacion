package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce una palabra: ");
        String s = teclado.nextLine();
        System.out.println(esPalindromo(s));
    }

    public static boolean esPalindromo(String s){
        List<String> a = List.of(s.split(""));
        List<String> b = new ArrayList<>();
        for (int i = a.size()-1; i >= 0; i--){
            b.add(a.get(i));
        }
        return Objects.equals(a, b);
    }
}