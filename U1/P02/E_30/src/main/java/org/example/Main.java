package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int num = -1;
        while(!esValido(num)) {
            System.out.print("Introduce un numero (0-99): ");
            num = t.nextInt();
            if(esValido(num)) break;
            else System.out.println("Numero no valido");
        }
        System.out.println("Numero: " + num);
        System.out.println("Numero: " + parseNum(num));

    }

    private static String parseNum(int num){
        String numero = "";
        int decenas = num / 10;
        int unidades = num - decenas * 10;
        if (unidades == 0){
            switch (decenas){
                case 0:
                    numero += "cero";
                    break;
                case 1:
                    numero += "diez";
                    break;
                case 2:
                    numero += "veinte";
                    break;
                case 3:
                    numero += "treinta";
                    break;
                case 4:
                    numero += "cuarenta";
                    break;
                case 5:
                    numero += "cincuenta";
                    break;
                case 6:
                    numero += "sesenta";
                    break;
                case 7:
                    numero += "setenta";
                    break;
                case 8:
                    numero += "ochenta";
                    break;
                case 9:
                    numero += "noventa";
                    break;
            }
            return numero;
        }else {
            switch (decenas) {
                case 0:
                    break;
                case 1:
                    switch (unidades) {
                        case 1:
                            numero += "once";
                            break;
                        case 2:
                            numero += "doce";
                            break;
                        case 3:
                            numero += "trece";
                            break;
                        case 4:
                            numero += "catorce";
                            break;
                        case 5:
                            numero += "quince";
                            break;
                        default:
                            numero += "dieci";
                    }
                    break;
                case 2:
                    numero += "veinti";
                    break;
                case 3:
                    numero += "treintai";
                    break;
                case 4:
                    numero += "cuarentai";
                    break;
                case 5:
                    numero += "cincuentai";
                    break;
                case 6:
                    numero += "sesentai";
                    break;
                case 7:
                    numero += "setentai";
                    break;
                case 8:
                    numero += "ochentai";
                    break;
                case 9:
                    numero += "noventai";
                    break;
            }
            if (decenas != 1 || unidades > 5) {
                switch (unidades) {
                    case 1:
                        numero += "uno";
                        break;
                    case 2:
                        numero += "dos";
                        break;
                    case 3:
                        numero += "tres";
                        break;
                    case 4:
                        numero += "cuatro";
                        break;
                    case 5:
                        numero += "cinco";
                        break;
                    case 6:
                        numero += "seis";
                        break;
                    case 7:
                        numero += "siete";
                        break;
                    case 8:
                        numero += "ocho";
                        break;
                    case 9:
                        numero += "nueve";
                        break;
                }
            }
        }
        return numero;
    }

    private static boolean esValido(int num) {
        return num >= 0 && num <= 99;
    }
}