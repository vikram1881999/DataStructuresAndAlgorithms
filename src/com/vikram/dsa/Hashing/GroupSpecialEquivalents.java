package com.vikram.dsa.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupSpecialEquivalents {

  public static void main( String[] args ) {

    String[] arr =  {"abc","acb","bac","bca","cab","cba"};
    GroupSpecialEquivalents equivalents = new GroupSpecialEquivalents();
    System.out.println(equivalents.numSpecialEquivGroups(arr));
    
  }

  public int numSpecialEquivGroups(String[] words) {
        Map<String, Integer> groups = new HashMap<>();
        int c = 0;

        for( String word: words ) {
            int length = word.length();
            char[] evenIndex = new char[(length+1)/2];
            char[] oddIndex = new char[length/2];
            int i = 0;
            int j = 0;
            for( int k = 0; k < length; k++) {
                if( k%2 == 0 ) {
                    evenIndex[i] = word.charAt(k);
                    i++;
                }
                else {
                    oddIndex[j] = word.charAt(k);
                    j++;
                }
            }

            Arrays.sort(evenIndex);
            Arrays.sort(oddIndex);
            String key = new String(evenIndex) + "_" + new String(oddIndex);
            groups.put(key, groups.getOrDefault(key, 0) + 1);
        }

        for( Map.Entry<String, Integer> entry: groups.entrySet()) {
            if( entry.getValue() > 1 ) {
                c++;
            }
        }

        return c;
    }
  
}
