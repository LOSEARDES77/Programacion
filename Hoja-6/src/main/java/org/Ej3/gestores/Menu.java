package org.Ej3.gestores;

import org.Ej3.interfaz.Leer;
import org.Ej3.modelo.Adosado;
import org.Ej3.modelo.Chalet;
import org.Ej3.modelo.Piso;
import org.Ej3.modelo.Vivienda;

public class Menu {
    /*
    Crear el menú
    • 1.Alta piso
    • 2.Alta adosado
    • 3.Alta chalet
    • 4.Listado viviendas
    • 5.Listado pisos
    • 6.Listado chalets
    • 7.Listado adosados
    • 8.Fin
    */

    public static void mostrarMenu() {
        System.out.println("1) Alta piso");
        System.out.println("2) Alta adosado");
        System.out.println("3) Alta chalet");
        System.out.println("4) Listado viviendas");
        System.out.println("5) Listado pisos");
        System.out.println("6) Listado chalets");
        System.out.println("7) Listado adosados");
        System.out.println("8) Fin");
    }

    public static int leerOpcion() {
        return Leer.entero("Introduzca una opción");
    }


    public static Piso altaPiso(int arraySize) {
        String direccion = Leer.cadena("Introduzca la dirección");
        double precio = Leer.decimal("Introduzca el precio");
        String comunidad = Leer.cadena("Introduzca la comunidad");
        int nPiso = Leer.entero("Introduzca el número de piso");
        return new Piso(direccion, precio, arraySize, comunidad, nPiso);
    }

    public static Adosado altaAdosado(int arraySize) {
        String direccion = Leer.cadena("Introduzca la dirección");
        double precio = Leer.decimal("Introduzca el precio");
        int metrosJardin = Leer.entero("Introduzca los metros de jardín");
        int numCase = Leer.entero("Introduzca el número de casa");
        return new Adosado(direccion, precio, arraySize, metrosJardin, numCase);
    }

    public static Chalet altaChalet(int arraySize) {
        String direccion = Leer.cadena("Introduzca la dirección");
        double precio = Leer.decimal("Introduzca el precio");
        int metrosJardin = Leer.entero("Introduzca los metros de jardín");
        boolean piscina = Leer.siOno("¿Tiene piscina?");
        return new Chalet(direccion, precio, arraySize, metrosJardin, piscina);
    }
}
