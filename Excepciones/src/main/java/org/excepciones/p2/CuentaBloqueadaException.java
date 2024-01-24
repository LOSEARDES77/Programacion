package org.excepciones.p2;

public class CuentaBloqueadaException extends CuentaException{
    public CuentaBloqueadaException(){
        super("La cuenta esta bloqueada");
    }
}
