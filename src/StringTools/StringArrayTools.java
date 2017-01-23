package StringTools;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Aria Pahlavan on 1/18/17.
 */
public class StringArrayTools {
    static List convertToAsciiArray(String[] strArray) {
        List result;
        result = Stream.of(strArray)
                         .map(s -> s.chars()
                                           .parallel()
                                           .mapToObj(e -> (char) e)
                                           .collect(Collectors.toList()))
                         .map(chars -> chars.stream()
                                               .map(Integer::new)
                                               .collect(Collectors.toList())
                         )
                         .collect(Collectors.toList());
        
        return result;
    }
    
    static List convertToAsciiArray(List<String> strArray) {
        List result;
        result = strArray.stream()
                         .map(s -> s.chars()
                                           .parallel()
                                           .mapToObj(e -> (char) e)
                                           .collect(Collectors.toList()))
                         .map(chars -> chars.stream()
                                               .map(Integer::new)
                                               .collect(Collectors.toList())
                         )
                         .collect(Collectors.toList());
        
        return result;
    }
}
