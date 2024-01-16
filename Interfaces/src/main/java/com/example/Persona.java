package com.example;

public class Persona {
    private final String nombre;
    private final String apellido;
    private final String dni;
    private final Vehiculo[] vehiculos;
    private int numVehiculosActual;
    private int vehiculoEnUso;

    public Persona(String nombre, String apellido, String dni){
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.vehiculos = new Vehiculo[10];
    }

    public void comprarVehiculo(Vehiculo v){
        this.vehiculos[numVehiculosActual] = v;
        numVehiculosActual++;
        v.setPropietario(this);
    }

    public void usaVehiculo(double distancia, double velocidad, Runnable mientrrasConduce){
        this.vehiculos[vehiculoEnUso].arrancarMotor();
        this.vehiculos[vehiculoEnUso].setVelocidadActual(velocidad);
        mientrrasConduce.run();
        this.vehiculos[vehiculoEnUso].recorrerKilometros(distancia);
        this.vehiculos[vehiculoEnUso].setVelocidadActual(0);
        this.vehiculos[vehiculoEnUso].pararMotor();
    }

    public Vehiculo[] getVehiculos(){
        return this.vehiculos;
    }

    public boolean poseeVehiculo(){
        return this.vehiculos.length > 0;
    }

    public void imprimirDatosPersonales(){
        System.out.println(this);
    }

    public void elegirVehiculo(int i){
        if (i < 0 || i >= this.vehiculos.length)
            throw new IllegalArgumentException("El indice no es valido");
        this.vehiculoEnUso = i;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", vehiculosPropio=[" + impromirVehiculos() +
                "]}";
    }

    private String impromirVehiculos(){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.vehiculos.length; i++){
            if (this.vehiculos[i] != null)
                if (i == this.vehiculos.length-1)
                    res.append(this.vehiculos[i].toString());
                else
                    res.append(this.vehiculos[i].toString()).append(", ");
        }
        return res.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }
}


