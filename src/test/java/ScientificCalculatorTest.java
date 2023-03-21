import ScientificCalculator.ScientificCalculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class ScientificCalculatorTest {
    private static final double DELTA = 1e-15;
    ScientificCalculator calculator = new ScientificCalculator();

    @Test
    public void squareRootTruePositive() {
        assertEquals("Square Root True Positive Test 1", 11, calculator.squareRoot(121), DELTA);
        assertEquals("Square Root True Positive Test 2", 121, calculator.squareRoot(14641), DELTA);
    }

    @Test
    public void squareRootTrueNegative() {
        assertNotEquals("Square Root True Negative Test 1", 55, calculator.squareRoot(3), DELTA);
        assertNotEquals("Square Root True Negative Test 2", -2, calculator.squareRoot(4), DELTA);
    }

    @Test
    public void factorialTruePositive() {
        assertEquals("Factorial True Positive Test 1", 120, calculator.factorial(5), DELTA);
        assertEquals("Factorial True Positive Test 2", 1, calculator.factorial(0), DELTA);
    }

    @Test
    public void factorialTrueNegative() {
        assertNotEquals("Factorial True Negative Test 1", 69, calculator.factorial(5), DELTA);
        assertNotEquals("Factorial True Negative Test 2", 42, calculator.factorial(10), DELTA);
    }

    @Test
    public void powerTruePositive() {
        assertEquals("Power True Positive Test 1", 32, calculator.power(2, 5), DELTA);
        assertEquals("Power True Positive Test 2", 81, calculator.power(9, 2), DELTA);
    }

    @Test
    public void powerTrueNegative() {
        assertNotEquals("Power True Negative Test 1", 69, calculator.power(2, 2), DELTA);
        assertNotEquals("Power True Negative Test 2", -69420, calculator.power(-2, 20), DELTA);
    }

    @Test
    public void naturalLogTruePositive() {
        assertEquals("Natural Log True Positive Test 1", 0, calculator.naturalLog(1), DELTA);
        assertEquals("Natural Log True Positive Test 2", 5.703782474656201, calculator.naturalLog(300), DELTA);
    }

    @Test
    public void naturalLogTrueNegative() {
        assertNotEquals("Natural Log True Negative Test 1", 69, calculator.naturalLog(2.4), DELTA);
        assertNotEquals("Natural Log True Negative Test 2", 420, calculator.naturalLog(2.1), DELTA);
    }

    


}
