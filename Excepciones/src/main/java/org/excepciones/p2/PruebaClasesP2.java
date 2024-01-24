package org.excepciones.p2;

public class PruebaClasesP2 {
    public static void main(String[] args) {
        Cuenta c = new Cuenta("ES9120394938948738499", "Eusebio");
        try {
            c.ingresarDinero(2000);
            c.retiarDinero(100);
            System.out.println("Saldo: " + c.getSaldo());
            c.retiarDinero(3000);
        }catch(CuentaException e){
            System.out.println(e.getMessage());
        }
    }
}
