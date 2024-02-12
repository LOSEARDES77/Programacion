package org.Ej2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            Personal p = new Personal();
            System.out.println("Elige una opcion: ");
            System.out.println("    1) Alta Asalariado");
            System.out.println("    2) Alta Voluntario");
            System.out.println("    3) Listado Cooperantes");
            System.out.println("    4) Listado Asalariados");
            System.out.println("    5) Listado Voluntarios");
            System.out.println("    6) Salir");
            String i = "";
            try {
                i = r.readLine();
                int input = Integer.parseInt(i);
                switch (input){
                    case 1 -> p.altaAsalariado((Asalariado) introducirDatos(r, 1));
                    case 2 -> p.altaVoluntario((Voluntario) introducirDatos(r, 2));
                    case 3 -> p.listarCooperantes();
                    case 4 -> p.listadoAsalariados();
                    case 5 -> p.listadoVoluntarios();
                    case 6 -> System.exit(0);
                    default -> System.out.println("Elige una opcion del 1 al 6\nHas introducido \"" + i + "\"");

                }
            }catch (IOException e){
                System.out.println("No se ha podido leer la entrada");
            }catch (NumberFormatException e){
                System.out.println("\"" + i + "\" No es un numero" );
            }
        }
    }

    private static Cooperante introducirDatos(BufferedReader r) throws IOException {
        return introducirDatos(r, 0);
    }
    private static Cooperante introducirDatos(BufferedReader r, int target) throws IOException {
        System.out.print("Introduce el nombre: ");
        String nombre = r.readLine();
        System.out.print("Introduce el dni: ");
        String dni = r.readLine();
        System.out.print("Introduce el pais: ");
        String pais = r.readLine();
        return switch (target){
            case 0 -> new Cooperante(nombre, dni, pais);
            case 1 -> {
                System.out.print("Introduce el sueldo: ");
                double sueldo = Double.parseDouble(r.readLine());
                yield new Asalariado(nombre, dni, pais, sueldo);
            }
            case 2 -> {
                System.out.print("Introduce la ong: ");
                String ong = r.readLine();
                yield new Voluntario(nombre, dni, pais, ong);
            }
            default -> null;
        };

    }

}
