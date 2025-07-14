package com.vikram.dsa.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramsInString {

  public static void main( String[] args ){
    FindAnagramsInString anagramsInString = new FindAnagramsInString();
    System.out.println( anagramsInString.findAnagrams("cbaebabacd", "abc"));
  }

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
    int n = s.length();
    int k = p.length();
    if( k > n ) {
        return ans;
    }
    Map<Character, Integer> anagramCheckMap = new HashMap<>();
    Map<Character, Integer> anagram = new HashMap<>();
    for( char ch: p.toCharArray() ) {
        anagramCheckMap.put( ch, anagramCheckMap.getOrDefault(ch, 0) + 1);
    }

    for( int i = 0; i < k; i++ ) {
        char ch = s.charAt(i);
        anagram.put( ch, anagram.getOrDefault(ch, 0) + 1);
    }
    if( validate( anagramCheckMap, anagram) ) {
        ans.add(0);
    }

    for( int i = 1; i < n - k + 1; i++ ) {
        char ch = s.charAt(i-1);
        char ch1 = s.charAt(i + k - 1);
        anagram.put( ch, anagram.getOrDefault(ch, 0) - 1);
        if( anagram.get(ch) <= 0 ) {
            anagram.remove(ch);
        }
        anagram.put( ch1, anagram.getOrDefault(ch1, 0) + 1);
        if( validate( anagramCheckMap, anagram) ) {
            ans.add(i);
        }
    }


    return ans;
}

private boolean validate(  Map<Character, Integer> a,  Map<Character, Integer> b ) {
  return a.equals(b);
}
  
}
