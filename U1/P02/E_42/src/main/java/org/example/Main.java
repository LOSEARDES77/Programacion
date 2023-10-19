package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = t.nextLine();
        int[][] numeros = splitFrases(frase);
        System.out.println(calcEdad(numeros));
    }
    public static String calcEdad(int[][] numeros){
        int anioMax = Math.max(numeros[0][0], numeros[0][1]);
        int anioMin = Math.min(numeros[0][0], numeros[0][1]);
        int anios = anioMax - anioMin;

        int meses;

        if (anioMax == numeros[0][0])
            meses = numeros[1][0] - numeros[1][1];
        else
            meses = numeros[1][1] - numeros[1][0];

        if( meses < 0){
            anios--;
            meses += 12;
        }
        return anios + " años " + meses + " meses";
    }

    private static int[][] splitFrases(String frase){
        String[] refinedFrase = frase.replace("/", " ").replace(",", " ").replace(";", " ").split("\\.")[0].split(" ");

        int anioEncontrado = 0;
        int mesEncontrado = 0;
        int[] anios = new int[]{0, 0};
        int[] meses = new int[]{0, 0};

        for (String palabra : refinedFrase){
            if (anioEncontrado == 2 && mesEncontrado == 2) break;
            if (palabra.matches("[0-9]{4}")) {
                anioEncontrado++;
                if ( anios[0] == 0 ) anios[0] = parseNumber(palabra);
                else anios[1] = parseNumber(palabra);
            }
            if (palabra.matches("[0-9]")) {
                mesEncontrado++;
                if ( meses[0] == 0 ) meses[0] = parseNumber(palabra);
                else meses[1] = parseNumber(palabra);
            }
            else if (palabra.matches("[0-9]{2}")) {
                mesEncontrado++;
                if ( meses[0] == 0 ) meses[0] = parseNumber(palabra);
                else meses[1] = parseNumber(palabra);
            }
        }
        return new int[][]{anios, meses};
    }
    private static int parseNumber(String s){
        int num;
        try{
            num = Integer.parseInt(s);
        }catch(NumberFormatException e){
            System.out.println("Parse error");
            num = -1;
        }
        return num;
    }

    /*
    private static ArrayList<String> toArrayList(String[] s) {
        return new ArrayList<>(Arrays.asList(s));
    }

    public static boolean check(int a){
        return a > 0;
    }
    private static int[] getMonthAndYear(ArrayList<String> frase){
        ArrayList<String> refinedFrase = new ArrayList<>();
        for (String s : frase){
            String[] tmp = s.replace("/", " ").split(" ");
            refinedFrase.addAll(Arrays.asList(tmp));
        }
        int[] num = new int[2];
        for (String s : refinedFrase) {

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

    private static ArrayList<String> getFraseNacimiento(ArrayList<String> frase1, ArrayList<String> frase2) {
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

    private static ArrayList<String> getFraseFallecimiento(ArrayList<String> frase1, ArrayList<String> frase2) {
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

    Main method:

        ArrayList<String> frase1 = frases[0];
        ArrayList<String> frase2 = frases[1];

        ArrayList<String> fraseFallecimiento = getFraseFallecimiento(frase1, frase2);
        ArrayList<String> fraseNacimiento = getFraseNacimiento(frase1, frase2);

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

*/
}