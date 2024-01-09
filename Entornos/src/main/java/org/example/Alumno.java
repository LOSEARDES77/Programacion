package org.example;

public class Alumno extends Persona {

    private final int codAlumno;
    public void estudiar(){
        System.out.println("Alumno estudiando...");
    }

    public Alumno(String nombre, String apellido, int codAlumno) {
        super(nombre, apellido);
        this.codAlumno = codAlumno;
    }


}
