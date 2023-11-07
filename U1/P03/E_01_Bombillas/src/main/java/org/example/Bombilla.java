package org.example;

public class Bombilla {
    boolean estado; // true = encendida, false = apagada
    int encendidos; // numero de encenddidos
    boolean estaFundida; // true = fundida, false = no fundida

    public Bombilla() {
        System.out.println("Bombilla iniciada");
    }

    public void encenderBombilla() {

        if (estaFundida) {
            System.out.println("La bombilla esta fundida no se puede encender");
            estado = false;
            return;
        }

        if (estado) {
            System.out.println("La bombilla ya está encendida");
            return;
        }
        else {
            estado = true;
            encendidos++;
            System.out.println("La bombilla se ha encendido");
        }

        if (encendidos >= 1000){
            System.out.println("Se ha fundido la bombilla");
            estaFundida = true;
        }

    }

    public void apagarBombilla(){
        if (!estado)
            System.out.println("La bombilla ya esta apagada");
        else {
            estado = false;
            System.out.println("La bombilla se ha apagado");
        }
    }

}
