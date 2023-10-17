package org.example;

// Conversion de bases //

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        String numero = t.next();
        System.out.print("Introduce la base: ");
        int base = t.nextInt();
        System.out.print("En que lo quieres convertir?: ");
        int basetarget = t.nextInt();
        System.out.println("Numero: " + numero + "  Base: " + base + "\nNumero: " + convertirBase(numero, base, basetarget) + "  Base: " + basetarget);


    }

    public static String convertirBase(String numero, int base, int baseTarget) {
        StringBuilder resultado = new StringBuilder();
        String parteEntera = numero.replace('.', ',').split(",")[0];
        String parteDecimal = numero.replace('.', ',').split(",")[1];
        ArrayList<Integer> parteEnteraArray = parseNumeros(parteEntera);
        ArrayList<Integer> parteDecimalArray = parseNumeros(parteDecimal);
        long baseTenParteEntera = toBaseTen(parteEnteraArray, base);
        long baseTenParteDecimal = toBaseTen(parteDecimalArray, base);
        ArrayList<Integer> digitos = new ArrayList<>();
        int cociente = (int) (baseTenParteEntera / baseTarget);
        digitos.add((int) (baseTenParteEntera % baseTarget));
        while(cociente > 0){
            cociente /= baseTarget;
            digitos.add(cociente % baseTarget);
        }
        resultado.append(parseNumeros(digitos));


        return resultado.toString();
    }


    public static long toBaseTen(ArrayList<Integer> num, int base){
        long result = 0;
        for (int i = 0; i < num.size(); i++) {
            result += (long) (num.get(i) * Math.pow(base, i));
        }
        return result;
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
    private static String parseNumeros(ArrayList<Integer> digitos){
        StringBuilder resultado = new StringBuilder();
        for (int i : digitos)
            switch (i){
                case 1 -> resultado.append('1');
                case 2 -> resultado.append('2');
                case 3 -> resultado.append('3');
                case 4 -> resultado.append('4');
                case 5 -> resultado.append('5');
                case 6 -> resultado.append('6');
                case 7 -> resultado.append('7');
                case 8 -> resultado.append('8');
                case 9 -> resultado.append('9');
                case 10 -> resultado.append('c');
                case 11 -> resultado.append('b');
                case 12 -> resultado.append('d');
                case 13 -> resultado.append('d');
                case 14 -> resultado.append('e');
                case 15 -> resultado.append('f');
                case 16 -> resultado.append('g');
                case 17 -> resultado.append('h');
                case 18 -> resultado.append('i');
                case 19 -> resultado.append('j');
                case 20 -> resultado.append('k');
                case 21 -> resultado.append('l');
                case 22 -> resultado.append('m');
                case 23 -> resultado.append('n');
                case 24 -> resultado.append('o');
                case 25 -> resultado.append('p');
                case 26 -> resultado.append('q');
                case 27 -> resultado.append('r');
                case 28 -> resultado.append('s');
                case 29 -> resultado.append('t');
                case 30 -> resultado.append('u');
                case 31 -> resultado.append('v');
                case 32 -> resultado.append('w');
                case 33 -> resultado.append('x');
                case 34 -> resultado.append('y');
                case 35 -> resultado.append('z');
            }

        return resultado.toString();
    }
}