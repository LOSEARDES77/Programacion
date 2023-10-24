package org.example;

import java.util.Arrays;

public class Propietario {
    private Animal[] animales;
    private String DNI;
    private String nombre;

    public Propietario(String DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
