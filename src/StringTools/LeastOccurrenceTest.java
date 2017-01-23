package StringTools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aria Pahlavan on 1/19/17.
 */
class LeastOccurrenceTest {
    
    List<String> input1;
    List<Integer> input2;
    List<Character> input3;
    List<Double> input4;
    List<String> input5;
    
    @BeforeEach
    void setUp() {
        input1 = Arrays.asList("USA", "USA", "USA", "Canada", "China", "China", "China", "China", "Iran");
        input2 = Arrays.asList(5, 1, 0, 9, 8, 5, 6, 5, 0, 0);
        input3 = Arrays.asList('a', 'a', 'B', 'g', 'A', 'Z', 'b', 'b', 'A');
        input4 = Arrays.asList(5.0, 1.0, 0.0, 9.0, 8.0, 5.0, 6.0, 5.0, 0.0);
        input5 = Arrays.asList("a", "a", "B", "g", "A", "Z", "b", "b", "A");
    }
    
    @Test
    void printLeastOccurInLeast() {
        callFunc(input1);
        callFunc(input2);
        callFunc(input3);
        callFunc(input4);
        callFunc(input5);
    }
    
    private static <T extends Comparable<? super T>> void callFunc(List<T> input) {
        long start = System.nanoTime();
        
        StringTools.LeastOccurrence.printLeastOccurInLeast(input);
        
        System.out.println((System.nanoTime() - start) / 10e6 + " ms");
    }
}