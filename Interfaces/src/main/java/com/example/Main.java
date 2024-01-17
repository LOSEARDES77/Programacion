package com.example;


import java.util.EventListener;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Pepe", "Almarcegui Rodrigo", "82938497J");
        Persona p2 = new Persona("Juan", "Perez Garcia", "12345678A");
        Persona p3 = new Persona("Maria", "Lopez Sanchez", "23456789B");
        Persona p4 = new Persona("Ana", "Gomez Torres", "34567890C");
        Persona p5 = new Persona("Carlos", "Martinez Ruiz", "45678901D");
        Autobus a = new Autobus("1929-PAM", 90, 90, 7.8, 30);

        a.repostar(40);
        a.arrancarMotor();
        a.subirPasajero(p1);
        a.subirPasajero(p2);
        a.subirPasajero(p3);

        a.fijarVelocidad(60);
        a.recorrerKilometros(10);
        a.fijarVelocidad(0);

        a.bajarPersona(p2);
        a.subirPasajero(p4);

        a.fijarVelocidad(80);
        a.recorrerKilometros(20);
        a.fijarVelocidad(0);

        a.subirPasajero(p5);

        Persona[] pasajeros = a.getEstadoOcupacion();
        for (int i = 0; i < pasajeros.length; i++){
            if (pasajeros[i] == null) {
                a.log("El asiento " + (i + 1) + " esta vacio");
            }else {
                a.log("El asiento " + (i + 1) + " esta ocupado por " + pasajeros[i].getNombre() + " " + pasajeros[i].getApellido());
            }
        }

        a.fijarVelocidad(70);
        a.recorrerKilometros(30);
        a.fijarVelocidad(0);

    }
}