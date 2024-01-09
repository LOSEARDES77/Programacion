package org.example;

import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada;
        int iteracion = 1;
        do {
            System.out.print("¿Matricula " + iteracion+ "? ");
            entrada = sc.nextLine();
            if (!entrada.equals("*")){
                if (validar(entrada))
                    System.out.println("válida");
                else
                    System.out.println("inválida");

                iteracion++;
            }
        }while (!entrada.equals("*"));
    }

    private static boolean validar(String matricula){
        if (matricula.length() != 7)
            return false;

        for (int i = 0; i < 4; i++){
            if (!Character.isDigit(matricula.charAt(i)))
                return false;
        }
        String letrasValidas = "BCDFGHJKLMNPRSTVWXYZ";
        for (int i = 1; i < 4; i++){
            for (int j = 0; j < letrasValidas.length(); j++){
                if (matricula.toUpperCase().charAt(matricula.length()-i) == letrasValidas.charAt(j))
                    break;
                if (j == letrasValidas.length() - 1)
                    return false;
            }
        }
        return true;
    }

}
