package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class E04_VectorOrdenado {
    public static void main(String[] args) {
        int[] vec = new int[]{1,2,3,4,5,6,7,9,9};
        System.out.println("El vector "+ Arrays.toString(vec) + ((estaOrdenado(vec)) ? "" : " no") + " esta ordenado");

    }

    private static boolean estaOrdenado(int[] vec) {
        if (vec.length <= 1)
            return true;
        if (vec[0] > vec[1])
            return false;
        int[] vec2 = new int[vec.length-1];

        for (int i = 0; i < vec.length-1; i++)
            vec2[i] = vec[i+1];

        return estaOrdenado(vec2);
    }
}
