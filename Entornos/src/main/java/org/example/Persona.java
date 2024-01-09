package org.example;

public class Persona {
    private final String nombre;
    private final String apellido;
    public void respirar(){
        String tipo;
        if (this instanceof Alumno)
            tipo = "Alumno";
        else if (this instanceof Empleado)
            tipo = "Empleado";
        else
            tipo = "Persona";
        System.out.println( tipo + " respirando...");
    }

    public void comer(){
        String tipo;
        if (this instanceof Alumno)
            tipo = "Alumno";
        else if (this instanceof Empleado)
            tipo = "Empleado";
        else
            tipo = "Persona";
        System.out.println( tipo + " comiendo...");
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
