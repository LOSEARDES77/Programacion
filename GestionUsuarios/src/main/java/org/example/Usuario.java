package org.example;

public abstract class Usuario {
    protected final String email;
    protected final String nombre;
    protected final String apellidos;
    protected final String contrasenia;

    public Usuario(String email, String nombre, String apellidos, String contrasenia) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario:\n" +
                "\temail ->\t\t" + email + '\n' +
                "\tnombre ->\t\t" + nombre + '\n' +
                "\tapellidos ->\t" + apellidos + '\n' +
                "\tcontraseña ->\t" + contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
