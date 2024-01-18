package org.example;

public class Serie extends Video {
    private final String anioDeemision;
    private final Temporada[] temporadas;

    protected Serie(int id, String titulo, String pais, Genero genero, double puntuacion, String anioDeemision) {
        super(id, titulo, pais, genero, puntuacion);
        this.anioDeemision = anioDeemision;
        this.temporadas = genTemporadas();
    }

    private Temporada[] genTemporadas() {
        Temporada[] temporadas = new Temporada[(int) (Math.random() * 40) + 1];
        Episodio[] episodios = new Episodio[(int) (Math.random() * 40) + 1];
        for (int i = 0; i < temporadas.length; i++){
            for (int j = 0; j < episodios.length; j++){
                episodios[j] = new Episodio( "T" + i + "E" + j, "Noce");
            }
            temporadas[i] = new Temporada(episodios);
        }
        return temporadas;
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
