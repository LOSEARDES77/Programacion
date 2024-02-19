package org.example;

public class Calculadora {
    public static int suma(int a,int b) {
        return a+b;
    }
    public static int resta(int a,int b) {
        return a-b;
    }
    public static void main(String[] args) {
        int a = 3, b=2;
        int res = suma(a, b);
        int esperado = 5;
//opcion 1
        System.out.println("3 + 2 = " + res );
//Que pasa si modifico sin querer a = 2
//opcion 1 (mejorada)
        System.out.println(a + " + " + b + " = " + res );
//opcion 2
        if (res == esperado) {
            System.out.println("Este programa está bien hecho.");
        } else {
            System.out.println("Hay algún ERROR.");
        }
//aunque no quiere decir que este realmente bien o no.
//sino que con estos datos funciona bien.
    }
}
