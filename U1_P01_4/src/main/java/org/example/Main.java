package org.example;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Calendar CALENDARIO = Calendar.getInstance();
        final short AÑO = (short) CALENDARIO.get(Calendar.YEAR);
        final short MES = (short) CALENDARIO.get(Calendar.MONTH);
        final short DIA = (short) CALENDARIO.get(Calendar.DAY_OF_MONTH);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Cual es tu edad? : ");
        short edad = teclado.nextShort();
        System.out.println("Que dia naciste? (numero de dia): ");
        short diaNacimiento = teclado.nextShort();
        System.out.println("Que mes naciste? (numero de mes): ");
        short mesNacimiento = teclado.nextShort();

        // Validar la fecha introducida
        if (diaNacimiento > 31 || diaNacimiento < 1 || mesNacimiento > 12 || mesNacimiento < 1) {
            System.out.println("Fecha introducida no valida");
            return;
        }

        short añoNacimiento = (short) (AÑO - edad);

        if (mesNacimiento > MES) {
            añoNacimiento--;
        } else if (mesNacimiento == MES) {
            if (diaNacimiento > DIA) {
                añoNacimiento--;
            }
        }

        System.out.println("Naciste el "+ diaNacimiento + "/" + mesNacimiento + "/" + añoNacimiento );
    }
}