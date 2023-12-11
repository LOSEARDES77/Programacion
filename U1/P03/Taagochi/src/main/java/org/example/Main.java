package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tamagochi tama = null;

        while (true){
            Scanner t = new Scanner(System.in);
            System.out.println("1) Crea tamagotchi");
            System.out.println("2) Juega con tu mascota virtual");
            System.out.println("3) Da de comer a tu mascota virtual");
            System.out.println("4) Ver la vida de tu mascota");
            System.out.println("5) Salir");
            System.out.print("Opción: ");
            int opcion = t.nextInt();
            switch (opcion){
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = t.next();
                    System.out.print("Vida máxima: ");
                    int vidaMaxima = t.nextInt();
                    tama = new Tamagochi(nombre, vidaMaxima);
                    break;
                case 2:
                    if (tama == null){
                        System.out.println("No hay tamagochi");
                        break;
                    }
                    tama.jugar();
                    break;
                case 3:
                    if (tama == null){
                        System.out.println("No hay tamagochi");
                        break;
                    }
                    tama.comer();
                    break;
                case 4:
                    if (tama == null){
                        System.out.println("No hay tamagochi");
                        break;
                    }
                    tama.visualizar();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }
    }
}