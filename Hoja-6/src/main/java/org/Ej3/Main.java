package org.Ej3;

import org.Ej3.gestores.Menu;
import org.Ej3.modelo.Adosado;
import org.Ej3.modelo.Chalet;
import org.Ej3.modelo.Piso;
import org.Ej3.modelo.Vivienda;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vivienda> listadoViviendas = new ArrayList<>();
        while (true){
            Menu.mostrarMenu();
            int opcion = Menu.leerOpcion();
            switch (opcion){
                case 1:
                    listadoViviendas.add(Menu.altaPiso(listadoViviendas.size()));
                    break;
                case 2:
                    listadoViviendas.add(Menu.altaAdosado(listadoViviendas.size()));
                    break;
                case 3:
                    listadoViviendas.add(Menu.altaChalet(listadoViviendas.size()));
                    break;
                case 4:
                    for (Vivienda vivienda : listadoViviendas) {
                        System.out.println(vivienda);
                    }
                    break;
                case 5:
                    for (Vivienda vivienda : listadoViviendas) {
                        if (vivienda instanceof Piso p) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 6:
                    for (Vivienda vivienda : listadoViviendas) {
                        if (vivienda instanceof Chalet c) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 7:
                    for (Vivienda vivienda : listadoViviendas) {
                        if (vivienda instanceof Adosado a) {
                            System.out.println(a);
                        }
                    }
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
