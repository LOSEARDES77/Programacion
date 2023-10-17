package org.example;

// Conversion de bases //

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        String numero = t.next();
        System.out.print("Introduce la base: ");
        String base = t.next();
        System.out.print("En que lo quieres convertir?: ");
        int basetarget = t.nextInt();
        System.out.println("Numero: " + numero + "  Base: " + base + "\nNumero: " + convertirBase(numero, base, basetarget) + "  Base: " + basetarget);


    }

    public static String convertirBase(String numero, String base, int basetarget) {
        StringBuilder resultado = new StringBuilder();
        String parteEntera = numero.replace('.', ',').split(",")[0];
        String parteDecimal = numero.replace('.', ',').split(",")[1];
        ArrayList<Integer> parteEnteraArray = parseNumeros(parteEntera);
        ArrayList<Integer> parteDecimalArray = parseNumeros(parteDecimal);
        // Crear un metodo para convertir a base 10 y luego convertir a la baseTarget.

        // Para convertir un número de decimal a cualquier base: se divide el número entre
        // la base a convertir e ir acumulando los residuos hasta que el cociente sea 0.
        // El número buscado se acomoda partiendo del último residuo hasta el primero.


        return resultado.toString();
    }

    private static ArrayList<Integer> parseNumeros(String numero){
        ArrayList<Integer> resultado = new ArrayList<>();
        for (char i : numero.toLowerCase().toCharArray())
            switch (i){
                case '1' -> resultado.add(1);
                case '2' -> resultado.add(2);
                case '3' -> resultado.add(3);
                case '4' -> resultado.add(4);
                case '5' -> resultado.add(5);
                case '6' -> resultado.add(6);
                case '7' -> resultado.add(7);
                case '8' -> resultado.add(8);
                case '9' -> resultado.add(9);
                case 'a' -> resultado.add(10);
                case 'b' -> resultado.add(11);
                case 'c' -> resultado.add(12);
                case 'd' -> resultado.add(13);
                case 'e' -> resultado.add(14);
                case 'f' -> resultado.add(15);
                case 'g' -> resultado.add(16);
                case 'h' -> resultado.add(17);
                case 'i' -> resultado.add(18);
                case 'j' -> resultado.add(19);
                case 'k' -> resultado.add(20);
                case 'l' -> resultado.add(21);
                case 'm' -> resultado.add(22);
                case 'n' -> resultado.add(23);
                case 'o' -> resultado.add(24);
                case 'p' -> resultado.add(25);
                case 'q' -> resultado.add(26);
                case 'r' -> resultado.add(27);
                case 's' -> resultado.add(28);
                case 't' -> resultado.add(29);
                case 'u' -> resultado.add(30);
                case 'v' -> resultado.add(31);
                case 'w' -> resultado.add(32);
                case 'x' -> resultado.add(33);
                case 'y' -> resultado.add(34);
                case 'z' -> resultado.add(35);
            }

        return resultado;
    }
}