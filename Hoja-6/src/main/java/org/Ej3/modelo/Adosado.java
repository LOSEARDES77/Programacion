package org.Ej3.modelo;

public class Adosado extends Unifamiliar {
    private final int numCase;

    public Adosado(String direccion, double precio, int arraySize, int metrosJardin, int numCase) {
        super(direccion, precio, arraySize, metrosJardin);
        if (numCase < 0)
            throw new IllegalArgumentException("El número de casa no es válido");

        this.numCase = numCase;
    }

    public int getNumCase() {
        return numCase;
    }

    @Override
    public String toString() {
        return String.format("%s\nNúmero de casa: \t%d", super.toString(), numCase);
    }
}