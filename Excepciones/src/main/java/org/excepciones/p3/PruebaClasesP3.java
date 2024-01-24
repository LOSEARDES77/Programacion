package org.excepciones.p3;

import org.excepciones.p3.exceptions.BancoException;
import org.excepciones.p3.exceptions.ClienteSinCuentaException;
import org.excepciones.p3.exceptions.DniNoValidoException;

public class PruebaClasesP3 {
    public static void main(String[] args) {
        Sucursal s = new Sucursal("Oficina1", "Madrid 28");

        try {
            Cliente c1 = new Cliente("91827564H", "Eduardo", "perez Laguna");
            Cliente c2 = new Cliente("28748206T", "Lucia", "Esteban Perez");
            s.abrircuenta(c1);
            s.abrircuenta(c2);
            c1.ingresarDinero(200);
            System.out.println("Se ha ingredado 200€ en la cuenta de " + c1.getNombre());
            c2.ingresarDinero(600);
            System.out.println("Se ha ingredado 600€ en la cuenta de " + c2.getNombre());
            c1.retirarDinero(300);
            System.out.println("Se ha retirado 300€ en la cuenta de " + c1.getNombre());
            c2.retirarDinero(600);
            System.out.println("Se ha retirado 600€ en la cuenta de " + c2.getNombre());
        }catch (BancoException e){
            System.out.println(e.getMessage());
        }

    }
}
