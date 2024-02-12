package org.Ej2;

public class Voluntario extends Cooperante{
    String ong;

    public Voluntario(String nombre, String dni, String pais, String ong) {
        super(nombre, dni, pais);
        this.ong = ong;
    }
}
