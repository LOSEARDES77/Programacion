package org.example;

import java.util.Date;

public class Primitiva {
    private final int dia;
    private final int mes;
    private final int anio;
    private final int[] combinacionGanadora;


    public Primitiva(String fecha, int[] combinacionGanadora) {
        String[] fechaArray = fecha.split("/");
        if (fechaArray.length != 3) {
            throw new IllegalArgumentException("La fecha debe tener el formato dd/mm/aaaa");
        }
        this.dia = Integer.parseInt(fechaArray[0]);
        this.mes = Integer.parseInt(fechaArray[1]);
        this.anio = Integer.parseInt(fechaArray[2]);
        this.combinacionGanadora = combinacionGanadora;

    }

    public static int[] genConbinacionGanadora() {
        int dia = (int) (Math.random() * 31) + 1;
        int mes = (int) (Math.random() * 12) + 1;
        int anio = (int) (Math.random() * 99) + 1;
        int dia2 = (int) (Math.random() * 31) + 1;
        int mes2 = (int) (Math.random() * 12) + 1;
        int anio2 = (int) (Math.random() * 99) + 1;
        return new int[]{dia, mes, anio, dia2, mes2, anio2};

    }


    public boolean esGanadolra() {
        return (this.dia == combinacionGanadora[3] && this.mes == combinacionGanadora[4] && this.anio == combinacionGanadora[5])
        || (this.dia == combinacionGanadora[0] && this.mes == combinacionGanadora[1] && this.anio == combinacionGanadora[2]);
    }




    @Override
    public String toString() {
        return String.format("Primitiva [fecha=%d/%d/%d] convinacionGanadora=", dia, mes, anio);
    }

}
