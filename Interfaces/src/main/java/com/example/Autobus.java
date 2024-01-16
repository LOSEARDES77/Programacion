package com.example;


public class Autobus extends Vehiculo implements TransportaPasajeros {
    private final int plazas;
    private int pasajerosActuales;
    private final Persona[] asiesntos;

    public Autobus(String matricula, double maxLitrosDeposito, double velocidadMaxima, double consumoMedio100km, int plazas) {
        super(matricula, maxLitrosDeposito, velocidadMaxima, consumoMedio100km);
        if (plazas > 0)
            this.plazas = plazas;
        else
            this.plazas = 10;
        this.asiesntos = new Persona[this.plazas];
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

        double factorCarga = 2 - ((double) (plazas - pasajerosActuales) / (double) plazas);
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

    @Override
    public boolean subirPasajero(Persona p) {
        if (this.velocidadActual != 0) {
            log("No se pueden subir pasajeros, el autobus esta en marcha");
            return false;
        }
        if (this.plazas >= this.pasajerosActuales) {
            log("No hay plazas disponibles");
            return false;
        }

        for (int i = 0; i < asiesntos.length; i++){
            if (asiesntos[i] == null){
                this.pasajerosActuales++;
                asiesntos[i] = p;
                log(p + " Ocupa el asiento " + (i+1));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean bajarPersona(Persona p) {
        if (this.velocidadActual != 0) {
            log("No se pueden bajar pasajeros, el autobus esta en marcha");
            return false;
        }
        if (0 <= this.pasajerosActuales) {
            log("No hay nadie n el autobus");
            return false;
        }
        for (int i = 0; i < asiesntos.length; i++){
            if (p.equals(asiesntos[i])){
                asiesntos[i] = null;
                this.pasajerosActuales--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Persona[] getEstadoOcupacion() {
        return new Persona[0];
    }

    @Override
    public int getNumActualPasajeros() {
        return 0;
    }

    @Override
    public int getNumMaximoPasajeros() {
        return 0;
    }

    @Override
    public int getNumPlazasLibres() {
        return 0;
    }
}
