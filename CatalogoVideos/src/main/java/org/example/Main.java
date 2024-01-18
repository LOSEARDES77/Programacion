package org.example;

public class Main {
    public static void main(String[] args) {
        // Test all methods
        CatalogoVideo cv = new CatalogoVideo(new Video[0]);
        cv.insertarEnCatalogo(new Pelicula(1, "b", "c", Genero.Accion, Math.random() * 10 + 1, "10", (int) (Math.random() * 199) + 1, "h"));
        cv.insertarEnCatalogo(new Pelicula(4, "h", "w", Genero.CienciaFiccion, Math.random() * 10 + 1, "10", (int) (Math.random() * 199) + 1, "o"));
        cv.insertarEnCatalogo(new Serie(8, "p", "f", Genero.Drama, Math.random() * 10 + 1, "10"));
        cv.insertarEnCatalogo(new Serie(7, "n", "d", Genero.Misterio, Math.random() * 10 + 1, "10"));
        cv.insertarEnCatalogo(new Pelicula(2, "d", "j", Genero.Misterio, Math.random() * 10 + 1, "8", (int) (Math.random() * 199) + 1, "j"));
        cv.insertarEnCatalogo(new Serie(5, "j", "a", Genero.Comedia, Math.random() * 10 + 1, "10"));
        cv.insertarEnCatalogo(new Pelicula(11, "v", "j", Genero.Accion, Math.random() * 10 + 1, "10", (int) (Math.random() * 199) + 1, "h"));
        cv.insertarEnCatalogo(new Pelicula(13, "z", "l", Genero.Drama, Math.random() * 10 + 1, "10", (int) (Math.random() * 199) + 1, "A"));
        cv.insertarEnCatalogo(new Pelicula(3, "f", "s", Genero.Drama, Math.random() * 10 + 1, "10", (int) (Math.random() * 199) + 1, "A"));
        cv.insertarEnCatalogo(new Serie(6, "l", "s", Genero.Accion, Math.random() * 10 + 1, "10"));
        cv.insertarEnCatalogo(new Serie(9, "r", "g", Genero.CienciaFiccion, Math.random() * 10 + 1, "10"));
        cv.insertarEnCatalogo(new Serie(10, "t", "h", Genero.Comedia, Math.random() * 10 + 1, "10"));
        cv.insertarEnCatalogo(new Serie(15, "c", "x", Genero.Comedia, Math.random() * 10 + 1, "10"));
        cv.insertarEnCatalogo(new Pelicula(14, "b", "z", Genero.CienciaFiccion, Math.random() * 10 + 1, "10", (int) (Math.random() * 199) + 1, "o"));
        cv.insertarEnCatalogo(new Pelicula(12, "x", "k", Genero.Misterio, Math.random() * 10 + 1, "8", (int) (Math.random() * 199) + 1, "j"));

        cv.consultarCatalogo();

        cv.consultarPorDirector("h");

        cv.consultarPorAnio("10");

        cv.consultarPorGenero(Genero.Comedia);

        cv.consultarPorGenero(Genero.Drama);




    }
}