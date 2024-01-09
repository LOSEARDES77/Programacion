package org.example;

public class Coche extends Vehiculo{
    public Coche(String matricula, double maxLitrosDeposito, double velocidadMaxima, double consumoMedio100km) {
        super(matricula, maxLitrosDeposito, velocidadMaxima, consumoMedio100km);
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
            double consumeInstantaneo = consumoMedio100km * (1 + (velocidadActual - 100) / 100);
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
