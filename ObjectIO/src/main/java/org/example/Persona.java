package org.example;

import java.io.Serializable;

public class Persona implements Serializable {
    private final Coche[] coches;
    private final Mascota[] mascotas;
    private final String nombre;

    private static final String[] nombres = {"Toby", "Chispas", "Luna", "Max", "Bella", "Rocky", "Coco", "Daisy", "Buddy", "Lucy", "Molly", "Bailey", "Sadie", "Maggie", "Jake", "Duke", "Charlie", "Jack", "Lola", "Sophie", "Daisy", "Milo", "Zoe", "Lily", "Riley", "Buster", "Oscar", "Zoey", "Ginger", "Sam", "Tucker", "Bear", "Sasha", "Roxy", "Harley", "Rusty", "Murphy", "Pepper", "Lucky", "Mia", "Cody", "Dexter"};

    public Persona(){
        this.nombre = nombres[(int)(Math.random() * nombres.length)];
        this.coches = new Coche[10];
        this.mascotas = new Mascota[10];
    }

    public void comprarCoche(Coche coche){
        for (int i = 0; i < coches.length; i++){
            if (coches[i] == null){
                coches[i] = coche;
                break;
            }
        }
    }

    public void adoptarMascota(Mascota mascota){
        for (int i = 0; i < mascotas.length; i++){
            if (mascotas[i] == null){
                mascotas[i] = mascota;
                break;
            }
        }
    }

    @Override
    public String toString() {
        String cochesString = "\t[\n";
        for (Coche coche : coches){
            if (coche != null){
                cochesString += coche + "\n";
            }
        }
        cochesString += "\t]";
        String mascotasString = "\t[\n";
        for (Mascota mascota : mascotas){
            if (mascota != null){
                mascotasString += mascota + "\n";
            }
        }

        return "Persona: \n" +
                "Nombre:\t" + nombre + "\n" +
                "Coches: " + cochesString +
                "\nMascotas: " + mascotasString;
    }
}
