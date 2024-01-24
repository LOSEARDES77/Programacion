package org.excepciones.p3;

import java.util.Vector;

public class Sucursal {
    private final String nombre;
    private final String direccion;
    private final Vector<Cuenta> cuentas;
    private int ultimoNumroDeCuenta;

    public Sucursal(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new Vector<>();
    }

    public void bloquearCuenta(Cuenta c){
        c.bloquear();
    }

    public void desbloquearCuenta(Cuenta c){
        c.desbloquear();
    }

    public void abrircuenta(Cliente c){
        if (c.tieneCuentaAbierta()){
            System.out.println("El cliente " + c.getNombre() + " ya tiene una cuenta");
            return;
        }

        Cuenta cu = new Cuenta(c, ++ultimoNumroDeCuenta);
        cuentas.add(cu);
        c.setCuenta(cu);

    }

    public void cerrarCuenta(Cuenta c){
        if (!cuentas.contains(c)){
            System.out.println("No hemos encontrado la cuenta " + c.getNumero());
            return;
        }
        if (c.getTitular() == null || !c.getTitular().tieneCuentaAbierta()){
            System.out.println("El cliente " + c.getTitular().getNombre() + " no tiene cuenta");
            return;
        }

        cuentas.remove(c);
        c.getTitular().setCuenta(null);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
