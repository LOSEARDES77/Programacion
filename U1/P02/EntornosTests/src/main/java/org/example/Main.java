package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Propietario prop1 = new Propietario("12345678F", "Pepe");
        Animal animal = new Animal(1, "Oso", prop1);

        System.out.println(prop1);
        System.out.println(animal);
    }
}