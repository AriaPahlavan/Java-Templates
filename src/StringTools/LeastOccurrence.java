package StringTools;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Aria Pahlavan on 1/17/17.
 */
public class LeastOccurrence {
    
    public static <T extends Comparable<? super T>> void printLeastOccurInLeast
            (Collection<T> inputs){
    
        //Doesn't work!
//        int min = Collections.frequency(inputs, Collections.min(inputs, comp));
        
        Optional<Integer> min = inputs.stream()
                                      .map(a -> Collections.frequency(inputs, a))
                                      .distinct()
                                      .min(Integer::compareTo);
    
        inputs.stream()
                .distinct()
                .filter(a -> Collections.frequency(inputs, a) == min.orElse(0))
                .forEach((x) -> System.out.print(x + ", "));
        System.out.print( "\b\b\t\t\t---------> ");
    }
    
    private static List<String> leastOccurring(List<String> input) {
        if (input.size() <= 2)
            return input;
        return input.stream()
                       .collect(Collectors.groupingBy(Function.identity(),
                               LinkedHashMap::new, // Result in order of first seen
                               Collectors.counting()))
                       .entrySet()
                       .stream()
                       .collect(Collectors.groupingBy(Map.Entry::getValue,
                               TreeMap::new, // So firstEntry() will return least count
                               Collectors.mapping(Map.Entry::getKey,
                                       Collectors.toList())))
                       .firstEntry()
                       .getValue();
    }
}
