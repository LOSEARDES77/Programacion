package org.example;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria c1 = new CuentaBancaria( newAccountNumber(),"Pepe");
        CuentaBancaria c2 = new CuentaBancaria(newAccountNumber(), "Juan");
        c1.imprimirDatos();
        c2.imprimirDatos();

    }

    public static String newAccountNumber(){
        return "ES" + (long) (Math.random() * 999999999999L);
    }
}