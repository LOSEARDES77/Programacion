package org.example;

import java.util.List;

public class DNI {
    private final char letraInicial;
    private final char letraFinal;
    private final int numero;
    private final int parteNumerica;


    public DNI(String dni) {

        StringBuilder tmpNum = new StringBuilder();
        for (int i = 0; i < dni.length() ; i++){
            if (Character.isDigit(dni.charAt(i))){
                tmpNum.append(dni.charAt(i));
            }else {
                if (i > 0 && i < dni.length() - 1){
                    if (Character.isDigit(dni.charAt(i + 1))){
                        this.letraInicial = 0;
                        this.letraFinal = 0;
                        this.numero = 0;
                        this.parteNumerica = 0;
                        return;
                    }
                }
            }
        }
        if (String.valueOf(dni.charAt(0)).matches("[0-9]")){
            this.letraInicial = '#';
        } else {
            List<Character> letrasInicialesCorrectas = List.of('X', 'Y', 'Z', '#');
            char tmpLetraInicial = String.valueOf(dni.charAt(0)).toUpperCase().charAt(0);
            if (!letrasInicialesCorrectas.contains(tmpLetraInicial)){
                this.letraInicial = 0;
                this.letraFinal = 0;
                this.numero = 0;
                this.parteNumerica = 0;
                return;
            }
            this.letraInicial = tmpLetraInicial;
            dni = dni.substring(1);
        }
        this.numero = Integer.parseInt(tmpNum.toString());
        String tmpLetraFinal = String.valueOf(dni.charAt(dni.length() -1));
        if (tmpLetraFinal.matches("[0-9]")){
            this.letraFinal = getLetter(this.numero);
        } else {
            this.letraFinal = tmpLetraFinal.toUpperCase().charAt(0);
        }

        switch (letraInicial){
            case 'Y':
                this.parteNumerica = 1000000 + numero;
                break;
            case 'Z':
                this.parteNumerica = 2 * 1000000 + numero;
                break;
            default:
                this.parteNumerica = numero;
                break;
        }


    }

    private static char getLetter(int num) {
        int resto = num % 23;
        String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";
        return cadena.charAt(resto);
    }

    public boolean DNICorrecto(){
        List<Character> letrasInicialesCorrectas = List.of('X', 'Y', 'Z', '#');
        List<Character> letrasFinalesCorrectas = List.of('T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E');
        String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";

        return cadena.charAt(numero % 23) == letraFinal && letrasFinalesCorrectas.contains(letraFinal) && letrasInicialesCorrectas.contains(letraInicial);
    }

    @Override
    public String toString() {
        // return "%c - %08d - %08d - %c".formatted(letraInicial, parteNumerica, numero, letraFinal);
        if (letraInicial == '#'){
            return String.format("DNI %08d-%c", numero, letraFinal);
        }else {
            return String.format("NIE %c%07d-%c", letraInicial, numero, letraFinal);
        }
    }
}
