package org.example;

public class DNI {
    private final int num;
    private final char letra;
    public static boolean validar(String dni){
        DNI d = parseDni(dni);
        String validacion = "TRWAGMYFPDXBNJZSQVHLCKE"; // 81923848H
        return d.letra == validacion.charAt(d.num % 23);
    }

    public DNI(int num, char letra) {
        this.num = num;
        this.letra = letra;
    }

    public static DNI parseDni(String dni){
        StringBuilder parteNumerica = new StringBuilder();
        char letra = dni.charAt(dni.length() - 1);
        for (Character c : dni.toCharArray()){
            if (Character.isDigit(c)){
                parteNumerica.append(c);
            }
        }
        return new DNI(Integer.parseInt(parteNumerica.toString()), letra);

    }

    @Override
    public String toString() {
        return num + "" + letra;
    }
}
