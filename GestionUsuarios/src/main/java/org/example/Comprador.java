package org.example;

public class Comprador extends Usuario{
    private final String tarjetaDePago;
    private final String direccionDeEnvio;
    private final String[] productosFavoritos;

    public Comprador(String email, String nombre, String apellidos, String contrasenia, String tarjetaDePago, String direccionDeEnvio, String[] productosFavoritos) {
        super(email, nombre, apellidos, contrasenia);
        this.tarjetaDePago = tarjetaDePago;
        this.direccionDeEnvio = direccionDeEnvio;
        this.productosFavoritos = productosFavoritos;
    }
}
