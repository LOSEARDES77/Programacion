package org.example;

public class Tamagochi {
    private final String name;
    private final int maxVida;
    private int vida;

    public Tamagochi(String name, int maxVida) {
        this.name = name;
        this.maxVida = maxVida;
        this.vida = maxVida;
    }

    public void visualizar(){
        System.out.println("Nome: " + this.name);
        System.out.println("Vida: " + this.vida);
        System.out.println("Vida máxima: " + this.maxVida);
    }

    public void jugar(){
        if(this.vida <= 0){
            System.out.println("No se puede jugar con un tamagochi muerto");
            return;
        }
        this.vida -= 1;
        for (int i = 0; i < 5; i++) {
            System.out.println("Jugando con " + this.name);
        }
        if (this.vida <= 0) {
            System.out.println("El tamagochi " + this.name + " ha muerto");
        }
    }


    public void comer(){
        if(this.vida <= 0){
            System.out.println("No se puede comer con un tamagochi muerto");
            return;
        }
        this.vida += 1;
        for (int i = 0; i < 5; i++) {
            System.out.println("Comiendo con " + this.name);
        }
    }

}
