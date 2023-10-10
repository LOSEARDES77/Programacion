package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("Introduce le precio total: ");
        long precio = (long) (t.nextDouble() * 100);
        System.out.print("Introduce cuanto te han pagado: ");
        long pagado = (long) (t.nextDouble() * 100);
        long[] devolver = calcCambio(precio, pagado);
        String format = "";
        for (int i = 0; i < devolver.length; i++) {
            if (devolver[i] != 0) {
                format += switch (i) {
                    case 0 -> "500 - ";
                    case 1 -> "200 - ";
                    case 2 -> "100 - ";
                    case 3 -> "50 - ";
                    case 4 -> "20 - ";
                    case 5 -> "10 - ";
                    case 6 -> "5 - ";
                    case 7 -> "2 - ";
                    case 8 -> "1 - ";
                    case 9 -> "0,50 - ";
                    case 10 -> "0,20 - ";
                    case 11 -> "0,10 - ";
                    case 12 -> "0,05 - ";
                    case 13 -> "0,02 - ";
                    case 14 -> "0,01 - ";
                    default -> "";
                };
                format += devolver[i] + "\n";
            }
        }if(format.isEmpty()) format = "Cambio exacto!";
        System.out.println(format);


    }

    private static long[] calcCambio(long precio, long pagado){
        long[] resultado = new long[15];
        long aDevolver = pagado - precio;
        while(aDevolver >= 50000){
            resultado[0]++;
            aDevolver -= 50000;
        }while(aDevolver >= 20000){
            resultado[1]++;
            aDevolver -= 20000;
        }while(aDevolver >= 10000){
            resultado[2]++;
            aDevolver -= 10000;
        }while(aDevolver >= 5000){
            resultado[3]++;
            aDevolver -= 5000;
        }while(aDevolver >= 2000){
            resultado[4]++;
            aDevolver -= 2000;
        }while(aDevolver >= 1000){
            resultado[5]++;
            aDevolver -= 1000;
        }while(aDevolver >= 500){
            resultado[6]++;
            aDevolver -= 500;
        }while(aDevolver >= 200){
            resultado[7]++;
            aDevolver -= 200;
        }while(aDevolver >= 100){
            resultado[8]++;
            aDevolver -= 100;
        }while(aDevolver >= 50){
            resultado[9]++;
            aDevolver -= 50;
        }while(aDevolver >= 20){
            resultado[10]++;
            aDevolver -= 20;
        }while(aDevolver >= 10){
            resultado[11]++;
            aDevolver -= 10;
        }while(aDevolver >= 5){
            resultado[12]++;
            aDevolver -= 5;
        }while(aDevolver >= 2){
            resultado[13]++;
            aDevolver -= 2;
        }while(aDevolver >= 1){
            resultado[14]++;
            aDevolver -= 1;
        }
        return resultado;
    }
}