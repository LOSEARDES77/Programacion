package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CalcTest {
    @Test
    public void testCalc(){
        Assertions.assertEquals("XXXIX", Main.calculadora("L-XI"));
    }
}
