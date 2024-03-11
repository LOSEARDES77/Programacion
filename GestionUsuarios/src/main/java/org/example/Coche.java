package org.example;// @author Bruno Guallar Aliaga

public class Coche {

    // PRIVATES:
// Propiedades independientes del estado
    private String matricula;
    private double maxLitrosDeposito;
    private double maxLitrosReserva;
    private double velocidadMaxima;
    private double consumoMedio100km;

    // Propiedades que definen el estado del coche
    private boolean motorArrancado;
    private boolean estaEnReserva;
    private double numLitrosActual;
    private double velocidadActual;
    private double kilometraje;
//    private Persona propietario;

// PUBLICS:
// Constructor

    public Coche (String matricula, double maxLitrosDeposito, double velocidadMaxima, double consumoMedio100km) {

        if (maxLitrosDeposito <= 0) this.maxLitrosDeposito = 50;
        else this.maxLitrosDeposito = maxLitrosDeposito;

        if (consumoMedio100km <= 0) this.consumoMedio100km = 7.5;
        else this.consumoMedio100km = consumoMedio100km;

        if (velocidadMaxima <= 0) this.velocidadMaxima = 180;
        else this.velocidadMaxima = velocidadMaxima;

        this.maxLitrosReserva = maxLitrosDeposito * 0.15;
        this.matricula = matricula;
    }

// Getters y setters AUTOMATICAMENTE

    void setMatricula(String nuevaMatricula) {
    }

    public String getMatricula () {
        return matricula;
    }

    public double getMaxLitrosDeposito () {
        return maxLitrosDeposito;
    }

    public double getMaxLitrosReserva () {
        return maxLitrosReserva;
    }

    public double getVelocidadMaxima () {
        return velocidadMaxima;
    }

    public double getConsumoMedio100km () {
        return consumoMedio100km;
    }

    public boolean getMotorArrancado () {
        return motorArrancado;
    }

    public boolean getEstaEnReserva () {
        return estaEnReserva;
    }

    public double getNumLitrosActual () {
        return numLitrosActual;
    }

    public double getVelocidadActual () {
        return velocidadActual;
    }

    double getKilometraje () {
        return kilometraje;
    }


// Comportamientos

    void arrancarMotor() {

        if (!motorArrancado && numLitrosActual > 0) {
            System.out.println("El coche con matricula " + matricula + " ha arrancado");

            if (estaEnReserva) {
                System.out.println("El coche con matricula " + matricula + " esta en reserva de combustible");
            }
            motorArrancado = true;

        } else if (motorArrancado) {
            System.out.println("El coche con matricula " + matricula + " no puede arrancar porque ya habia arrancado");
        } else if (numLitrosActual <= 0) {
            System.out.println("El coche con matricula " + matricula + " no puede arrancar porque no hay combustible");
        }
    }

    void pararMotor() {

        if (motorArrancado) {
            System.out.println("El coche con matricula " + matricula + " se ha parado");
            motorArrancado = false;
        } else System.out.println("El coche con matricula " + matricula + " estaba ya parado");
    }


    void repostar (double litros) {

        if (litros > 0) {
            if (numLitrosActual + litros > maxLitrosDeposito) {
                System.out.println("El coche con matricula " + matricula + " ha rebosado el deposito.");
                numLitrosActual = maxLitrosDeposito;
            } else numLitrosActual += litros;
        } else System.out.println("No se pueden repostar litros negativos");
        System.out.println("El coche con matricula " + matricula + " tiene " + numLitrosActual + " litros de combustible.");
    }


    void fijarVelocidad (double velocidad) {
        if (motorArrancado) {
            if (velocidad > velocidadMaxima) {
                velocidadActual = velocidadMaxima;
            } else if (velocidad < 0) {
                velocidadActual = 0;
            } else velocidadActual = velocidad;
            System.out.println("El coche con matricula " + matricula + " ha fijado la velocidad a " + velocidadActual + " km/h");
        } else System.out.println("El coche con matricula " + matricula + " no puede fijar velocidad porque el motor no esta arrancado");
    }


    void recorrerDistancia (double distancia /* en km*/ ) {

        if (!motorArrancado || velocidadActual == 0) {
            System.out.println("El coche con matricula " + matricula + " no puede recorrer distancia. Motor no arrancado o velocidad igual a 0.");
            return;
        }
        if (distancia <= 0) {
            System.out.println("La distancia debe ser mayor que cero.");
            return;
        }
        double consumoInstantaneo = consumoMedio100km * (1 + (velocidadActual - 100) / 100);
        double litrosNecesarios = distancia * consumoInstantaneo / 100;

        if (litrosNecesarios <= numLitrosActual) {
            numLitrosActual -= litrosNecesarios;
            kilometraje += distancia;
            System.out.println("El coche con matricula " + matricula + " ha recorrido " + distancia + " kilometros");

            if (!estaEnReserva && numLitrosActual <= maxLitrosReserva) {
                estaEnReserva = true;
                System.out.println("El coche con matricula " + matricula + " ha entrado en reserva de combustible");
            }
        } else {
            double distanciaReal = 100 * numLitrosActual / consumoInstantaneo;
            kilometraje += distancia;
            numLitrosActual = 0;
            estaEnReserva = true;
            pararMotor();
            System.out.println("El coche con matricula " + matricula + " ha recorrido " + distanciaReal + " kilometros");
            System.out.println("El coche con matricula " + matricula + " esta sin combustible, esta en reserva y se ha parado en motor");
        }
    }

    //  public Persona getPropietario () {
    //       return propietario;
    //  }
//
    //   public void setPropietario (Persona propietarioNuevo) {
    //      this.propietario = propietarioNuevo;
    // }

//    public boolean poseePropietario () {
//        return propietario != null;
//    }
}
