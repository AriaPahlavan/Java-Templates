package table;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * Created by Aria Pahlavan on 1/17/17.
 */
public class TablePrint {
    
    private final static int MAX_CHAR_LIMIT = 150;
    private final static int DEFAULT_NUM_COL = 5;
    private final static int MAX_COL_LIMIT = 5;
    private static Integer curCharLimit = MAX_CHAR_LIMIT;
    private static Integer curColLimit = DEFAULT_NUM_COL-1;
    private static Map<Integer, StringBuffer> rowText = new ConcurrentHashMap<>();
    private static Integer curCol = 0;
    
    public static void closeTable() {
        printEmptyRow();     // Opening Row
        printRows();         // User Data
        printEmptyRow();     // Closing Row
    }
    
    private static void printRows() {
        System.out.print("| ");
    
        for ( Integer cul = 0; cul <= curCol; cul++ )
            printCell(cul);
    
        System.out.println();
    }
    
    private static void printCell(int cul) {
        int numSpaceNeeded = (MAX_CHAR_LIMIT/(curCol+1) - rowText.get(cul).length())/2;
    
        for ( int i = 0; i < numSpaceNeeded ; i++ )
            System.out.print(" ");
        
        System.out.print(rowText.get(cul));
    
        for ( int i = 0; i < numSpaceNeeded; i++ )
            System.out.print(" ");
        
        if ( numSpaceNeeded < 0 ){
            for ( int i = 0; i < numSpaceNeeded*-2 +5; i++ )
                System.out.print("\b");
    
            System.out.print("... ");
        }
    
        System.out.print("| ");
    }
    
    private static void printEmptyRow() {
        System.out.print("+");
        
        Stream.of(new Integer[Optional.ofNullable(curCharLimit)
                                      .map(i -> i < 0 ? 0 : i)
                                      .orElse(2)])
                .parallel()
                .forEach(integer -> System.out.print('-'));
        
        System.out.println(curCol%2!=0 ? "-+" : "+");
    }
    
    public static <T> void print(T o) {
        String val = o + " ";
        StringBuffer newSB = new StringBuffer().append(val);
    
        rowText.compute(curCol, (k, s) -> s==null ? newSB : s.append(val));   //TODO: check col char limit
    }
    
    public static boolean moveNextCol(){
        boolean result = curCol != curColLimit;
        if ( result ) curCol++;
        
        return result;
    }
    public static boolean movePreviousCol(){
        boolean result = curCol != 0;
        if ( result ) curCol--;
        
        return result;
    }
}
