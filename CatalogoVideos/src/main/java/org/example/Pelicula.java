package org.example;

public class Pelicula extends Video {
    private final String anioDeEstreno;
    private final int duracion;
    private final String director;

    protected Pelicula(int id, String titulo, String pais, Genero genero, int puntuacion, String anioDeEstreno, int duracion, String director) {
        super(id, titulo, pais, genero, puntuacion);
        this.anioDeEstreno = anioDeEstreno;
        this.duracion = duracion;
        this.director = director;
    }


    public String getAnioDeEstreno() {
        return anioDeEstreno;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Pelicula: " + titulo + " - " + genero + " - " + puntuacion + " - " + anioDeEstreno + " - " + duracion;
    }
}
