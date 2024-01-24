package org.excepciones.p3.exceptions;

public class DniNoValidoException extends BancoException{
    public DniNoValidoException(String dni){
        super("El dni " + dni + " no es valido");
    }
}
