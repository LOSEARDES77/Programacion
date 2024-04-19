package org.example;

import java.io.Serializable;

public class Coche implements Serializable {
    private final String matricula;
    private final String modelo;
    private final String marca;

    private static final String[] marcas = {"Toyota", "Nissan", "Honda", "Ford", "Chevrolet", "Volkswagen", "Hyundai", "Kia", "Mercedes Benz", "BMW", "Audi"};
    private static final String[] modelosAudis = {"A1", "A3", "A4", "A5", "A6", "A7", "A8", "Q2", "Q3", "Q5", "Q7", "Q8", "TT", "R8"};
    private static final String[] modelosBMWs = {"Serie 1", "Serie 2", "Serie 3", "Serie 4", "Serie 5", "Serie 6", "Serie 7", "X1", "X2", "X3", "X4", "X5", "X6", "X7", "Z4", "M2", "M3", "M4", "M5", "M6", "M8", "i3", "i8"};
    private static final String[] modelosChevrolets = {"Spark", "Matiz", "Aveo", "Sonic", "Cruze", "Malibu", "Impala", "Camaro", "Corvette", "Traverse", "Equinox", "Suburban", "Tahoe", "Trax", "Blazer", "Colorado", "Silverado", "Express"};
    private static final String[] modelosVolksWagens = {"Up!", "Polo", "Golf", "Jetta", "Beetle", "Passat", "Arteon", "Tiguan", "Atlas", "Teramont", "Touareg", "ID.3", "ID.4", "ID.5", "ID.6", "T-Cross", "T-Roc", "Tharu", "Taos", "Nivus", "Amarok", "Saveiro", "Crafter"};
    private static final String[] modelosFords = {"Fiesta", "Focus", "Fusion", "Mustang", "Taurus", "Escape", "Edge", "Flex", "Explorer", "Expedition", "EcoSport", "Ranger", "F-150", "Super Duty", "Transit"};
    private static final String[] modelosHondas = {"Brio", "Fit", "City", "Civic", "Accord", "HR-V", "CR-V", "Pilot", "Odyssey", "Passport", "Ridgeline"};
    private static final String[] modelosHyundais = {"Grand i10", "Accent", "Elantra", "Sonata", "i40", "Ioniq", "Veloster", "Kona", "Tucson", "Santa Fe", "Palisade", "H1", "H100", "Starex", "Porter", "HD65", "HD78", "HD120", "HD170", "Mighty"};
    private static final String[] modelosKias = {"Picanto", "Rio", "Forte", "Optima", "Stinger", "Cadenza", "K900", "Soul", "Niro", "Sportage", "Seltos", "Sorento", "Telluride", "Mohave", "Carnival", "Sedona"};
    private static final String[] modelosMercedesBenzs = {"Clase A", "Clase B", "Clase C", "Clase E", "Clase S", "Clase G", "Clase M", "Clase R", "Clase GLA", "Clase GLK", "Clase GLC", "Clase GLE", "Clase GLS", "Clase GLE Coupé", "Clase GLC Coupé", "Clase GLE"};
    private static final String[] modelosNissans = {"March", "Versa", "Sentra", "Altima", "Maxima", "Kicks", "Juke", "Qashqai", "X-Trail", "Rogue", "Murano", "Pathfinder", "Armada", "Patrol", "Frontier", "Titan", "Navara", "NP300", "Leaf", "370Z", "GT-R"};
    private static final String[] modelosToyotas = {"Yaris", "Corolla", "Camry", "Avalon", "86", "Prius", "Mirai", "Rav4", "Highlander", "4Runner", "Sequoia", "Land Cruiser", "C-HR", "Tacoma", "Tundra", "Sienna", "Supra"};


    public Coche(){
        this.matricula = generarMatricula();
        this.marca = marcas[(int)(Math.random() * marcas.length)];
        switch(this.marca){
            case "Toyota":
                this.modelo = modelosToyotas[(int)(Math.random() * modelosToyotas.length)];
                break;
            case "Nissan":
                this.modelo = modelosNissans[(int)(Math.random() * modelosNissans.length)];
                break;
            case "Honda":
                this.modelo = modelosHondas[(int)(Math.random() * modelosHondas.length)];
                break;
            case "Ford":
                this.modelo = modelosFords[(int)(Math.random() * modelosFords.length)];
                break;
            case "Chevrolet":
                this.modelo = modelosChevrolets[(int)(Math.random() * modelosChevrolets.length)];
                break;
            case "Volkswagen":
                this.modelo = modelosVolksWagens[(int)(Math.random() * modelosVolksWagens.length)];
                break;
            case "Hyundai":
                this.modelo = modelosHyundais[(int)(Math.random() * modelosHyundais.length)];
                break;
            case "Kia":
                this.modelo = modelosKias[(int)(Math.random() * modelosKias.length)];
                break;
            case "Mercedes Benz":
                this.modelo = modelosMercedesBenzs[(int)(Math.random() * modelosMercedesBenzs.length)];
                break;
            case "BMW":
                this.modelo = modelosBMWs[(int)(Math.random() * modelosBMWs.length)];
                break;
            case "Audi":
                this.modelo = modelosAudis[(int)(Math.random() * modelosAudis.length)];
                break;
            default:
                this.modelo = "Marca desconocida";
                break;
        }
    }

    public static String generarMatricula(){
        String matricula = "";
        for(int i = 0; i < 4; i++){
            matricula += (int)(Math.random() * 10);
        }
        matricula += " ";
        for(int i = 0; i < 3; i++){
            matricula += (char)(Math.random() * 26 + 65);
        }
        return matricula;
    }

    @Override
    public String toString() {
        return "Coche: \n" +
                "\tMatricula:\t" + matricula + "\n" +
                "\tMarca:  \t" + marca + "\n" +
                "\tModelo: \t" + modelo;
    }
}


