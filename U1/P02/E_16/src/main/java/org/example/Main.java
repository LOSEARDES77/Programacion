package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce una secha (dd-mm-yyyy): ");
        String fecha = teclado.next();
        while(!esValida(fecha)){
            System.out.println("Fecha no valida");
            System.out.print("Introduce una secha (dd-mm-yyyy): ");
            fecha = teclado.next();
        }
        try {
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            formatter.setLenient(false);
            Date date = formatter.parse(fecha);
            System.out.println("Fecha valida " + date);
        }catch (ParseException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static boolean esValida(String fecha){
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            formatter.setLenient(false);
            date = formatter.parse(fecha);
        } catch (ParseException e) {
            System.out.println("Fecha no valida");
            return false;
        }
        return true;
    }
}