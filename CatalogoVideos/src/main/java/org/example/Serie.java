package org.example;

public class Serie extends Video {
    private final String anioDeemision;
    private final Temporada[] temporadas;

    protected Serie(int id, String titulo, String pais, Genero genero, int puntuacion, String anioDeemision, Temporada[] temporadas) {
        super(id, titulo, pais, genero, puntuacion);
        this.anioDeemision = anioDeemision;
        this.temporadas = temporadas;
    }

    public String getAnioDeemision() {
        return anioDeemision;
    }

    public Temporada[] getTemporadas() {
        return temporadas;
    }

    @Override
    public String toString() {
        return "Serie: " + titulo + " - " + genero + " - " + puntuacion + " - " + anioDeemision;
    }
}
