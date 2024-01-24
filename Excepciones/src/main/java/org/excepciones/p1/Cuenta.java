package org.excepciones.p1;

public class Cuenta {
    private final String numero;
    private final String titular;
    protected double saldo;
    protected boolean bloqueada;

    public Cuenta(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }
    private boolean validar(double numero){
        return numero > 0;
    }
    public void ingresarDinero(double cantidad) throws CuentaBloqueadaException{
        if (bloqueada) throw new CuentaBloqueadaException();
        else if (validar(cantidad))
            this.saldo += cantidad;
    }
    public void retiarDinero(double cantidad) throws SaldoInsuficienteExcption, CuentaBloqueadaException{
        if (bloqueada) throw new CuentaBloqueadaException();
        if (validar(cantidad) && saldo >= cantidad)
            this.saldo -= cantidad;
        else
            throw new SaldoInsuficienteExcption(saldo, cantidad);
    }
    public void bloquear(){
        this.bloqueada = true;
    }
    public void desbloquear(){
        this.bloqueada = false;
    }
    public boolean estaBloqueada(){
        return this.bloqueada;
    }
    public String getNumeroDeCuenta(){
        return this.numero;
    }
    public String getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }
}
