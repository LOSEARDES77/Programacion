package org.excepciones.p3;

import org.excepciones.p3.exceptions.*;

public class Cuenta {
    private final int numero;
    private final Cliente titular;
    protected Sucursal sucursal;
    protected double saldo;
    protected boolean bloqueada;

    public Cuenta(Cliente titular, int numero) {
        this.titular = titular;
        this.numero = numero;
    }

    public static int genNumeroDeCuenta(){
        return (int) (Math.random() * 1000000000 + 1);
    }

    public void ingresarDinero(double cantidad) throws CuentaBloqueadaException{
        if (this.bloqueada) throw new CuentaBloqueadaException(this);
        this.saldo += cantidad;
    }

    public void retirarDinero(double cantidad) throws BancoException{
        if (this.bloqueada) throw new CuentaBloqueadaException(this);
        if (this.saldo < cantidad) throw new SaldoInsuficienteException(this);
        this.saldo -= cantidad;
    }

    public void bloquear(){
        this.bloqueada = true;
    }

    public void desbloquear(){
        this.bloqueada = false;
    }

    boolean estaBLoqueada(){
        return this.bloqueada;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }
}
