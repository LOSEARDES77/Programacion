package org.example;

public class Televisor {
    private final String marca;
    private final String modelo;
    private final int anio;
    private boolean panoramica;
    private boolean stereo;
    private boolean encendido;
    private int volumen;
    private int canal;

    public Televisor(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        if (anio < 1950 || anio > 2200) {
            System.out.println("El año " + anio + " no es válido");
            this.anio = 2000;
        }else
            this.anio = anio;
    }

    public void encender() {
        if (this.encendido) {
            System.out.println("El televisor ya está encendido");
            return;
        }
        this.encendido = true;
        System.out.println("El televisor se encendió");
    }

    public void apagar() {
        if (!this.encendido) {
            System.out.println("El televisor ya está apagado");
            return;
        }
        this.encendido = false;
        System.out.println("El televisor se apagó");
    }

    public void cambiarCanal(int nuevoCanal){
        if (!this.encendido) {
            System.out.println("El televisor está apagado");
            return;
        }
        if (nuevoCanal < 0 || nuevoCanal > 99) {
            System.out.println("El canal " + nuevoCanal + " no existe");
            return;
        }
        if (this.canal == nuevoCanal) {
            System.out.println("El televisor ya está en el canal " + nuevoCanal);
            return;
        }
        this.canal = nuevoCanal;
        System.out.println("El televisor cambió al canal " + nuevoCanal);
    }

    public int obtenerCanal() {
        if (!this.encendido) {
            System.out.println("El televisor está apagado");
            return -1;
        }
        System.out.println("El televisor está en el canal " + this.canal);
        return this.canal;
    }

    public void subirCanal() {
        if (!this.encendido) {
            System.out.println("El televisor está apagado");
            return;
        }
        this.cambiarCanal(this.canal + 1);
        System.out.println("El televisor cambió al canal " + this.canal);
    }

    public void bajarCanal() {
        if (!this.encendido) {
            System.out.println("El televisor está apagado");
            return;
        }
        this.cambiarCanal(this.canal - 1);
        System.out.println("El televisor cambió al canal " + this.canal);
    }

    public void subirVolumen() {
        if (!this.encendido) {
            System.out.println("El televisor está apagado");
            return;
        }
        if (this.volumen == 100) {
            System.out.println("El televisor ya está en el volumen máximo");
            return;
        }
        this.volumen++;
        System.out.println("El televisor subió el volumen a " + this.volumen);
    }

    public void bajarVolumen() {
        if (!this.encendido) {
            System.out.println("El televisor está apagado");
            return;
        }
        if (this.volumen == 0) {
            System.out.println("El televisor ya está en el volumen mínimo");
            return;
        }
        this.volumen--;
        System.out.println("El televisor bajó el volumen a " + this.volumen);
    }

    public void setVolumen(int volumen){
        if (!this.encendido) {
            System.out.println("El televisor está apagado");
            return;
        }
        if (volumen < 0 || volumen > 100) {
            System.out.println("El volumen " + volumen + " no es válido");
            return;
        }
        this.volumen = volumen;
        System.out.println("El televisor cambió el volumen a " + this.volumen);

    }

    public void imprimirCaracteristicas(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Año: " + this.anio);
        System.out.println("Panorámica: " + this.panoramica);
        System.out.println("Stereo: " + this.stereo);
    }



}
