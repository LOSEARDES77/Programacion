package org.example;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Pepe", "Garcia", "17284957J" );
        Persona p2 = new Persona("Ramon", "Lazaro", "19827384T" );
        Coche v1 = new Coche("9876ZYX", 60, 180, 5.6);
        Camion v2 = new Camion("1289ABC", 90, 90, 8.9, 5000);
        Radar r1 = new Radar(60, "España");
        p1.comprarVehiculo(v1);
        p2.comprarVehiculo(v2);
        v1.repostar(20);
        v2.repostar(20);
        p1.usaVehiculo(100, 100, () -> r1.pasaVehiculo(v1));
        p2.usaVehiculo(60, 70, () -> r1.pasaVehiculo(v2));


    }
}