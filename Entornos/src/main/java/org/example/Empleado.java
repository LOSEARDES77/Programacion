package org.example;

public class Empleado extends Persona {

    private final int codEmpleado;
    public Empleado(String nombre, String apellido, int codEmpleado) {
        super(nombre, apellido);
        this.codEmpleado = codEmpleado;
    }

    public void trabajar(){
        System.out.println("Empleado trabajando...");
    }
}
