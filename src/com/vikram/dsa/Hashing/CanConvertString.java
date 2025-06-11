package com.vikram.dsa.Hashing;

import java.util.HashMap;
import java.util.Map;

public class CanConvertString {

  public static void main( String[] args ) {
    CanConvertString canConvertString = new CanConvertString();
    System.out.println(canConvertString.canConvertString("input", "ouput", 9));
  }

  public boolean canConvertString(String s, String t, int k) {
        if( s.length() != t.length() ) {
            return false;
        }
        Map<Integer, Integer> steps = new HashMap<>();
        int i = 0;
        int j = 0;
        while( i < s.length() ) {
            if( s.charAt(i) != t.charAt(i) ) {
                int target = t.charAt(j) - 'a';
                int ch = s.charAt(i) - 'a';
                int step = ( target - ch + 26 )%26;
                int currStep = steps.getOrDefault(step, 0);
                int totalSteps = currStep*26 + step;
                if( totalSteps > k ) {
                    return false;
                }
                steps.put(step, currStep+1);
            }
            i++;
            j++;
        }

        return true;
    }
  
}
