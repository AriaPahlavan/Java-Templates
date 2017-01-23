package Characters;

import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Created by Aria Pahlavan on 1/19/17.
 */
class MarkTest {
    List<Mark> marks;
    
    @BeforeEach
    void setUp() {
        marks = Arrays.asList(
                new Mark(1, new Student("Aria", "Pahlavan", 23), 1, Major.MATHEMATICS),
                new Mark(2, new Student("Bob", "Johnson", 35), 2, Major.CHEMICAL_ENGR),
                new Mark(3, new Student("Jack", "Knopf", 50), 3, Major.MATHEMATICS),
                new Mark(3, new Student("Jason", "Bern", 50), 3, Major.MATHEMATICS)
    
        );
    }
    
    @org.junit.jupiter.api.Test
    void mark() {
        EnumMap<Major, Integer> enumMap = marks.stream()
                                                  .collect(groupingBy(
                                                          Mark::getMajor,
                                                          () -> new EnumMap<>(Major.class),
                                                          summingInt(Mark::getValue)
                                                          )
                                                  );
    
        System.out.println(enumMap);
    }
}