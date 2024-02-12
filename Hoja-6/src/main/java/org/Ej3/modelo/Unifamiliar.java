package org.Ej3.modelo;

import java.util.ArrayList;

public class Unifamiliar extends Vivienda {

    private final int metrosJardin;

    public Unifamiliar(String direccion, double precio, int arraySize, int metrosJardin) {
        super(direccion, precio, arraySize);
        if (metrosJardin < 0)
            throw new IllegalArgumentException("Los metros de jardín no son válidos");

        this.metrosJardin = metrosJardin;
    }

    public int getMetrosJardin() {
        return metrosJardin;
    }

    @Override
    public String toString() {
        return String.format("%s\nMetros de jardín: \t%d", super.toString(), metrosJardin);
    }
}

