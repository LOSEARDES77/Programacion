package org.example;

import java.util.Objects;

public class Animal {
    private int id;
    private String nombre;
    private int edad;
    private Propietario duenio;

    public Propietario getDuenio() {
        return duenio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        return id == animal.id && edad == animal.edad && Objects.equals(nombre, animal.nombre);
    }


    public void setDuenio(Propietario duenio) {
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", Dueño=" + duenio +
                '}';
    }
    public Animal(int id, String nombre, Propietario p) {
        this.id = id;
        this.nombre = nombre;
        this.edad = 0;
        this.duenio = p;
    }

    public Animal(int id, String nombre, int edad, Propietario p) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.duenio = p;
    }

    
}
