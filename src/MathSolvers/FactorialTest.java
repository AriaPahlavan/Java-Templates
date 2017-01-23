package MathSolvers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Aria Pahlavan on 1/22/17.
 */
class FactorialTest {
    Factorial factorial;
    Thread th;
    
    @BeforeEach
    void setUp() {
        BigInteger n_factorial = BigInteger.valueOf(6);
        factorial = new Factorial(n_factorial);
        th = new Thread(factorial::func);
    }
    
    @Test
    void testFactorial() {
        th.start();
        
        try { th.join(); }
        catch (InterruptedException ignored) {}
     
        assertEquals(factorial.getResult().intValue(), 720);
    }
    
}