package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;

public class Persona {
    private final String nombre;
    private final String apellidos;
    private final String dni;
    private final ArrayList<Coche> coches;
    private int numCochesActual;
    private int cocheEnUso;

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.coches = new ArrayList<>();
    }

    public void elegirCocheEnUso(int i){
        this.cocheEnUso = i;
    }

    public void comprarCoche(Coche coche) {
        coches.add(coche);
    }

    public void usarCoche(double distancia, double elocidad){
        coches.get(cocheEnUso-1).setVelocidadActual(elocidad);
        coches.get(cocheEnUso-1).recorrerKilometros(distancia);
    }

    public ArrayList<Coche> getCoches(){
        return this.coches;
    }

    public void imprimirDatos(){
        System.out.println("Dni: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Coches: ");
        for (int i = 0; i < coches.size(); i++){
            System.out.println("Coche " + i + "\n" + coches.get(i));
        }
    }

}
