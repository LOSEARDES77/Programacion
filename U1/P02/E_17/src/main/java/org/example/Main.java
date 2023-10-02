package org.example;

import java.util.Scanner;

public class Main {
    private static String frac1;
    private static String frac2;
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce una fraccion (ej: 1/2): ");
        frac1 = teclado.nextLine();
        System.out.print("Introduce otra fraccion (ej: 1/2): ");
        frac2 = teclado.nextLine();
        boolean test = true;
        String result = "";
        do {
            System.out.print("Introduce una operacion (ej: +,-,*,/): ");
            String operacion = teclado.nextLine();
            switch (operacion) {
                case "+":
                    result = suma();
                    test = false;
                    break;
                case "-":
                    result = resta();
                    test = false;
                    break;
                case "*":
                    result = mult();
                    test = false;
                    break;
                case "/":
                    result = div();
                    test = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }while(test);
        System.out.println(simp(result));
    }

    private static String div() {
        int num1 = Integer.parseInt(frac1.split("/")[0]);
        int den1 = Integer.parseInt(frac1.split("/")[1]);
        int num2 = Integer.parseInt(frac2.split("/")[0]);
        int den2 = Integer.parseInt(frac2.split("/")[1]);
        return (num1 * den2) + "/" + (den1*num2);
    }

    private static String mult() {
        int num1 = Integer.parseInt(frac1.split("/")[0]);
        int den1 = Integer.parseInt(frac1.split("/")[1]);
        int num2 = Integer.parseInt(frac2.split("/")[0]);
        int den2 = Integer.parseInt(frac2.split("/")[1]);
        return (num1*num2) + "/" + (den1*den2);
    }

    private static String resta() {
        int num1 = Integer.parseInt(frac1.split("/")[0]);
        int den1 = Integer.parseInt(frac1.split("/")[1]);
        int num2 = Integer.parseInt(frac2.split("/")[0]);
        int den2 = Integer.parseInt(frac2.split("/")[1]);
        if (den1 == den2){
            return (num1 - num2) + "/" + den1;
        }else{
            return (num1*den2 - num2*den1) + "/" + (den1*den2);
        }
    }

    private static String suma(){
        int num1 = Integer.parseInt(frac1.split("/")[0]);
        int den1 = Integer.parseInt(frac1.split("/")[1]);
        int num2 = Integer.parseInt(frac2.split("/")[0]);
        int den2 = Integer.parseInt(frac2.split("/")[1]);
        if (den1 == den2){
            return (num1 + num2) + "/" + den1;
        }else{
            return (num1*den2 + num2*den1) + "/" + (den1*den2);
        }
    }
    public static String simp(String frac){
        int num = Integer.parseInt(frac.split("/")[0]);
        int den = Integer.parseInt(frac.split("/")[1]);
        for (int i = 2; i < Math.max(num,den); i++){
            while (num % i == 0 && den % i == 0){
                num /= i;
                den /= i;
            }
        }
        return num + "/" + den;
    }
}