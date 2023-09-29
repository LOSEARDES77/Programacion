package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un nombre: ");
        String nombre1 = sc.nextLine().toLowerCase();
        System.out.print("Introduce otro nombre: ");
        String nombre2 = sc.nextLine().toLowerCase();
        if(Objects.equals(nombre1, nombre2)){
            System.out.println("Losnombres son iguales");
        }else {
            System.out.println("Losnombres son diferentes");
        }
        System.out.println("Mayusculas:\nNombre 1: " +nombre1.toUpperCase() + "\nNombre 2: " + nombre2.toUpperCase());
        System.out.println("Minusculas:\nNombre 1: " +nombre1.toLowerCase() + "\nNombre 2: " + nombre2.toLowerCase());

    }
}