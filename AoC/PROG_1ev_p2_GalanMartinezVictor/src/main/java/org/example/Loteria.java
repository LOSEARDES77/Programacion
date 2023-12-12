package org.example;

public class Loteria {
    private Primitiva[] primitivas;

    public Loteria(int maximoDePrimitivas) {
        this.primitivas = new Primitiva[maximoDePrimitivas];
    }
    public boolean aniadir(Primitiva p){
        for (int i = 0; i < primitivas.length; i++){
            if (primitivas[i] == null){
                primitivas[i] = p;
                return true;
            }
        }
        return false;
    }

    public Primitiva buscar(String feccha){
        for (int i = 0; i < primitivas.length; i++){
            if (primitivas[i] != null){
                if (primitivas[i].getFecha().equals(feccha)){
                    return primitivas[i];
                }
            }
        }
        return null;
    }

    public int comprobar(String fecha, int[] vector){
        Primitiva p = buscar(fecha);
        if (p != null){
            return p.comrobarAciertos(vector);
        }
        return -1;
    }

    public String toString(){
        String resultado = "";
        for (int i = 0; i < primitivas.length; i++){
            if (primitivas[i] != null){
                resultado += primitivas[i].toString() + "\n";
            }
        }
        return resultado;
    }

}
