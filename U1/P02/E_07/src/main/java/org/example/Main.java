package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String s = sc.nextLine();
        for (int i = 0; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                System.out.print(s.charAt(j));
            }
            System.out.println();
        }
    }
}