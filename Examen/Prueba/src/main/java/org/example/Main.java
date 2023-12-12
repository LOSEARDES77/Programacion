package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inv = new Inventario(200);
        int autonumerico = 0;

        while (true){
            System.out.println("0) Salir del programa");
            System.out.println("1) Insertar un producto en la promera posicion");
            System.out.println("2) Buscar un producto por codigo");
            System.out.println("3) Consultar los productos pertecederos");
            System.out.print("Introduce la opcion: ");
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    System.out.println("1) Es perecedero");
                    System.out.println("2) No es perecedero");
                    System.out.print("Introduce la opcion: ");
                    int opcion1 = Integer.parseInt(sc.nextLine());
                    if (opcion1 == 1){
                        inv.insertarAlPrincipio(new Producto(autonumerico, true));
                    }else {
                        inv.insertarAlPrincipio(new Producto(autonumerico, false));
                    }
                    autonumerico++;
                    break;

                case 2:
                    System.out.print("Introduce el codigo de producto: ");
                    int codigo = Integer.parseInt(sc.nextLine());
                    int posicion = inv.buscarProducto(codigo);
                    if (posicion != -1){
                        System.out.println("El producto esta en " + posicion);
                    }
                    break;

                case 3:
                    System.out.println("Lista de productos caducados: ");
                    for (int i = 0; i < inv.productorCaducados().length; i++){
                        System.out.println(inv.productorCaducados()[i]);
                    }
                    break;
            }
        }

    }
}