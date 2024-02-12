package org.Ej2;

public class Cooperante {
    private final String nombre;
    private final String dni;
    private final String pais;

    public Cooperante(String nombre, String dni, String pais) {
        this.nombre = nombre;
        this.dni = dni;
        this.pais = pais;
    }

    @Override
    public String toString() {
        String tipo;
        String addition = "";
        if (this instanceof Voluntario v){
            tipo = "Voluntario";
            addition = "\nong ->   \t" + v.ong;
        }
        else if (this instanceof Asalariado a) {
            tipo = "Asalariado";
            addition = "\nsueldo ->\t" + a.sueldo;
        }else
            tipo = "Cooperante";

        return tipo + ":\n" +
                "nombre ->\t" + nombre + '\n' +
                "dni ->   \t" + dni + '\n' +
                "pais ->  \t" + pais +
                addition;

    }


}
