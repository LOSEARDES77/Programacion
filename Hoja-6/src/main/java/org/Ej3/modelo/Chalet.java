package org.Ej3.modelo;

public class Chalet extends Unifamiliar {
    private final boolean piscina;

    public Chalet(String direccion, double precio, int arraySize, int metrosJardin, boolean piscina) {
        super(direccion, precio, arraySize, metrosJardin);
        this.piscina = piscina;
    }

    public boolean isPiscina() {
        return piscina;
    }

    @Override
    public String toString() {
        return String.format("%s\nPiscina: \t%s", super.toString(), (piscina) ? "Sí" : "No");
    }
}