package org.excepciones.p1;

public class PruebaClasesP1 {
    public static void main(String[] args) {
        Cuenta c = new Cuenta("ES9120394938948938499", "Eusebio");
        try {
            c.ingresarDinero(2000);
            c.retiarDinero(100);
            System.out.println("Saldo: " + c.getSaldo());
            c.retiarDinero(3000);
        }catch(CuentaBloqueadaException e){
            System.out.println(e.getMessage());
        }catch(SaldoInsuficienteExcption e){
            System.out.print("");
            System.out.println(e.getMessage());
        }
    }
}
