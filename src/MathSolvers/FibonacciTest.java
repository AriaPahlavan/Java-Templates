package MathSolvers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Aria Pahlavan on 1/22/17.
 */
class FibonacciTest {
    private List<BigInteger> actualResults = new ArrayList<>();
    private List<Integer> expectedResults = Arrays.asList(
            1,
            1,
            2,
            3,
            5,
            8,
            13,
            21,
            34,
            55,
            89,
            144,
            233,
            377,
            610,
            987,
            1597,
            2584,
            4181,
            6765,
            10946,
            17711,
            28657,
            46368,
            75025,
            121393,
            196418,
            317811,
            514229,
            832040);
    
    @BeforeEach
    void setUp() {
        Thread th[] = new Thread[30];
        Fibonacci fibonacci[] = new Fibonacci[30];
        
        for ( int i = 0; i < 30; i++ ) {
            fibonacci[i] = new Fibonacci(BigInteger.valueOf(i));
            th[i] = new Thread(fibonacci[i]::func);
            th[i].start();
        }
        
        Arrays.stream(th).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
            }
        });
        
        actualResults = Arrays.stream(fibonacci)
                                .map(MathClass::getResult)
                                .collect(Collectors.toList());
    }
    
    @Test
    void testFibonacci() {
        Object[] actual = actualResults.stream()
                                        .map(BigInteger::intValue)
                                        .collect(Collectors.toList()).toArray();
    
        assertArrayEquals(actual,  expectedResults.toArray());
    }
    
}