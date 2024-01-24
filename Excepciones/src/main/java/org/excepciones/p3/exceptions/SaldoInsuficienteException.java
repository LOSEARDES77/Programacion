package org.excepciones.p3.exceptions;

import org.excepciones.p3.Cuenta;

public class SaldoInsuficienteException extends CuentaException{
    public SaldoInsuficienteException(Cuenta c){
        super("El saldo " + c.getSaldo() + " es insuficiente");
    }
}
