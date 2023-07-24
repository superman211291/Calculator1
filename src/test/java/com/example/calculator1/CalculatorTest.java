package com.example.calculator1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static com.example.calculator1.TestArguments.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    TestArguments testArguments;
    private final Calculator calculator = new Calculator();
    public static Stream<Arguments> provideParamsForTestIllegal(){
        return Stream.of(
                Arguments.of(EMPTY_NAME,NUM_0),
                Arguments.of(EMPTY_NAME,EMPTY_NAME),
                Arguments.of(NUM_0,EMPTY_NAME),
                Arguments.of(NUM_0,ILLEGAL)
        );
    }

    @Test
    void sum() {
        String result = calculator.sum(NUM_200,NUM_100);
        Assertions.assertEquals(NUM_300_RESULT, result);
    }

    @Test
    void minus() {
        String result = calculator.minus(NUM_200,NUM_100);
        Assertions.assertEquals(NUM_100_RESULT, result);
    }

    @Test
    void multiply() {
        String result = calculator.multiply(NUM_200,NUM_100);
        Assertions.assertEquals(NUM_20000_RESULT, result);
    }

    @Test
    void divide() {
        String result = calculator.divide(NUM_200,NUM_100);
        Assertions.assertEquals(NUM_2_RESULT, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTestIllegal")
    public void shouldThrowIllegalArgumentException(String input1, String input2){
        assertThrows(IllegalArgumentException.class,()->calculator.sum(input1,input2));
        assertThrows(IllegalArgumentException.class,()->calculator.minus(input1,input2));
        assertThrows(IllegalArgumentException.class,()->calculator.multiply(input1,input2));
        assertThrows(IllegalArgumentException.class,()->calculator.divide(input1,input2));
    }
    @Test
    public void shouldThrowIllegalArgumentDivideByZero(){
        assertThrows(IllegalArgumentException.class,()->calculator.divide(NUM_100,NUM_0));
    }
}