package org.example;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit {
    @ParameterizedTest
    @CsvSource({"1,2,3", "3,6,9", "1,9,10"})
    void test(int a, int b, int res){

        assertEquals(res, a+b);
    }
}
