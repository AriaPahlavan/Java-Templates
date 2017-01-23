package StringTools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aria Pahlavan on 1/19/17.
 */
class StringArrayToolsTest {
    
    
    @BeforeEach
    void setUp() {
        
    }
    
    @Test
    void convertToAsciiArray() {
        List res = StringArrayTools.convertToAsciiArray(new String[]{"hello", "testing", "bye"});
        System.out.println(res);
    }
    
    @Test
    void convertToAsciiArrayList() {
        List res = StringArrayTools.convertToAsciiArray(Arrays.asList("hello", "testing", "bye"));
        System.out.println(res);
    }
}