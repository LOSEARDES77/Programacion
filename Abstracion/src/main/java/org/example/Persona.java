package org.example;

public class Persona {
    private final String nombre;
    private final String apellido;
    private final String dni;
    private final Coche[] coches;
    private int numCochesActual;
    private int cocheEnUso;

    public Persona(String nombre, String apellido, String dni){
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.coches = new Coche[10];
    }

    public void comprarCoche(Coche c){
        this.coches[numCochesActual] = c;
        numCochesActual++;
    }

    public void usaCoche(double distancia, double velocidad){
        this.coches[cocheEnUso].arrancarMotor();
        this.coches[cocheEnUso].setVelocidadActual(velocidad);
        this.coches[cocheEnUso].recorrerKilometros(distancia);
        this.coches[cocheEnUso].setVelocidadActual(0);
        this.coches[cocheEnUso].pararMotor();
    }

    public Coche[] getCoches(){
        return this.coches;
    }

    public boolean poseeCoche(){
        return this.coches.length > 0;
    }

    public void imprimirDatosPersonales(){
        System.out.println(this);
    }

    public void elegirCoche(int i){
        if (i < 0 || i >= this.coches.length)
            throw new IllegalArgumentException("El indice no es valido");
        this.cocheEnUso = i;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", cochePropio=[" + impromirCoches() +
                "]}";
    }

    private String impromirCoches(){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.coches.length; i++){
            if (this.coches[i] != null)
                if (i == this.coches.length-1)
                    res.append(this.coches[i].toString());
                else
                    res.append(this.coches[i].toString()).append(", ");
        }
        return res.toString();
    }
}
