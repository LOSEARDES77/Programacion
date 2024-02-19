package org.Ej3.modelo;

import java.time.LocalDate;

public class Vivienda {
    private final String codVivienda;
    private String codPropietario;
    private final String direccion;
    private final double precio;
    private final boolean alquiler;

    public Vivienda(String direccion, double precio, int arraySize) {
        if (!esValidoDireccion(direccion))
            throw new IllegalArgumentException("La dirección no es válida");
        if (!esValidoPrecio(precio))
            throw new IllegalArgumentException("El precio no es válido");

        this.direccion = direccion;
        this.precio = precio;
        this.alquiler = esAlquiler(precio);
        this.codVivienda = String.format("%d-%s-%03d", LocalDate.now().getYear(), (alquiler) ? "A" : "V", arraySize + 1);
    }

    private boolean esValidoPropietario(String codPropietario){
        return codPropietario.matches("^[A-Z]\\d{3}$");
    }

    private boolean esValidoDireccion(String direccion){
        return direccion != null && !direccion.isEmpty();
    }

    private boolean esValidoPrecio(double precio){
        return precio > 100;
    }

    private boolean esAlquiler(double precio){
        return precio < 5000;
    }



    public String getCodVivienda() {
        return codVivienda;
    }

    public String getCodPropietario() {
        return codPropietario;
    }

    public void setCodPropietario(String codPropietario) {
        this.codPropietario = codPropietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean esDeAlquiler() {
        return alquiler;
    }

    @Override
    public String toString() {
        if (codPropietario != null)
            return String.format("Código: \t%s\nDirección: \t%s\nPrecio: \t%.2f€\nAlquiler: \t%s\nPropietario: \t%s", codVivienda, direccion, precio, (alquiler) ? "Sí" : "No", codPropietario);

        return String.format("Código: \t%s\nDirección: \t%s\nPrecio: \t%.2f€\nAlquiler: \t%s", codVivienda, direccion, precio, (alquiler) ? "Sí" : "No");
    }
}