package org.Ej2;

public class Asalariado extends Cooperante{
    double sueldo;

    public Asalariado(String nombre, String dni, String pais, double sueldo) {
        super(nombre, dni, pais);
        this.sueldo = sueldo;
    }
}
