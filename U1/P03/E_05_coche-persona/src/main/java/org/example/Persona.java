package org.example;

public class Persona {
    private final String nombre;
    private final String apellidos;
    private final String dni;
    private Coche coche;

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public void comprarCoche(Coche coche) {
        this.coche = coche;
    }

    public void usarCoche(double distancia, double elocidad){

    }

    public Coche getCoche(){
        return this.coche;
    }

}
