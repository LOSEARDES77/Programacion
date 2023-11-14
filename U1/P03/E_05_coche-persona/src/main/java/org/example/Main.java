package org.example;

import static org.example.Coche.genMatricula;

public class Main {
    public static void main(String[] args) {
        Coche c1 = new Coche(genMatricula(), 80, 300, 7.1);
        c1.repostar(15);
        c1.arrancarMotor();
        c1.fijarVelocidad(80);
        c1.recorrerKilometros(10);
        c1.fijarVelocidad(120);
        c1.recorrerKilometros(300);
    }
}