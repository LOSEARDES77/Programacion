package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Convertidos horas/segundos");
        double resultado = 0.00;
        while (true) {
            System.out.println("Que quieres hacer?(horas/segundos/salir): ");
            String respuesta = teclado.next().toLowerCase();
            if(respuesta.equals("salir") || respuesta.equals("q")){
                System.out.println("Hasta pronto!");
                break;
            }else if(respuesta.equals("h") || respuesta.equals("horas")){
                resultado = horas();
                System.out.println("Resultado: " + resultado);
            }else if(respuesta.equals("s") || respuesta.equals("segundos")){
                resultado = segundos();
                System.out.println("Resultado: " + resultado);
            }else{
                System.out.println("No entendi lo que escribiste");
            }
            System.out.println("\n");
        }
    }

    public static double horas(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce las horas: ");
        double horas = teclado.nextDouble();
        System.out.println("Introduce las minutos: ");
        double minutos = teclado.nextDouble();
        System.out.println("Introduce las segundos: ");
        double segundos = teclado.nextDouble();

        return horas + (minutos / 60) + (segundos / 360);
    }

    public static double segundos(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce las horas: ");
        double horas = teclado.nextDouble();
        System.out.println("Introduce las minutos: ");
        double minutos = teclado.nextDouble();
        System.out.println("Introduce las segundos: ");
        double segundos = teclado.nextDouble();

        return segundos + (minutos * 60) * (horas * 360);
    }
}