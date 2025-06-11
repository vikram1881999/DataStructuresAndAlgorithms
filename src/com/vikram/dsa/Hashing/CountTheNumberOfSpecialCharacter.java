package com.vikram.dsa.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountTheNumberOfSpecialCharacter {

  public static void main( String[] args ) {
    CountTheNumberOfSpecialCharacter countTheNumberOfSpecialCharacter = new CountTheNumberOfSpecialCharacter();
    System.out.println(countTheNumberOfSpecialCharacter.numberOfSpecialChars("cCceDC"));
  }


  public int numberOfSpecialChars(String word) {
    Map<Character, Integer> indexMap = new HashMap<>();
    Set<Character> set = new HashSet<>();
    int c = 0;

    for( int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        set.add(Character.toLowerCase(ch));
        if( Character.isUpperCase(ch) ) {
            indexMap.put( ch, Math.min( indexMap.getOrDefault(ch, Integer.MAX_VALUE), i));
        }
        else {
            indexMap.put( ch, i);
        }

    }

    for( char ch: set ){
        char lower = Character.toLowerCase(ch);
        char upper = Character.toUpperCase(ch);
        if(indexMap.get(lower) != null  &&  indexMap.get(upper) != null ) {
            int smallIndex = indexMap.get(lower);
            int upperIndex = indexMap.get(upper);
            if( upperIndex > smallIndex ) {
                c++;
            }
        }
    }
    

    return c;

}
  
}
