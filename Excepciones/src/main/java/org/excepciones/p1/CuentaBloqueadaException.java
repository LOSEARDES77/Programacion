package org.excepciones.p1;

public class CuentaBloqueadaException extends Exception{
    public CuentaBloqueadaException(){
        super("La cuenta esta bloqueada");
    }
}
