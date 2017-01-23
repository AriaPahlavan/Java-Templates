package table;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static jdk.nashorn.internal.objects.Global.print;
import static table.TablePrint.closeTable;
import static table.TablePrint.moveNextCol;

/**
 * Created by Aria Pahlavan on 1/19/17.
 */
class TablePrintTest {
    @BeforeEach
    void setUp() {
        
    }
    
    @Test
    void testTable(){
        print(Arrays.asList(1, 2584 , 3545, 445, 5));
        moveNextCol();
        table.TablePrint.print(12345);
        moveNextCol();
        table.TablePrint.print(123546445);
        moveNextCol();
        print("hello");
        closeTable();
        table.TablePrint.print(Arrays.asList(1,2,3,4,5));
        table.TablePrint.print('A');
        table.TablePrint.print(12345);
    }
    
}