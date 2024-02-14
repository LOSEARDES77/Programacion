package org.zaragoza2023;

import java.util.Scanner;

public class InvertirPalabras {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true){
            String input = s.nextLine();
            System.out.println(new StringBuilder(input).reverse());
        }
    }
}
