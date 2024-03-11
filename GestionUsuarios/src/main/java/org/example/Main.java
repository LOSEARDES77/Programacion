package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GestorUsuarios gu = new GestorUsuarios();
        gu.addUser(new Comprador("pepe@asd.com", "pepe", "manchado", "ABC", "832178917329813", "Micasa 10", new String[]{"judias", "lentejas"}));
        try {
            gu.saveData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");

    }
}