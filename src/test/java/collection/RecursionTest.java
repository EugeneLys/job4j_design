package collection;

import collection.recursion.Recursion;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RecursionTest {

    @Test
    void checkSummary() {
        Recursion recursion = new Recursion();
        boolean result = recursion.loop(1, 5) == recursion.sum(1, 5);
        assertThat(result).isTrue();
    }

    @Test
    void checkFactorial() {
        Recursion recursion = new Recursion();
        boolean result = recursion.factorialLoop(0) == recursion.factorialRecursion(0);
        assertThat(result).isTrue();
        result = recursion.factorialLoop(1) == recursion.factorialRecursion(1);
        assertThat(result).isTrue();
        result = recursion.factorialLoop(5) == recursion.factorialRecursion(5);
        assertThat(result).isTrue();
    }

    @Test
    void checkFibonacci() {
        Recursion recursion = new Recursion();
        boolean result = recursion.fibonacciLoop(0) == recursion.fibonacciRecursion(0);
        assertThat(result).isTrue();
        result = recursion.fibonacciLoop(1) == recursion.fibonacciRecursion(1);
        assertThat(result).isTrue();
        result = recursion.fibonacciLoop(7) == recursion.fibonacciRecursion(7);
        assertThat(result).isTrue();
    }
}