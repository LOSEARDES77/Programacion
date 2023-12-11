package org.example;

public class Empleado {
    private final String codEmpleado;
    private final String nombre;
    private final String apellidos;
    private int numeroDehijos;
    private double salarioBase;
    private double complementoDeDestino;

    public Empleado(String nombre, String apellidos, double salarioBase) {
        this.codEmpleado = String.valueOf(nombre.charAt(0)).toUpperCase() + "_" + String.format("%04d", (int) (Math.random() * 5000));
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroDehijos = (byte) (Math.random() * 11);
        this.complementoDeDestino = (Math.random() * 3001);
        this.salarioBase = salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public int getNumeroDehijos() {
        return numeroDehijos;
    }

    public void setNumeroDehijos(int numeroDehijos) {
        this.numeroDehijos = numeroDehijos;
    }

    public void setComplementoDeDestino(double complementoDeDestino) {
        this.complementoDeDestino = complementoDeDestino;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getComplementoDeDestino() {
        return complementoDeDestino;
    }

    @Override
    public String toString(){
        return String.format("|   %s   | %-9s  | %-18s |     %02d     |   %04d%s  |", codEmpleado, nombre, apellidos, numeroDehijos, (long)(salarioBase + complementoDeDestino), String.valueOf((long)(salarioBase + complementoDeDestino)-(salarioBase + complementoDeDestino)).substring(2, 5));
    }
    public double getSalario(){
        return salarioBase + complementoDeDestino;
    }
}
