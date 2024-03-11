package org.example;

import java.util.Scanner;

public class Teclado {
    private static final Scanner sc = new Scanner(System.in);

    public static int leerEntero(String msg){
        System.out.print(msg + ": ");
        try{
            return Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Numero no valido. Prueba otra vez.");
            return leerEntero(msg);
        }
    }
    public static double leerReal(String msg){
        System.out.print(msg + ": ");
        try{
            return Double.parseDouble(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Numero no valido. Prueba otra vez.");
            return leerEntero(msg);
        }
    }

    public static boolean leerBooleano(String msg){
        System.out.print(msg + "[Si/No]: ");
        String respuesta = sc.nextLine();
        return respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("y") || respuesta.equalsIgnoreCase("yes");
    }

    public static String leerCadena(String msg){
        System.out.print(msg + ": ");
        return sc.nextLine();
    }
}
