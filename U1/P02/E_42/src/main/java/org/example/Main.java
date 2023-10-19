package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String[] frases = t.nextLine().split(";");

        ArrayList<String> fraseFallecimiento = getFraseFallecimiento(frases);
        ArrayList<String> fraseNacimiento = getFraseNacimiento(frases);

        if (fraseFallecimiento.isEmpty()|| fraseNacimiento.isEmpty()){
            System.out.println("Error: Invalid input");
            return;
        }
        int[] anioYMesNac = getMonthAndYear(fraseNacimiento);
        int anioNacimiento = anioYMesNac[1];
        int mesNacimiento = anioYMesNac[0];

        int[] anioYMesMort = getMonthAndYear(fraseFallecimiento);
        int anioFallecimiento = anioYMesMort[1];
        int mesFallecimiento = anioYMesMort[0];
        int[] checks = new int[]{anioNacimiento, mesNacimiento, anioFallecimiento, mesFallecimiento};
        boolean check = false;
        for (int i = 0; i < 4; i++) {
            if (!check(checks[i])){
                String error = "Error: coudn't read " + switch (i){
                    case 0 -> "Año Nacimiento";
                    case 1 -> "Mes Nacimiento";
                    case 2 -> "Año Muerte";
                    case 3 -> "Mes Muerte";
                    default -> "anything";
                };
                System.out.println(error);
                check = true;
            }
        }
        if (check)
            return;

        System.out.println("Edad: " + calcEdad(anioNacimiento, mesNacimiento, anioFallecimiento, mesFallecimiento));

    }

    public static boolean check(int a){
        return a > 0;
    }

    public static String calcEdad(int anioNac, int mesNac, int anioMort, int mesMort){
        int anios = anioMort-anioNac;
        int meses = mesMort-mesNac;
        if( meses < 0){
            anios--;
            meses += 12;
        }
        return anios + " años " + meses + " meses";
    }

    private static int getAnio(ArrayList<String> frase) {
        int num = 0;
        for (String s : frase){
            if(s.matches("[0-9]{4}")){
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (String.valueOf(s.charAt(i)).matches("[0-9]{1}"))
                        temp.append(s.charAt(i));
                }
                System.out.println("String año " + s + " tmp " + temp);
                try{
                    num = Integer.parseInt(temp.toString());
                    break;
                }catch(NumberFormatException e){
                    System.out.println("Parse error");
                    num = 1;
                }
            }
        }
        if (num == 0)
            System.out.println("Year not found");
        return num;
    }

    private static int[] getMonthAndYear(ArrayList<String> frase){
        int[] num = new int[2];
        for (String s : frase) {
            int length = 0;
            StringBuilder number = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (String.valueOf(s.charAt(i)).matches("[0-9]")) {
                    length++;
                    number.append(s.charAt(i));
                }
            }
            if (length == 1 || length == 2){
                num[0] = parseNumber(number.toString());
            } else if (length == 4) {
                num[1] = parseNumber(number.toString());
            }
        }
        return num;
    }

    private static int parseNumber(String s){
        int num = 0;
        try{
            num = Integer.parseInt(s);
        }catch(NumberFormatException e){
            System.out.println("Parse error");
            num = -1;
        }

        return num;

    }

    private static int getMes(ArrayList<String> frase) {
        int num = 0;
        for (String s : frase){
            if(s.matches("[0-9]{2}$")){
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (String.valueOf(s.charAt(i)).matches("[0-9]{1}"))
                        temp.append(s.charAt(i));
                }
                System.out.println("String mes " + s + " tmp " + temp);
                try{
                    num = Integer.parseInt(temp.toString());
                    break;
                }catch(NumberFormatException e){
                    System.out.println("Parse error");
                    num = -1;
                }
            }
        }
        if (num == 0)
            System.out.println("Mes not found");
        return num;
    }

    private static ArrayList<String> getFraseNacimiento(String[] frases) {
        ArrayList<String> frase1 = toArrayList(frases[0]);
        ArrayList<String> frase2 = toArrayList(frases[1]);
        ArrayList<String> palabras = toArrayList(new String[]{ "nace", "nacido", "nacio", "nacimiento" });

        for (String s: frase1) {
            if (palabras.contains(s.toLowerCase()))
                return frase1;
        }

        for (String s: frase2) {
            if (palabras.contains(s.toLowerCase()))
                return frase2;
        }

        return new ArrayList<>();
    }

    private static ArrayList<String> getFraseFallecimiento(String[] frases) {
        ArrayList<String> frase1 = toArrayList(frases[0]);
        ArrayList<String> frase2 = toArrayList(frases[1]);
        ArrayList<String> palabras = toArrayList(new String[]{ "fallecio", "fallece", "fallecido", "murio", "muerto", "muere" });

        for (String s: frase1) {
            if (palabras.contains(s.toLowerCase()))
                return frase1;
        }

        for (String s: frase2) {
            if (palabras.contains(s.toLowerCase()))
                return frase2;
        }

        return new ArrayList<>();
    }

    private static ArrayList<String> toArrayList(String[] s) {
        return new ArrayList<>(Arrays.asList(s));
    }

    private static ArrayList<String> toArrayList(String s){
        return new ArrayList<>(Arrays.asList(s.split(" ")));
    }


}