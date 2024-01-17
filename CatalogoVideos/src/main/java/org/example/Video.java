package org.example;

public abstract class Video {
    protected final int id;
    protected final String titulo;
    protected final String pais;
    protected Genero genero;
    protected final int puntuacion;

    protected Video(int id, String titulo, String pais, Genero genero, int puntuacion) {
        this.id = id;
        this.titulo = titulo;
        this.pais = pais;
        this.genero = genero;
        this.puntuacion = puntuacion;
    }

    @Override
    public abstract String toString();
}
