package org.Ej3.modelo;

public class Piso extends Vivienda {
    private final String comunidad;
    private final int nPiso;

    public Piso(String direccion, double precio, int arraySize, String comunidad, int nPiso) {
        super(direccion, precio, arraySize);
        if (comunidad == null || comunidad.isEmpty())
            throw new IllegalArgumentException("La comunidad no es válida");
        if (nPiso < 1)
            throw new IllegalArgumentException("El número de piso no es válido");

        this.comunidad = comunidad;
        this.nPiso = nPiso;
    }

    @Override
    public String toString() {
        return String.format("%s\nComunidad: \t%s\nNum Piso: \t%d", super.toString(), comunidad, nPiso);
    }

    public String getComunidad() {
        return comunidad;
    }

    public int getnPiso() {
        return nPiso;
    }
}