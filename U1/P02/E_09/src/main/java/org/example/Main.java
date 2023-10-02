package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine();
        System.out.print("Introduce un numero del 1 al 5: ");
        int num = sc.nextInt();
        StringBuilder frase2 = new StringBuilder();
        for (int i = 0; i < frase.length(); i++){
            int ascii = (int) frase.charAt(i) + num;
            char letra = (char) ascii;
            frase2.append(letra);
        }
        System.out.println(frase2);
    }
}