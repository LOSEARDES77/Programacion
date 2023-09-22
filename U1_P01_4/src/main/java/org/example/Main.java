package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cual es tu edad? : ");
        short edad = teclado.nextShort();
        System.out.println("Que dia naciste? (numero de dia): ");
        short diaNacimiento = teclado.nextShort();
        System.out.println("Que mes naciste? (numero de mes): ");
        short mesNacimiento = teclado.nextShort();
        System.out.println("Introduce que dia es hoy (Numero): ");
        short dia = teclado.nextShort();
        System.out.println("Introduce que mes es hoy (Numero): ");
        short mes = teclado.nextShort();
        System.out.println("Introduce que año es hoy (Numero): ");
        short año = teclado.nextShort();

        short añoNacimiento = (short) (año - edad);

        if(mesNacimiento == mes ){
            if(diaNacimiento < dia){
                añoNacimiento++;
            }
        } else if (mesNacimiento < mes) {
            añoNacimiento++;
        }

        System.out.println("Naciste el "+ diaNacimiento + "/" + mesNacimiento + "/" + añoNacimiento );
    }
}