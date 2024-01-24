package org.excepciones.p3.exceptions;

import org.excepciones.p3.Cliente;

public class ClienteSinCuentaException extends BancoException {
    public ClienteSinCuentaException(Cliente c){
        super("El cliente " + c.getNombre() + " no tiene cuentas");
    }
}
