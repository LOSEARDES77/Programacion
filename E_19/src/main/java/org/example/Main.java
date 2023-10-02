package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1) Calendario de un mes");
            System.out.println("2) Calendario de un año");
            System.out.println("3) Día de la semana");
            System.out.println("4) Salir");
            System.out.print("Introduce una opción: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Calendario de un mes");
                    unMes();
                    break;
                case 2:
                    System.out.println("Calendario de un año");
                    unAnio();
                    break;
                case 3:
                    System.out.println("Día de la semana");
                    diaSemana();
                    break;
                case 4:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion > 3 || opcion < 1);
    }

    private static void unMes() {
        System.out.print("Introduce el mes: ");
        int mes = teclado.nextInt();
        System.out.print("Introduce el año: ");
        int anio = teclado.nextInt();
        if (!esValida(1, mes, anio)) {
            System.out.println("Fecha no valida");
            unMes();
            return;
        }
        printMes(mes-1, anio);


    }

    private static void unAnio() {
        System.out.print("Introduce el año: ");
        int anio = teclado.nextInt();
        if (!esValida(1, 1, anio)) {
            System.out.println("Fecha no valida");
            unAnio();
            return;
        }
        System.out.println("\n");
        for (int i = 1; i <= 12; i++) {
            printMes(i, anio);
            System.out.println("\n");
        }

    }

    private static void diaSemana() {
        System.out.print("Introduce el dia: ");
        int dia = teclado.nextInt();
        System.out.print("Introduce el mes: ");
        int mes = teclado.nextInt();
        System.out.print("Introduce el año: ");
        int anio = teclado.nextInt();
        if (!esValida(dia, mes, anio)) {
            System.out.println("Fecha no valida");
            diaSemana();
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.YEAR, anio);
        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("El dia " + dia + " del mes " + parseMonth(mes) + " del año " + anio + " es " + parseDay(diaSemana));
    }

    private static String parseDay(int diaSemana) {
        return switch (diaSemana) {
            case 1 -> "Domingo";
            case 2 -> "Lunes";
            case 3 -> "Martes";
            case 4 -> "Miercoles";
            case 5 -> "Jueves";
            case 6 -> "Viernes";
            case 7 -> "Sabado";
            default -> "ERROR";
        };
    }

    private static boolean esValida(int dia, int mes, int anio) {
        if ((dia < 1 || dia > 31) || (mes < 1 || mes > 12) || (anio < 1900)) {
            return false;
        }else{
            return probarFecha(dia + "-" + mes + "-" + anio);
        }
    }

    private static boolean probarFecha(String fecha){
        try {
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            formatter.setLenient(false);
            Date date = formatter.parse(fecha);
        } catch (ParseException e) {
            System.out.println("Fecha no valida");
            return false;
        }
        return true;
    }

    private static void printMes(int mes, int anio){
        Calendar calendar = Calendar.getInstance();
        int dias = 0;
        int diaSemana = 0;
        if (esValida(1, mes, anio)) {
            calendar.set(Calendar.MONTH, mes-1);
            calendar.set(Calendar.YEAR, anio);
            dias = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        } else {
            System.out.println("Fecha no valida");
            return;
        }
        System.out.println("            " + parseMonth(mes) + " " + anio);
        System.out.println("------------------------------------");
        for (int i = 1; i <= dias; i++) {
            if (diaSemana == 7) diaSemana = 0;
            if (i == 1 && diaSemana != 0) {
                for (int j = 0; j < diaSemana; j++) {
                    System.out.print("     ");
                }
            }
            if (i < 10)System.out.print("  " + i + "  ");
            else System.out.print(" " + i + "  ");

            if (diaSemana == 6) {
                System.out.println();
                diaSemana = -1;
            }
            diaSemana++;
        }
    }

    private static String parseMonth(int month){
        return switch (month) {
            case 1 -> "ENERO";
            case 2 -> "FEBRERO";
            case 3 -> "MARZO";
            case 4 -> "ABRIL";
            case 5 -> "MAYO";
            case 6 -> "JUNIO";
            case 7 -> "JULIO";
            case 8 -> "AGOSTO";
            case 9 -> "SEPTIEMBRE";
            case 10 -> "OCTUBRE";
            case 11 -> "NOVIEMBRE";
            case 12 -> "DICIEMBRE";
            default -> "ERROR";
        };
    }

}