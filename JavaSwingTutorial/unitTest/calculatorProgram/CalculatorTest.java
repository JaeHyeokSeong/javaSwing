package calculatorProgram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// https://es2sun.tistory.com/216

class CalculatorTest {

    @Test
    void add() {
        assertEquals(10, Calculator.add(5, 5));
    }

    @Test
    void minus() {
        assertEquals(5, Calculator.minus(10, 5));
    }

    @Test
    void multiply() {
        assertEquals(100, Calculator.multiply(10, 10));
    }

    @Test
    void divide() {
        assertEquals(2, Calculator.divide(10, 5));
    }
}