package org.example;

import java.util.Scanner;

public class Primitiva {
    private String fecha;
    private int[] conbinacionGanadora;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int[] getConbinacionGanadora() {
        return conbinacionGanadora;
    }

    public void setConbinacionGanadora(int[] conbinacionGanadora) {
        this.conbinacionGanadora = conbinacionGanadora;
    }

    public Primitiva(String fecha) {
        this.fecha = fecha;
        this.conbinacionGanadora = generarConbinacionGanadora();
    }

    private static boolean estaRepetido(int numero, int[] vector){
        for (int i = 0; i < vector.length; i++){
            if (numero == vector[i])
                return true;
        }
        return false;
    }

    private int[] generarConbinacionGanadora() {
        int[] resultado = new int[6];
        for (int i = 0; i < 6; i++){
            int nuevoNumero;
            do {
                 nuevoNumero = ((int) (Math.random() * 50)) + 1;
            }while (estaRepetido(nuevoNumero, resultado));
            resultado[i] = nuevoNumero;
        }
        return resultado;
    }

    public String toString(){
        String resultado = "Primitiva [fecha=" + fecha + " conbinacionGanadora=";
        for (int i = 0; i < 6; i++){
            if (i == 5)
                resultado += conbinacionGanadora[i] + "]";
            else
                resultado += conbinacionGanadora[i] + " | ";
        }
        return resultado;
    }

    public static int[] leerBoletoUsuario(){
        Scanner sc = new Scanner(System.in);
        int[] numerosIntroducidos = new int[6];
        for(int i = 0; i < 6; i++){
            int numeroIntroducido = 0;
            do {
                if (numeroIntroducido != 0)
                    System.out.println("Error: El numero debe estar entre 1 y 49 y no estar rpetido");

                System.out.print("Introduce un numero del 1 al 49: ");
                numeroIntroducido = Integer.parseInt(sc.nextLine());
            }while ((numeroIntroducido < 1 || numeroIntroducido > 49) || estaRepetido(numeroIntroducido, numerosIntroducidos));
            numerosIntroducidos[i] = numeroIntroducido;
        }
        return numerosIntroducidos;
    }

    public int comrobarAciertos(int[] vector){
        int aciertos = 0;
        for (int i = 0; i < vector.length; i++){
            for (int j = 0; j < conbinacionGanadora.length; j++){
                if (vector[i] == conbinacionGanadora[j])
                    aciertos++;
            }
        }
        return aciertos;
    }
}
