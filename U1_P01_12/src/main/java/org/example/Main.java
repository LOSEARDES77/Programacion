package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Conversor de Celsius/Fahrenheit");
        double resultado;
        while(true){
            System.out.println("Que quieres hacer?");
            System.out.println("   0) Salir");
            System.out.println("   1) Celsius a Fahrenheit");
            System.out.println("   2) Fahrenheit a Celsius");
            String respuesta = teclado.next().toLowerCase();
            if(respuesta.equals("0")){
                System.out.println("Hasta pronto!");
                break;
            }else if(respuesta.equals("1")){
                resultado = fahren();
                System.out.println("Fahrenheit: " + resultado);
            }else if(respuesta.equals("2")){
                resultado = celsius();
                System.out.println("Celsius: " + resultado);
            }else{
                System.out.println("No entendi lo que escribiste");
            }
        }
    }

    public static double fahren(){
        Scanner teclaod = new Scanner(System.in);
        System.out.println("Introduce los grados Celsius: ");
        double celsius = teclaod.nextDouble();
        return ( (double) 9 / 5 ) * celsius + 32;
    }

    public static double celsius(){
        Scanner teclaod = new Scanner(System.in);
        System.out.println("Introduce los grados Celsius: ");
        double fahren = teclaod.nextDouble();
        return fahren / ( (double) 9 / 5 ) - 32;
    }
}