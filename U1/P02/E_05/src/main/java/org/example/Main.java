package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una cadena: ");
        String cadena = sc.nextLine();
        for (int i = cadena.length()-1; i >= 0; i--){
            System.out.print(cadena.charAt(i));
        }
    }
}