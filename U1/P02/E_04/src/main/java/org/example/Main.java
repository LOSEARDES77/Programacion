package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una palabra: ");
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++){
            if (i == s.length()-1){
                System.out.print(s.charAt(i));
            }else{
                System.out.print(s.charAt(i) + " - ");
            }
        }
    }
}