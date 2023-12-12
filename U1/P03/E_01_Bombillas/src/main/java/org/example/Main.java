package org.example;

public class Main {
    public static void main(String[] args) {
        Bombilla b = new Bombilla();
        for(int i=1; i<=1000;i++) {
            b.encenderBombilla();
            b.apagarBombilla();
        }
        b.encenderBombilla();
        b.apagarBombilla();

        System.out.println(b.getEncendidos());

    }
}