package org.example;

import java.util.Scanner;

/*
    0) Salir del programa. Cuando el usuario introduzca 0 el programa finalizara
    1) Nueva primitiva. (0.25 ptos)
        Pedir al usuario por teclado una fecha, y creará un objeto de la clase Primitiva y lo insertará en el vector de Primitivas
		    Escriba fecha: 20/10/2001
	    Si el vector está lleno visualizará en consola el mensaje:
		    Error al insertar
	    Si la inserción se ha realizado con éxito, visualizará en consola el mensaje:
		    Se ha insertado la primitiva en el inventario de lotería exitosamente
    2) Mostrar todas las primitivas celebradas. (0,5 ptos)

	    imprimirá por pantalla todas las primitivas almacenadas

    3) Comprobar aciertos (0,5 ptos)

        Leerá por teclado una fecha (no se pide la comprobación de la fecha correcta), buscara si hay primitivas para esa fecha y si hay pedirá el boleto al usuario (usando el método de clase leerBoletoUsuario de la clase Primitiva ) y buscara cuantos aciertos ha tenido ese usuario para la primitiva de esa fecha, indicando de la siguiente forma:
		    Primitiva [fecha=10/12/22 combinacionGanadora=12|9|26|22|36|34]
		    Numero de aciertos: 2
	    Si no hay primitivas para esa fecha debe escribir por pantalla
		    No existe registro de loteria en esa fecha

    Este programa principal main deberá escribir en consola un menú con las dos opciones indicadas en cada iteración del bucle de gestión. este programa principal main deberá valorar que la opción de menú esta sea válida (comprendida entre 0 y 2) Si una acción de menú no es válida volver al menú

*/

public class Main {
    public static void main(String[] args) {
        // Menu
        Scanner scanner = new Scanner(System.in);
        Primitiva[] inventario = new Primitiva[10];
        while (true){
            System.out.println(" 0) Salir");
            System.out.println(" 1) Nueva primitiva");
            System.out.println(" 2) Mostrar todas las primitivas celebradas");
            System.out.println(" 3) Comprobar aciertos");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            switch (opcion){
                case 0:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Nueva primitiva");

                    break;
                case 2:
                    System.out.println("Mostrar todas las primitivas celebradas");
                    break;
                case 3:
                    System.out.println("Comprobar aciertos");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        }
    }
}