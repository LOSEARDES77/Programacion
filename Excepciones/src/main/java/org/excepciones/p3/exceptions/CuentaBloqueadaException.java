package org.excepciones.p3.exceptions;

import org.excepciones.p3.Cuenta;

public class CuentaBloqueadaException extends CuentaException{
    public CuentaBloqueadaException(Cuenta c){
        super("La cuenta " + c.getNumero() + " esta bloqueada");

    }
}
