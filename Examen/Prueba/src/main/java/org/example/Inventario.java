package org.example;

import java.util.Arrays;

public class Inventario {
    private final Producto[] inventario;
    private int indice;
    private final int tamanioMaximo;

    public Inventario(int tamanio) {
        this.inventario = new Producto[tamanio];
        indice = 0;
        this.tamanioMaximo = tamanio;
    }

    @Override
    public String toString() {
        if (inventario.length == 0){
            System.out.println("El inventario esta vacio");
        }
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < inventario.length-1; i++){
            if (inventario[i] != null )
                resultado.append("Posicion: ").append(i).append(" ").append(inventario[i].toString()).append("\n");
        }
        return resultado.toString();
    }

    public void insertarAlPrincipio(Producto p){
        if (inventario.length == tamanioMaximo)
            System.out.println("El inventario esta lleno");

        for (int i = indice; i >= 1; i--){
            inventario[i] = inventario[i-1];
        }

        inventario[0] = p;
        indice++;
    }

    public int buscarProducto(int codigo){
        for (int i = 0; i < inventario.length; i++){
            if (inventario[i].getCodigo() == codigo){
                return i+1;
            }
        }
        System.out.println("Producto no encontrado");
        return -1;
    }


    public Producto[] productorCaducados(){
        int numeroDeProductosCaducados = 0;
        for (int i = 0; i < inventario.length; i++){
            if (inventario[i] != null && inventario[i].haCaducado())
                numeroDeProductosCaducados++;
        }
        Producto[] productosCaducados = new Producto[numeroDeProductosCaducados];
        int indice = 0;
        for (int i = 0; i < inventario.length; i++){
            if (inventario[i] != null && inventario[i].haCaducado()) {
                productosCaducados[indice] = inventario[i];
                indice++;
            }
        }
        return productosCaducados;
    }
}
