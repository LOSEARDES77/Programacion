package org.example;


import java.util.Scanner;

public class E03_Capicua {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce una cadena: ");
        String cadena = s.nextLine();
        System.out.println("La cadena \"" + cadena + "\" " + ((esCapicua(cadena)) ? "es capicua" : "no es capicua"));
    }

    private static boolean esCapicua(String cadena) {
        if (cadena.length() <= 1)
            return true;
        if (cadena.charAt(0) == cadena.charAt(cadena.length()-1)){
            return esCapicua(cadena.substring(1, cadena.length()-1));
        }
        return false;
    }
}
