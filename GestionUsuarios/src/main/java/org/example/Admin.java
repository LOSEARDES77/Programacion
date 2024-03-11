package org.example;

public class Admin extends Usuario{
    private final boolean revisaComentarios;
    private final String categoria;
    public Admin(String email, String nombre, String apellidos, String contrasenia, String categoria, boolean revisaComentarios) {
        super(email, nombre, apellidos, contrasenia);
        this.revisaComentarios = revisaComentarios;
        this.categoria = categoria;
    }
}
