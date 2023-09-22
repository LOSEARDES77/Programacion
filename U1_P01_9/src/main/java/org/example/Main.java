package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("conversor de yenes a euros y vicebersa\n");
        double resultado;
        while(true){
            System.out.println("Que quieres hacer?");
            System.out.println("   0) Salir");
            System.out.println("   1) Yenes a euros");
            System.out.println("   2) Euros a yenes");
            String respuesta = teclado.next().toLowerCase();
            if(respuesta.equals("0")){
                System.out.println("Hasta pronto!");
                break;
            } else if (respuesta.equals("1")) {
                resultado = yenes();
                System.out.println("Yenes: " + resultado);
            } else if (respuesta.equals("2")) {
                resultado = euros();
                System.out.println("Euros: " + resultado);
            }else{
                System.out.println("No entendi lo que querias decir.");
            }
            System.out.println("\n");
        }
    }
    public static double yenes(){
        // 1 JPY = 0.00633910
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce los euros: ");
        double euros = teclado.nextDouble();
        return euros / 0.00633910;


    }

    public static double euros(){
        // 1 JPY = 0.00633910
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce los euros: ");
        double yenes = teclado.nextDouble();
        return yenes * 0.00633910;
    }
}