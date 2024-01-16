package com.example;

public class Camion extends Vehiculo {
    protected final double cargaMaxima;
    protected double cargaActual;

    public Camion(String matricula, double maxLitrosDeposito, double velocidadMaxima, double consumoMedio100km, double cargaMaxima) {
        super(matricula, maxLitrosDeposito, velocidadMaxima, consumoMedio100km);
        if (cargaMaxima <= 0)
            this.cargaMaxima = cargaMaxima;
        else
            this.cargaMaxima = 1000;
    }

    public void carga(double kilos){
        if (this.velocidadActual != 0){
            log("No se puede cargar el camion en marcha");
            return;
        }
        if (kilos < 0){
            log("No se puede cargar una cantidad negativa");
            return;
        }
        if (kilos > cargaMaxima){
            log("No se puede cargar una cantidad mayor que la carga maxima");
            return;
        }
        if (kilos + cargaActual > cargaMaxima){
            log("No se puede cargar una cantidad que supere la carga maxima");
            return;
        }
        cargaActual += kilos;
        log("Cargados " + kilos + " kg");
    }

    public void descarga(double kilos){
        if (kilos < 0){
            log("No se puede descargar una cantidad negativa");
            return;
        }
        if (kilos > cargaMaxima){
            log("No se puede descargar una cantidad mayor que la carga maxima");
            return;
        }
        if (cargaActual - kilos < 0){
            log("No se puede descargar una cantidad que supere la carga actual");
            return;
        }
        cargaActual -= kilos;
        log("Descargados " + kilos + " kg");
    }

    public double getCargaActual(){
        return cargaActual;
    }

    @Override
    public void recorrerKilometros(double kilometros) {
        if (kilometros < 0){
            log("No se puede recorrer una distancia negativa");
            return;
        }
        if (!motorArrancado){
            log("No se puede recorrer una distancia si el motor no esta arrancado");
            return;
        }
        if (velocidadActual == 0){
            log("No se puede recorrer una distancia si la velocidad es cero");
            return;
        }
        if (combustibleActual == 0){
            log("No se puede recorrer una distancia si el combustible es cero");
            return;
        }

        double factorCarga = 2 - ((cargaMaxima - cargaActual) / cargaMaxima);
        double consumeInstantaneo = factorCarga * consumoMedio100km * (1 + (velocidadActual - 100) / 100);
        double combustibleNecesario = kilometros * consumeInstantaneo / 100;

        if (combustibleNecesario > combustibleActual){
            double kilometrosRecorridos = 100 * combustibleActual / consumeInstantaneo;
            log("Se han recorrido " + kilometrosRecorridos + " km por consumo insuficiente");
            kilometraje += kilometrosRecorridos;
            setEstaEnReserva(true);
            setCombustibleActual(0);
            return;
        }
        kilometraje += kilometros;
        combustibleActual -= combustibleNecesario;
        log("Recorridos " + kilometros + " km");
    }

}
