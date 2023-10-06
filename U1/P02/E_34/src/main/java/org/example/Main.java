package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
/*
    Dado el siguiente array (podéis generarlo aleatoriamente)
    float notas[ ][ ] = {
            {1145f, 6.75f, 5.95f, 0f},
            {7458f, 2.68f, 3.6f, 0f},
            {6689f, 10.00f, 9.75f, 0f},
            {9745f, 7.25f, 6.95f, 0f}
    };
    Los datos se mostrarían de la siguiente manera:
    ALUMNO: 1 Expediente 1145 Notas:6,755,950,00 Nota media:4,23
    ALUMNO: 2 Expediente 7458 Notas:2,683,600,00 Nota media:2,09
    ALUMNO: 3 Expediente 6689 Notas:10,00 9,750,00 Nota media:6,58
    ALUMNO: 4 Expediente 9745 Notas:7,256,950,00 Nota media:4,73
    Se pide:
            1.Pedir por teclado las notas de la última evaluación (Actualmente a 0)
2.Mostrar los datos del mejor alumno y del peor.
3.Mostrar la nota media del curso completo (igual que la tabla superior)
4.Mostrar los datos de todos los alumnos que superen la nota media.
*/
private static float[][] notas;
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("¿Cuántos alumnos hay?: ");
        int alumnos = teclado.nextInt();
        genNotas(alumnos);
        System.out.println("Introduce las notas de la última evaluación");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Alumno " + (i + 1) + " (Expediente " + (int) notas[i][0] +"): ");
            notas[i][3] = teclado.nextFloat();
        }
        printNotas();


    }

    public static void printNotas(){
        System.out.println("Alumno\tExpediente\tNota1\t\tNota2\t\tNota3\t\tMedia");
        for (int i = 0; i < notas.length; i++) {
            // make sure the number occupies 4 spaces
            System.out.printf("%03d\t\t%04d\t\t", i + 1, (int) notas[i][0]);
            for (int j = 1; j < notas[i].length; j++) {
                System.out.printf("%.4f\t\t", notas[i][j]);
            }
            System.out.printf("%.4f",(notas[i][1] + notas[i][2] + notas[i][3]) / 3);
            System.out.println();
        }
    }

    private static void genNotas(int alumnos){
        notas = new float[alumnos][4];
        for (int i = 0; i < alumnos; i++) {
            for (int j = 0; j < 4; j++) {
                if(j == 0){
                    notas[i][j] = (int) (Math.random() * 10000);
                }else if(j < 3){
                    notas[i][j] = (float) (Math.random() * 10);
                }else {
                    notas[i][j] = 0;
                }
            }
        }
    }
}