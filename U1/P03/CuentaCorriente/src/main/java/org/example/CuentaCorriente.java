package org.example;

public class CuentaCorriente {
    private final long numeroDeCuenta;

    private double saldo;

    public CuentaCorriente(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldo = 0;
    }

    public CuentaCorriente() {
        this.numeroDeCuenta = genNumeroDeCuenta();
        this.saldo = 0;
    }

    private static long genNumeroDeCuenta() {
        return (long) (Math.random() * 10000000000000000L) + 1L;
    }

    public void ingrsarEfectivo(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("No puedes ingresar negativo o 0");
            return;
        }
        this.saldo += cantidad;
        System.out.println("Se ha ingresado " + cantidad + "€\nSaldo: " + this.saldo + "€");
    }

    public boolean retirarEfectivo(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("No puedes ingresar negativo o 0");
            return false;
        }
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        if (cantidad == saldo) {
            System.out.println("Se ha vaciado la cuenta");
        }
        this.saldo -= cantidad;
        System.out.println("Se ha retirado " + cantidad + "€\nSaldo: " + this.saldo + "€");
        return true;
    }

    public void visualizar() {
        System.out.printf("Numero de cuenta: %03d\n", this.numeroDeCuenta);
        System.out.printf("Saldo:           %02f€\n2", this.saldo);
    }

}
