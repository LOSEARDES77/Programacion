package org.example;

import java.util.Scanner;

public class MenuLoteria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loteria loteria = new Loteria(20);
        while (true){
            System.out.println("(0) Salir de la aplicacion");
            System.out.println("(1) Celebracion sorteo");
            System.out.println("(2) Mostrar todos los sorteos celebrados");
            System.out.println("(3) Comprobar aciertos de la loteria por fecha");
            System.out.println("Marca opciones del 1 al 3");
            System.out.print("Opcion (0-3)? ");
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 0:
                    System.out.println("Hasta pronto!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Escribe una fecha con formato dd/mm/yyyy: ");
                    String fecha = sc.nextLine();
                    Primitiva p = new Primitiva(fecha);
                    boolean resultado = loteria.aniadir(p);
                    if (resultado)
                        System.out.println("Nuevo sorteo almacenado: \n" + p.toString());
                    else
                        System.out.println("Error al celebrar sorteo");
                    break;

                case 2:
                    System.out.println(loteria.toString());
                    break;
                case 3:
                    System.out.print("Escribe una fecha con formato dd/mm/yyyy: ");
                    String fecha2 = sc.nextLine();
                    if (loteria.buscar(fecha2) == null) {
                        System.out.println("No existe registro de loteria para essa fecha");
                    }else {
                        int[] boletoUsuario = Primitiva.leerBoletoUsuario();
                        int aciertos = loteria.comprobar(fecha2, boletoUsuario);
                        System.out.println("Aciertos: " + aciertos);
                    }
                    break;
                default:
                    System.out.println("La opcion \"" +opcion + "\" no e valida");
                    System.out.println("Debe estar comprendida entre 0 y 3");
                    break;
            }
        }
    }
}
