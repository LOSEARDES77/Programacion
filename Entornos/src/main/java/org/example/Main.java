package org.example;

public class Main {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Pepe", "asd", 123);
        alumno.comer();
        alumno.respirar();
        alumno.estudiar();

        Empleado profesor = new Empleado("Juan", "dsa", 321);
        profesor.comer();
        profesor.respirar();
        profesor.trabajar();
    }
}