package org.example;

import java.io.Serializable;

public class Mascota implements Serializable {

    private final String nombre;
    private final String raza;
    private final int edad;
    private final String tipo;

    private static final String[] tipos = {"Perro", "Gato"};

    private static final String[] razasPerros = {"Pastor Alemán", "Labrador", "Golden Retriever", "Bulldog", "Beagle", "Poodle", "Rottweiler", "Dachshund", "Siberian Husky", "Doberman", "Chihuahua", "Boxer", "Pug", "Shih Tzu", "Great Dane", "Pomeranian", "Border Collie", "Cocker Spaniel", "Maltese", "Bichon Frise", "Papillon", "Basset Hound", "Bloodhound", "Bull Terrier", "Bullmastiff", "Cane Corso", "Chow Chow", "Dalmatian", "English Setter", "French Bulldog", "German Shorthaired"};
    private static final String[] razasGatos = {"Siamese", "Comun Europeo", "Angora", "Persa", "Sphynx", "Maine Co"};

    private static final String[] nombres = {"Toby", "Chispas", "Luna", "Max", "Bella", "Rocky", "Coco", "Daisy", "Buddy", "Lucy", "Molly", "Bailey", "Sadie", "Maggie", "Jake", "Duke", "Charlie", "Jack", "Lola", "Sophie", "Daisy", "Milo", "Zoe", "Lily", "Riley", "Buster", "Oscar", "Zoey", "Ginger", "Sam", "Tucker", "Bear", "Sasha", "Roxy", "Harley", "Rusty", "Murphy", "Pepper", "Lucky", "Mia", "Cody", "Dexter"};

    public Mascota(){
        this.nombre = nombres[(int)(Math.random() * nombres.length)];
        this.tipo = tipos[(int)(Math.random() * tipos.length)];
        switch(this.tipo){
            case "Perro":
                this.raza = razasPerros[(int)(Math.random() * razasPerros.length)];
                break;
            case "Gato":
                this.raza = razasGatos[(int)(Math.random() * razasGatos.length)];
                break;
            default:
                this.raza = "tipo desconocida";
                break;
        }

        this.edad = (int)(Math.random() * 20);
    }

    @Override
    public String toString() {
        return "Mascota: \n" +
                "\tNombre:\t" + nombre + "\n" +
                "\tRaza:  \t" + raza + "\n" +
                "\tEdad: \t" + edad + "\n" +
                "\tTipo: \t" + tipo;
    }
}
