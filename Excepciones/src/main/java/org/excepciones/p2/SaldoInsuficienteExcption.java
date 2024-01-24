package org.excepciones.p2;

public class SaldoInsuficienteExcption extends CuentaException{
    public SaldoInsuficienteExcption(double saldo, double cantidad){
        super("Saldo insuficiente: " + saldo + "\nEsta intentando sacar: " + cantidad);
    }

}
