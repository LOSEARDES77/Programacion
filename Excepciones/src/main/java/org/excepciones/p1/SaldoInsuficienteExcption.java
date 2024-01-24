package org.excepciones.p1;

public class SaldoInsuficienteExcption extends Exception {
    public SaldoInsuficienteExcption(double saldo, double cantidad){
        super("Saldo insuficiente: " + saldo + "\nEsta intentando sacar: " + cantidad);
    }

}
