package org.example;
public abstract class Vehiculo {


    protected final String matricula;
    protected final double maxLitrosDeposito;
    protected final double maxLitrosReserva;
    protected final double velocidadMaxima;
    protected final double consumoMedio100km;
    protected Persona propietario;
    protected boolean motorArrancado;
    protected boolean estaEnReserva;
    protected double combustibleActual;
    protected double velocidadActual;
    protected double kilometraje;

    public Vehiculo(String matricula, double maxLitrosDeposito, double velocidadMaxima, double consumoMedio100km) {
        if (maxLitrosDeposito <= 0) this.maxLitrosDeposito = 50;
        else this.maxLitrosDeposito = maxLitrosDeposito;

        if (consumoMedio100km <= 0) this.consumoMedio100km = 7.5;
        else this.consumoMedio100km = consumoMedio100km;

        if (velocidadMaxima <= 0) this.velocidadMaxima = 180;
        else this.velocidadMaxima = velocidadMaxima;

        this.maxLitrosReserva = maxLitrosDeposito * 0.15;
        this.matricula = matricula;
    }

    public boolean tienePropietario(){
        return this.propietario != null;
    }
    public Persona getPropietario(){
        return this.propietario;
    }

    public void setPropietario(Persona p){
        this.propietario = p;
    }

    public static String genMatricula(){
        int numero = (int) (Math.random() * 9999) + 1;
        char[] letras = " ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String letra1 = String.valueOf(letras[(int) (Math.random() * letras.length)]);
        if (!letra1.equals(" "))
            letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String letra2 = String.valueOf(letras[(int) (Math.random() * letras.length)]);
        if (!letra2.equals(" "))
            letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String letra3 = String.valueOf(letras[(int) (Math.random() * letras.length)]);

        return String.format("%04d", numero) + "-" + letra1 + letra2 + letra3;
    }

    protected void log(String msg){
        String tipo;
        if (this instanceof Coche) tipo = "Coche";
        else  if (this instanceof Camion) tipo = "Camion";
        else tipo = "Vehiculo";
        System.out.println(tipo + " con matricula: " + this.matricula + " \"" + msg + "\"");
    }

    public String getMatricula() {
        return matricula;
    }

    public double getMaxLitrosDeposito() {
        return maxLitrosDeposito;
    }

    public double getMaxLitrosReserva() {
        return maxLitrosReserva;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public double getConsumoMedio100km() {
        return consumoMedio100km;
    }

    public boolean isMotorArrancado() {
        return motorArrancado;
    }

    public void setMotorArrancado(boolean motorArrancado) {
        this.motorArrancado = motorArrancado;
    }

    public boolean isEstaEnReserva() {
        return estaEnReserva;
    }

    public void setEstaEnReserva(boolean estaEnReserva) {
        this.estaEnReserva = estaEnReserva;
    }

    public double getCombustibleActual() {
        return combustibleActual;
    }

    public void setCombustibleActual(double combustibleActual) {
        this.combustibleActual = combustibleActual;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void arrancarMotor(){
        if (motorArrancado){
            log("El motor ya esta arrncado");
            return;
        }
        if (combustibleActual <= 0) {
            log("Combustible insuficiente");
            return;
        }
        motorArrancado = true;
        log("Motor arrancado");
    }

    public void pararMotor(){
        if (!motorArrancado){
            log("El motor ya esta parado");
            return;
        }
        motorArrancado = false;
        log("Motor parado");
    }

    public  void repostar(double litros){
        if (litros <= 0){
            log("No se puede repostar una cantidad negativa o cero");
            return;
        }
        if (combustibleActual + litros > maxLitrosDeposito){
            log("No se puede repostar mas de " + maxLitrosDeposito + " litros");
            return;
        }
        combustibleActual += litros;
        log("Repostado " + litros + " litros");
    }

    public void fijarVelocidad(double velocidad){
        if (velocidad < 0){
            log("No se puede fijar una velocidad negativa");
            return;
        }
        if (velocidad > velocidadMaxima){
            log("No se puede fijar una velocidad superior a " + velocidadMaxima + " km/h");
            return;
        }
        if (!motorArrancado){
            log("No se puede fijar una velocidad si el motor no esta arrancado");
            return;
        }
        velocidadActual = velocidad;
        log("Velocidad fijada a " + velocidad + " km/h");
    }

    public abstract void recorrerKilometros(double kilometros);


    @Override
    public String toString() {
        return
                "  matricula: " + matricula + "\n" +
                        "  maxLitrosDeposito: " + maxLitrosDeposito + "\n" +
                        "  maxLitrosReserva: " + maxLitrosReserva + "\n" +
                        "  velocidadMaxima: " + velocidadMaxima + "\n" +
                        "  consumoMedio100km: " + consumoMedio100km + "\n" +
                        "  motorArrancado: " + motorArrancado + "\n" +
                        "  estaEnReserva: " + estaEnReserva + "\n" +
                        "  combustibleActual: " + combustibleActual + "\n" +
                        "  velocidadActual: " + velocidadActual + "\n" +
                        "  kilometraje: " + kilometraje;
    }

}
