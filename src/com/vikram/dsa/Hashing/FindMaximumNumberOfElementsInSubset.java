package com.vikram.dsa.Hashing;

import java.util.HashMap;
import java.util.Map;

public class FindMaximumNumberOfElementsInSubset {

  public static void main( String[] args ) {
    FindMaximumNumberOfElementsInSubset elementsInSubset = new FindMaximumNumberOfElementsInSubset();
    int[] num = {5,4,1,2,2};
    System.out.println( elementsInSubset.maximumLength(num));
  }



   public int maximumLength(int[] nums) {
        int maxL = 0;
        Map<Double, Integer> map = new HashMap<>();
        for( int num: nums ) {
            double key = num;
            map.put( key, map.getOrDefault(key, 0) + 1);
        }

        for( int num: nums ) {
            double currNum = num;
            int c = 1;
            currNum = Math.sqrt(currNum);
            while( map.containsKey(currNum) && map.get(currNum) >= 2 ) {
                c+=2;
                currNum = Math.sqrt(currNum);
            }
            maxL = Math.max(c, maxL);
        }

        if( map.containsKey(1.0) ) {
          int c = map.get(1.0);
          if( c%2 == 0 ) {
            maxL = Math.max(maxL, c-1);
          }
          else {
            maxL = Math.max(maxL, c);
          }
        }

        return maxL;

    }
  
}
