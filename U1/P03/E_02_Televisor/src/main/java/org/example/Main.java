package org.example;

public class Main {
    public static void main(String[] args) {
        Televisor t = new Televisor("Sony", "Trinitron 4", 2003);
        System.out.println("Sexo");
        t.imprimirCaracteristicas();
        t.encender();
        t.obtenerCanal();
        t.bajarCanal();
        t.cambiarCanal(23);
        t.setVolumen(300);
        t.setVolumen(50);
        t.apagar();
        t.cambiarCanal(60);
        t.apagar();
    }
}