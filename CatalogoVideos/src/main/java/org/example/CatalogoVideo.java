package org.example;


import jdk.jshell.execution.Util;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;

public class CatalogoVideo {
    private Video[] catalogo;

    public CatalogoVideo(Video[] catalogo) {
        this.catalogo = catalogo;
    }

    public void insertarEnCatalogo(Video v){
        this.catalogo = Utils.arrAdd(catalogo, v);
    }
    public void consultarCatalogo(){
        System.out.println(this);
    }

    private String vidArrToStr(Video[] vs){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < vs.length; i++){
            s.append(vs[i]);
            if (i != vs.length-1)
                s.append("\n");
        }
        return s.toString();
    }
    @Override
    public String toString() {
        return vidArrToStr(catalogo);
    }

    public void consultarPorDirector(String d){
        Video[] resultado = new Video[0];
        for (Video v : catalogo){
            if (v instanceof Pelicula && ((Pelicula) v).getDirector().equals(d)){
                resultado = Utils.arrAdd(resultado, v);
            }
        }
        System.out.println(vidArrToStr(resultado));
    }

    public void consultarPorAnio(String a){
        Video[] resultado = new Video[0];
        for (Video v : catalogo){
            if (v instanceof Serie && ((Serie) v).getAnioDeemision().equals(a)){
                resultado = Utils.arrAdd(resultado, v);

            }
        }
    }

    public void consultarPorGenero(Genero gen){
        Video[] res = new Video[0];
        for (Video v : catalogo){
            if (v.genero == gen){
                res = Utils.arrAdd(res, v);
            }
        }
        System.out.println(vidArrToStr(res));
    }

    public void modificarGenero(int id, Genero gen){
        Video v = getMedia(id);
        assert v != null;
        v.genero = gen;
    }
    private int getIndex(Video v){
        for (int i = 0; i < catalogo.length; i++){
            if (catalogo[i].equals(v))
                return i;
        }
        return -1;
    }
    private Video getMedia(int id){
        for (Video v  :catalogo){
            if (v.id == id){
                return v;
            }
        }
        System.out.println("Error: Media with id \"" + id + "\" not found");
        return null;
    }

    public void eliminarVideoPorId(int id){
        Video victim = getMedia(id);
        assert victim != null;
        int response = JOptionPane.showConfirmDialog(null, "Vas a eliminar:\n"+ victim + "\n¿Estas seguro?", "¿Seguro?",JOptionPane.YES_NO_OPTION);
        if (response == 0){
            catalogo[getIndex(victim)] = null;
            System.out.println("Video eliminado");
        }
    }

    public void numeroDeEpisodios(int id, int temporada){
        Video v = getMedia(id);
        assert v != null;
        assert v instanceof Serie;
        Serie s = (Serie) v;
        System.out.println(s.getTemporadas()[temporada].getEpisodios().length);
    }

    public void episodiosTotales(int id){
        Video v = getMedia(id);
        assert v != null;
        assert v instanceof Serie;
        Serie s = (Serie) v;
        int episodios = 0;
        for (Temporada t : s.getTemporadas())
            for (Episodio e : t.getEpisodios())
                episodios++;

        System.out.println(episodios);
    }

    public void ordenarSeriePelicula(){
        Video[] peliculas = new Video[0];
        Video[] series = new Video[0];
        for (Video v : catalogo){
            if (v instanceof Pelicula)
                peliculas = Utils.arrAdd(peliculas, v);
            if (v instanceof Serie)
                series = Utils.arrAdd(series, v);
        }

        for (Video v : series){
            peliculas = Utils.arrAdd(peliculas, v);
        }
    }

    public void ordenarPorTitulo(){
        Arrays.sort(catalogo, Comparator.comparing(o -> o.titulo));
    }

    public void ordenarPorGenero(){
        Arrays.sort(catalogo, Comparator.comparing(o -> o.genero));
    }

    public void ordenarPorPuntuacionYTitulo(){
        ordenarPorTitulo();
        Arrays.sort(catalogo, Comparator.comparingDouble(o -> o.puntuacion));
    }

    public void consultarTopDiez(){
        Video[] tmp = catalogo;
        Arrays.sort(tmp, Comparator.comparing(o -> o.titulo));
        Arrays.sort(tmp, Comparator.comparing(o -> o.puntuacion));

        for (int i = 0; i < 10; i++){
            System.out.println(tmp[i]);
        }

    }

    public void masSeriesAlmacenadas(Video[] c1, Video[] c2){
        int seriesC1 = 0;
        int seriesC2 = 0;
        for (Video value : c1) {
            if (value instanceof Serie) {
                seriesC1++;
            }
        }

        for (Video video : c2) {
            if (video instanceof Serie) {
                seriesC2++;
            }
        }

        if (seriesC1 > seriesC2){
            System.out.println("El catalogo 1 tiene mas series");
        }else if (seriesC2 > seriesC1){
            System.out.println("El catalogo 2 tiene mas series");
        }else {
            System.out.println("Tienen las mismas series");
        }
    }


}
