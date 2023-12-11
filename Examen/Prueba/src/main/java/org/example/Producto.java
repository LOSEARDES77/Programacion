package org.example;

import java.util.Objects;
import java.util.Random;

public class Producto {

    private final int codigo;
    private final String nombre;
    private final boolean esPerecedero;
    private int diasParaCaducar;

    public Producto(int codigo, boolean esPerecedero) {
        this.codigo = codigo;
        this.esPerecedero = esPerecedero;
        if (this.esPerecedero) {
            this.nombre = "ESPE" + genCodigo();
            this.diasParaCaducar = (int) (Math.random() * 415) - 50;
        } else
            this.nombre = "ESNP" + genCodigo();

    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", esPerecedero=" + esPerecedero +
                ", diasParaCaducar=" + diasParaCaducar +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEsPerecedero() {
        return esPerecedero;
    }

    public int getDiasParaCaducar() {
        return diasParaCaducar;
    }

    private static int genCodigo(){
        Random r = new Random();
        return (int) (Math.random() * 9999);
    }

    public boolean haCaducado(){
        if (!esPerecedero)
            return false;

        return diasParaCaducar < 0;

    }
}
