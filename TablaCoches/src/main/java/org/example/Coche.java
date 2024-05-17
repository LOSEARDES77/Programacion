package org.example;

public class Coche {
    private final String marca;
    private final String modelo;
    private final double precio;

    private static final String[] modelosAudi = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "Q2", "Q3", "Q5", "Q7", "Q8", "TT", "R8"};
    private static final String[] marcas = {"Audi", "BMW", "Mercedes", "Volkswagen", "Ford", "Renault", "Peugeot", "Citroen", "Opel", "Seat"};
    private static final String[] modelosBMW = {"i3", "i8", "Serie 1", "Serie 2", "Serie 3", "Serie 4", "Serie 5", "Serie 6", "Serie 7", "X1", "X2", "X3", "X4", "X5", "X6", "X7"};
    private static final String[] modelosMercedes = {"Clase A", "Clase B", "Clase C", "Clase E", "Clase S", "Clase G", "Clase GLA", "Clase GLB", "Clase GLC", "Clase GLE", "Clase GLS", "Clase X", "Clase V", "Clase AMG GT", "Clase EQC", "Clase SLS", "Clase Vaneo", "Clase Viano", "Clase Vito", "Clase Sprinter"};
    private static final String[] modelosVolkswagen = {"Golf", "Polo", "Passat", "Tiguan", "Touareg", "Arteon", "T-Roc", "T-Cross", "Up"};
    private static final String[] modelosFord = {"C-Max", "Fiesta", "Focus", "Mondeo", "Kuga", "EcoSport", "Edge", "Mustang", "Ka"};
    private static final String[] modelosRenault = {"Clio", "Captur", "Megane", "Scenic", "Talisman", "Kadjar", "Koleos", "Twingo", "Zoe"};
    private static final String[] modelosPeugeot = {"208", "308", "2008", "3008", "5008", "508", "Rifter", "Partner", "Expert", "Traveller"};
    private static final String[] modelosCitroen = {"C3", "C4", "C5", "C6", "C8", "Berlingo", "Jumpy", "Jumper"};
    private static final String[] modelosOpel = {"Corsa", "Astra", "Insignia", "Mokka", "Crossland X", "Grandland X", "Combo", "Zafira", "Vivaro", "Movano"};
    private static final String[] modelosSeat = {"Ibiza", "Leon", "Arona", "Ateca", "Toldeo", "Alhambra", "Tarraco"};


    public Coche() {
        this.marca = marcas[(int) (Math.random() * marcas.length)];
        switch (marca){
            case "Audi":
                this.modelo = modelosAudi[(int) (Math.random() * modelosAudi.length)];
                break;
            case "BMW":
                this.modelo = modelosBMW[(int) (Math.random() * modelosBMW.length)];
                break;
            case "Mercedes":
                this.modelo = modelosMercedes[(int) (Math.random() * modelosMercedes.length)];
                break;
            case "Volkswagen":
                this.modelo = modelosVolkswagen[(int) (Math.random() * modelosVolkswagen.length)];
                break;
            case "Ford":
                this.modelo = modelosFord[(int) (Math.random() * modelosFord.length)];
                break;
            case "Renault":
                this.modelo = modelosRenault[(int) (Math.random() * modelosRenault.length)];
                break;
            case "Peugeot":
                this.modelo = modelosPeugeot[(int) (Math.random() * modelosPeugeot.length)];
                break;
            case "Citroen":
                this.modelo = modelosCitroen[(int) (Math.random() * modelosCitroen.length)];
                break;
            case "Opel":
                this.modelo = modelosOpel[(int) (Math.random() * modelosOpel.length)];
                break;
            case "Seat":
                this.modelo = modelosSeat[(int) (Math.random() * modelosSeat.length)];
                break;
            default:
                this.modelo = "Modelo no encontrado";
                break;
        }
        this.precio = Math.random() * 100000;
    }

    public String[] toArray() {
        return new String[] {marca, modelo, String.format("%,.2f",precio)};
    }
}
