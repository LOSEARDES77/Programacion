package org.example;

public class Main {
    public static void main(String[] args) {
        // Test all methods
        CatalogoVideo cv = new CatalogoVideo();
        CatalogoVideo cv2 = new CatalogoVideo();

        cv.insertarEnCatalogo(new Pelicula(1, "b", "c", Genero.Accion, Math.random() * 10 + 1, "10", (int) (Math.random() * 199) + 1, "h"));
        cv.insertarEnCatalogo(new Pelicula(4, "h", "w", Genero.CienciaFiccion, Math.random() * 10 + 1, "10", (int) (Math.random() * 199) + 1, "o"));
        cv.insertarEnCatalogo(new Serie(8, "p", "f", Genero.Drama, Math.random() * 10 + 1, "10"));
        cv.insertarEnCatalogo(new Serie(7, "n", "d", Genero.Misterio, Math.random() * 10 + 1, "10"));
        cv.insertarEnCatalogo(new Pelicula(2, "d", "j", Genero.Misterio, Math.random() * 10 + 1, "8", (int) (Math.random() * 199) + 1, "j"));
        cv.insertarEnCatalogo(new Serie(5, "j", "a", Genero.Comedia, Math.random() * 10 + 1, "1450"));
        cv.insertarEnCatalogo(new Pelicula(11, "v", "j", Genero.Accion, Math.random() * 10 + 1, "13550", (int) (Math.random() * 199) + 1, "h"));
        cv.insertarEnCatalogo(new Pelicula(13, "z", "l", Genero.Drama, Math.random() * 10 + 1, "18740", (int) (Math.random() * 199) + 1, "A"));
        cv.insertarEnCatalogo(new Pelicula(3, "f", "s", Genero.Drama, Math.random() * 10 + 1, "1760", (int) (Math.random() * 199) + 1, "A"));
        cv.insertarEnCatalogo(new Serie(6, "l", "s", Genero.Accion, Math.random() * 10 + 1, "14340"));
        cv.insertarEnCatalogo(new Serie(9, "r", "g", Genero.CienciaFiccion, Math.random() * 10 + 1, "13120"));
        cv.insertarEnCatalogo(new Serie(10, "t", "h", Genero.Comedia, Math.random() * 10 + 1, "1310"));
        cv.insertarEnCatalogo(new Serie(15, "c", "x", Genero.Comedia, Math.random() * 10 + 1, "1021"));
        cv.insertarEnCatalogo(new Pelicula(14, "b", "z", Genero.CienciaFiccion, Math.random() * 10 + 1, "10", (int) (Math.random() * 199) + 1, "o"));
        cv.insertarEnCatalogo(new Pelicula(12, "x", "k", Genero.Misterio, Math.random() * 10 + 1, "8", (int) (Math.random() * 199) + 1, "j"));

        cv2.insertarEnCatalogo(new Pelicula(1, "b", "c", Genero.Accion, Math.random() * 10 + 1, "1230", (int) (Math.random() * 199) + 1, "h"));
        cv2.insertarEnCatalogo(new Pelicula(4, "h", "w", Genero.CienciaFiccion, Math.random() * 10 + 1, "1110", (int) (Math.random() * 199) + 1, "o"));
        cv2.insertarEnCatalogo(new Serie(8, "p", "f", Genero.Drama, Math.random() * 10 + 1, "13120"));
        cv2.insertarEnCatalogo(new Serie(7, "n", "d", Genero.Misterio, Math.random() * 10 + 1, "1120"));
        cv2.insertarEnCatalogo(new Pelicula(2, "d", "j", Genero.Misterio, Math.random() * 10 + 1, "8", (int) (Math.random() * 199) + 1, "j"));
        cv2.insertarEnCatalogo(new Serie(5, "j", "a", Genero.Comedia, Math.random() * 10 + 1, "1540"));
        cv2.insertarEnCatalogo(new Pelicula(11, "v", "j", Genero.Accion, Math.random() * 10 + 1, "140", (int) (Math.random() * 199) + 1, "h"));
        cv2.insertarEnCatalogo(new Pelicula(13, "z", "l", Genero.Drama, Math.random() * 10 + 1, "130", (int) (Math.random() * 199) + 1, "A"));
        cv2.insertarEnCatalogo(new Pelicula(3, "f", "s", Genero.Drama, Math.random() * 10 + 1, "110", (int) (Math.random() * 199) + 1, "A"));
        cv2.insertarEnCatalogo(new Serie(6, "l", "s", Genero.Accion, Math.random() * 10 + 1, "1320"));
        cv2.insertarEnCatalogo(new Serie(9, "r", "g", Genero.CienciaFiccion, Math.random() * 10 + 1, "1120"));
        cv2.insertarEnCatalogo(new Serie(10, "t", "h", Genero.Comedia, Math.random() * 10 + 1, "1120"));
        cv2.insertarEnCatalogo(new Serie(15, "c", "x", Genero.Comedia, Math.random() * 10 + 1, "13º0"));
        cv2.insertarEnCatalogo(new Pelicula(14, "b", "z", Genero.CienciaFiccion, Math.random() * 10 + 1, "11230", (int) (Math.random() * 199) + 1, "o"));
        cv2.insertarEnCatalogo(new Pelicula(12, "x", "k", Genero.Misterio, Math.random() * 10 + 1, "8", (int) (Math.random() * 199) + 1, "j"));
        cv2.insertarEnCatalogo(new Serie(28, "j", "p", Genero.Documental, Math.random() * 10 + 1, "23"));

        cv.consultarCatalogo();

        cv.consultarPorDirector("h");

        cv.consultarPorAnio("10");

        cv.consultarPorGenero(Genero.Comedia);

        cv.consultarPorGenero(Genero.Drama);

        cv.episodiosTotales(12);

        cv.numeroDeEpisodios(15, 2);

        cv.ordenarSeriePelicula();
        cv.consultarCatalogo();

        cv.ordenarPorTitulo();
        cv.consultarCatalogo();

        cv.ordenarPorGenero();
        cv.consultarCatalogo();

        cv.ordenarPorPuntuacionYTitulo();
        cv.consultarCatalogo();

        cv.consultarTopDiez();

        cv.masSeriesAlmacenadas(cv.getCatalogo(), cv2.getCatalogo());

    }
}