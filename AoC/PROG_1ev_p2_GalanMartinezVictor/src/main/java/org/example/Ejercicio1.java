package org.example;

import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "";
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
        List<Character> letrasValidas = List.of('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z');
        for (int i = 1; i < 4; i++){
            if (!letrasValidas.contains(matricula.toUpperCase().charAt(matricula.length()-i)))
                return false;
        }
        return true;
    }

}
