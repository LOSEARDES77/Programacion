package org.Ej3.interfaz;

import java.util.Scanner;

public class Leer {
    private static Scanner sc = new Scanner(System.in);

    public static String cadena() {
        return sc.nextLine();
    }

    public static int entero() {
        try  {
            return Integer.parseInt(cadena());
        }catch (NumberFormatException e) {
            System.out.println("Error: Debe introducir un número entero");
            return entero();
        }
    }


    public static double decimal() {
        try {
            return Double.parseDouble(cadena());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe introducir un número decimal");
            return decimal();
        }
    }

    public static char caracter() {
        return cadena().charAt(0);
    }

    public static String cadena(String msg) {
        System.out.print(msg + ": ");
        return cadena();
    }

    public static int entero(String msg) {
        try{
            System.out.print(msg + ": ");
            return entero();
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe introducir un número entero");
            return entero(msg);
        }
    }

    public static double decimal(String msg) {
        try {
            System.out.print(msg + ": ");
            return decimal();
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe introducir un número decimal");
            return decimal(msg);
        }
    }

    public static char caracter(String msg) {
        System.out.print(msg + ": ");
        return caracter();
    }

    public static boolean siOno(String s) {
        System.out.print(s + " (s/n): ");
        char c = caracter();
        return c == 's' || c == 'S';
    }
}
