package org.excepciones.p3.exceptions;

public class CuentaException extends BancoException{
    public CuentaException(){
        super();
    }

    public CuentaException(String msg){
        super(msg);
    }
}
