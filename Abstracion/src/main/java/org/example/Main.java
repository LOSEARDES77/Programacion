package org.example;

public class Main {
    public static void main(String[] args) {
        Coche c = new Coche("4544-FNJ",60, 180,5.9);
        Camion c1 = new Camion("“8899-ZTR",100, 170,9.4, 1000);

        c.repostar(20);
        c1.repostar(20);
        c1.carga(1000);
        c.arrancarMotor();
        c1.arrancarMotor();
        c.setVelocidadActual(100);
        c1.setVelocidadActual(100);
        c.recorrerKilometros(100);
        c1.recorrerKilometros(100);
        System.out.println("Coche: " + c.getCombustibleActual() + " Litros\nCamion: " + c1.getCombustibleActual() + " Litros");
        Vehiculo v = new Vehiculo("4544-FNJ",60, 180,5.9) {
            @Override
            public void recorrerKilometros(double kilometros) {

            }
        };
    }
}