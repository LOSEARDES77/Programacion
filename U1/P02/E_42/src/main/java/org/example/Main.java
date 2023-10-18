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

        int anioNacimiento = getAnio(fraseNacimiento);
        int anioFallecimiento = getAnio(fraseFallecimiento);
        int mesNacimiento = getMes(fraseNacimiento);
        int mesFallecimiento = getMes(fraseFallecimiento);
        System.out.println("Falleci " + anioFallecimiento + " " + mesFallecimiento + "\nNaci " + anioNacimiento + " " + mesNacimiento);

    }

    private static int getAnio(ArrayList<String> frase) {
        int num = 0;
        for (String s : frase){
            if(s.matches("\\d{4}$")){
                try{
                    num = Integer.parseInt(s);
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

    private static int getMes(ArrayList<String> frase) {
        int num = 0;
        for (String s : frase){
            if(s.matches("\\d{2}$")){
                try{
                    num = Integer.parseInt(s);
                    break;
                }catch(NumberFormatException e){
                    System.out.println("Parse error");
                    num = 1;
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