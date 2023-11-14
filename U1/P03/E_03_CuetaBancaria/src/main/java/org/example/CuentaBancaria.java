package org.example;

public class CuentaBancaria {
    private  final String numero;
    private String titular;
    private double saldo;
    private boolean bloqueada;

    public CuentaBancaria(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.bloqueada = false;
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void ingresar(double cantidad) {
        if (bloqueada) {
            System.out.println("La cueta est bloqueada");
            return;
        }
        if (cantidad > 0) {
            this.saldo += cantidad;
        }
    }

    public void retirar(double cantidad) {
        if (bloqueada) {
            System.out.println("La cueta est bloqueada");
            return;
        }
        if (cantidad > 0 && this.saldo >= cantidad) {
            this.saldo -= cantidad;
        }
    }

    public void cambiarTitular(String nuevoTitular){
        if (bloqueada) {
            System.out.println("La cueta est bloqueada");
            return;
        }
        if (nuevoTitular.isEmpty()){
            System.out.println("Nuevo titular no valido");
            return;
        }
        this.titular = nuevoTitular;
    }

    public void bloquear() {
        this.bloqueada = true;
    }

    public void desbloquear() {
        this.bloqueada = false;
    }

    public void imprimirDatos(){
        System.out.println("Numero: " + numero);
        System.out.printf("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
        if (bloqueada)
            System.out.println("Estado: Bloqueada");
        else
            System.out.println("Estado: Desbloqueada");
    }

}
