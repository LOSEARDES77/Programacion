package org.example;

public class Radar {
    private final double velocidadLimite;
    private String ubicacion;

    public Radar(double velocidadLimite, String ubicacion) {
        if (velocidadLimite <= 0)
            this.velocidadLimite = 100;
        else
            this.velocidadLimite = velocidadLimite;
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void pasaVehiculo(Vehiculo v){
        double velocidaDelVehiculo = v.getVelocidadActual();
        if (velocidaDelVehiculo > velocidadLimite + 15){
            ponerMulta(v);
        }
    }

    private void ponerMulta(Vehiculo v){
        Persona responsable = v.getPropietario();
        System.out.println("=".repeat(25));
        System.out.println("Vehiculo sancionado: ");
        System.out.printf("Velocidad maxima permitida: %.2fkm/h\n", velocidadLimite);
        v.log("Velocidad del vehiculo: " + v.getVelocidadActual() + "km/h");
        System.out.println("Responsable: " + responsable.getNombre() + ", " + responsable.getApellido() + "\nDNI: " + responsable.getDni());
        System.out.println("=".repeat(25));
    }
}
