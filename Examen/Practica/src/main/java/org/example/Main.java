package org.example;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el salario base de la empresa: ");
        double salarioBase = Double.parseDouble(sc.nextLine());
        HashMap<String, Empleado> empleados = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            Empleado empleado = new Empleado(genNombre(), genApellido(), salarioBase);
            empleados.put(empleado.getCodEmpleado(), empleado);
        }
        while (true){
            System.out.println("Que desea hacer?");
            System.out.println("1) Listado de empleados");
            System.out.println("2) Modificacion de datos");
            System.out.println("3) Nomina");
            System.out.println("4) Modificacion de salario base");
            System.out.println("0) Salir");
            System.out.print("\nIntroduce la opcion: ");
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println();
                    String splitter = "|------------".repeat(2) + "|" + "-".repeat(20) + "|------------".repeat(2) + "|";
                    System.out.println(splitter + "\n|   Codigo   |   Nombre   |      Apellido      |   Hijos    |   Sueldo   |");
                    for (Empleado e : empleados.values()) {
                        System.out.println(splitter);
                        System.out.println(e);
                    }
                    System.out.println(splitter);
                    break;
                case 2:
                    System.out.print("Introduce el codigo de empleado: ");
                    String codEmpleado = sc.nextLine();
                    Empleado e = empleados.get(codEmpleado);
                    if (Objects.isNull(e)){
                        System.out.println("Empleado no encontrado");
                    }else {
                        System.out.println("Que quieres modificar?");
                        System.out.println("1) Añadir un hijo mas");
                        System.out.println("2) Complemento de destino");
                        System.out.print("Introduce la opcion: ");
                        int opt = Integer.parseInt(sc.nextLine());
                        switch (opt){
                            case 1:
                                e.setNumeroDehijos(e.getNumeroDehijos()+1);
                                break;
                            case 2:
                                System.out.println("Introduce el nuevo complemento");
                                double nuevaCantidad = Double.parseDouble(sc.nextLine());
                                e.setComplementoDeDestino(nuevaCantidad);
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Introduce el codigo de empleado: ");
                    String codEmpleado2 = sc.nextLine();
                    Empleado e2 = empleados.get(codEmpleado2);
                    System.out.print("Introduce la fecha con formato dd/mm/yyyy: ");
                    String fecha = sc.nextLine();
                    if (Objects.isNull(e2)){
                        System.out.println("Empleado no encontrado");
                    }else {
                        double irpf;
                        if (e2.getSalario() < 1500)
                            irpf = 0.1;
                        else if (e2.getSalario()< 2500)
                            irpf = 0.15;
                        else
                            irpf = 0.2;
                        double salarioTotal = getSalarioTotal(fecha, salarioBase, e2);
                        System.out.println("\n" + e2.getCodEmpleado());
                        System.out.println(e2.getApellidos() + ", " + e2.getNombre());
                        System.out.println(fecha + "\n");
                        System.out.printf("\tSalario Base \t\t\t\t%.2f\n", salarioBase);
                        System.out.printf("\tComplemento de destino \t\t%.2f\n",e2.getComplementoDeDestino());
                        System.out.printf("\tIRPF (" + (int) (irpf*100) + "%%)\t\t\t\t\t%.2f\n", (salarioTotal * irpf));
                        if (e2.getNumeroDehijos() > 0 && (Objects.equals(fecha.split("/")[1], "9") || Objects.equals(fecha.split("/")[1], "09")))
                            System.out.printf("\tAyuda social \t\t\t\t%.2f", (double) (e2.getNumeroDehijos() * 150));
                        System.out.printf("\n\tTotal a percibir \t\t\t%.2f\n\n", salarioTotal);
                    }
                    break;
                case 4:
                    System.out.print("Introduce el nuevo salario base: ");
                    double nuevoSalarioBase = Double.parseDouble(sc.nextLine());
                    for (Empleado e3 : empleados.values()){
                        e3.setSalarioBase(nuevoSalarioBase);
                    }
                    salarioBase = nuevoSalarioBase;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }
    }

    private static double getSalarioTotal(String fecha, double salarioBase, Empleado e2) {
        double salarioTotal;
        if (Objects.equals(fecha.split("/")[1], "6") || Objects.equals(fecha.split("/")[1], "06") || Objects.equals(fecha.split("/")[1], "12"))
            salarioTotal = salarioBase * 2 + e2.getComplementoDeDestino();
        else if (Objects.equals(fecha.split("/")[1], "9") || Objects.equals(fecha.split("/")[1], "09"))
            salarioTotal = salarioBase + e2.getComplementoDeDestino() + (e2.getNumeroDehijos() * 150);
        else
            salarioTotal = e2.getSalario();
        return salarioTotal;
    }

    private static String genNombre() {
        String[] nombres = {"Juan", "Pedro", "Luis", "Antonio", "Jose", "Maria", "Ana", "Rosa", "Luisa", "Carmen", "Manuel", "Javier", "Francisco", "Jorge", "Alberto", "Raul", "Ramon", "Roberto", "Ricardo", "Rafael", "Fernando", "Sergio", "Miguel", "Daniel", "David", "Diego", "Carlos", "Pablo", "Alvaro", "Alejandro", "Adrian", "Enrique", "Oscar", "Marcos", "Mario", "Marta", "Sara", "Laura", "Paula", "Elena", "Cristina", "Sandra", "Lucia", "Silvia", "Nerea", "Alba", "Celia", "Nuria", "Carmen", "Rocio", "Patricia", "Isabel", "Sonia", "Beatriz", "Eva", "Alicia", "Raquel", "Miriam", "Lorena", "Ainhoa", "Irene", "Clemencia"};
        return nombres[(int) (Math.random() * nombres.length)];
    }

    private static String genApellido(){
        String[] apellidos = {"García", "Fernández", "González", "Rodríguez", "López", "Martínez", "Sánchez", "Pérez", "Gómez", "Martín", "Jiménez", "Ruiz", "Hernández", "Díaz", "Moreno", "Muñoz", "Álvarez", "Romero", "Alonso", "Gutiérrez", "Navarro", "Torres", "Domínguez", "Vargas", "Gil", "Ramos", "Serrano", "Blanco", "Molina", "Morales", "Suárez", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Marín", "Santos", "Iglesias", "Vega", "Herrera", "Peña", "Medina", "Castillo", "Aguilar", "Cortés", "Santiago", "Guerrero", "Campos", "Garrido", "Carrasco", "Prieto", "Rojas", "Mendoza", "Arias", "Vázquez", "Benítez", "Mata", "Roldán", "Soto", "Contreras", "Cabrera", "Pascual", "Gracia"};
        return apellidos[(int) (Math.random() * apellidos.length)] + " " + apellidos[(int) (Math.random() * apellidos.length)];
    }
}