package org.excepciones.p3;

import org.excepciones.p3.exceptions.*;


public class Cliente {
    protected final String dni;
    protected final String nombre;
    protected final String apellidos;
    private Cuenta cuenta;

    private static boolean comprobarDni(String dni){
        String tablaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero;
        if (dni.length() != 9)
            return false;
        try {
            numero = Integer.parseInt(dni.substring(0,8));
        }catch (NumberFormatException ignored){
            return false;
        }

        int pos = numero % 23;
        return tablaLetras.charAt(pos) == dni.charAt(8);

    }

    public Cliente(String dni, String nombre, String apellidos) throws DniNoValidoException {
        if (!comprobarDni(dni)) throw new DniNoValidoException(dni);
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void ingresarDinero(double cantidad) throws ClienteSinCuentaException {
        if (this.cuenta == null) throw new ClienteSinCuentaException(this);
        try{
            cuenta.ingresarDinero(cantidad);
        }catch (CuentaBloqueadaException e){
            System.out.println(e.getMessage());
        }
    }

    public void retirarDinero(double cantidad) throws ClienteSinCuentaException {
        if (this.cuenta == null) throw new ClienteSinCuentaException(this);
        try{
            cuenta.retirarDinero(cantidad);
        }catch (BancoException e){
            System.out.println(e.getMessage());
        }
    }

    public double consultarSaldo() throws ClienteSinCuentaException {
        if (this.cuenta == null) throw new ClienteSinCuentaException(this);
        return cuenta.getSaldo();
    }

    public boolean tieneCuentaAbierta(){
        return cuenta != null;
    }

    public void setCuenta(Cuenta c){
        this.cuenta = c;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

}
