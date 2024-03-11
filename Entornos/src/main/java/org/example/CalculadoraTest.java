package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class CalculadoraTest {
    //método de pruebas
    @Test
    public void testSuma() {
        int resultado = Calculadora.suma(2, 3);
        int esperado = 5;
//comprobar que son iguales
        assertEquals(esperado, resultado);
    }
    @Test
    public void testResta() {
        int resultado = Calculadora.resta(2, 3);
        int esperado = -1;
//comprobar que son iguales
        assertEquals(esperado, resultado);
    }
}