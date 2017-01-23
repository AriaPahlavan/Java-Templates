package StringTools;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aria Pahlavan on 1/22/17.
 */
public class CharFreuency {
    void freqFounder() {
        String str = "I like visiting my friend Will, who lives in Orlando, Florida.".toLowerCase().replaceAll("[^a-z' ]", "");
        Map<Character, Integer> letterFreq = new HashMap<>();                       // (I -> 8)
        Map<Character, Map.Entry<String, Integer>> maxWord = new HashMap<>();    // (I -> ("visiting" -> 3) )
        
        for ( String word : str.split(" ") ) {
            int count[] = new int[26];
            
            for ( char letter : word.toCharArray() )
                if ( letter > 'a' && letter < 'z' )
                    count[letter - 'a']++;
            
            for ( int i = 0; i < count.length; i++ ) {
                int iVal = count[i];
                if ( iVal != 0 ) {
                    letterFreq.compute(toChar(i), (c, val) -> val == null ? 1 : val + 1);
                    updateEntry(maxWord, word, i, iVal);
                }
            }
        }
        
        int maxNumWords = 0;
        char maxChar = ' ';
        for ( int i = 0; i < 26; i++ ) {
            int curMax = letterFreq.getOrDefault(toChar(i), 0);
            if ( maxNumWords < curMax ) {
                maxChar = toChar(i);
                maxNumWords = curMax;
            }
        }
        
        System.out.println("\'" + String.valueOf(maxChar).toUpperCase()
                                   + "\' was repeated in " + maxNumWords
                                   + " words, and appeared in \"" + maxWord.get(maxChar).getKey()
                                   + "\" most frequently");
        
    }
    
    /*-----------------helper functions-----------------------*/
    private static void updateEntry(Map<Character, Map.Entry<String, Integer>> maxWord, String word, int i, int iVal) {
        Map.Entry<String, Integer> entry = maxWord.getOrDefault(toChar(i), new AbstractMap.SimpleEntry<>(word, iVal));
        if ( entry.getValue() <= iVal ) {
            entry = new AbstractMap.SimpleEntry<>(word, iVal);
            maxWord.put(toChar(i), entry);
        }
    }
    
    private static char toChar(int i) {
        return (char) (i + 'a');
    }
    
}

