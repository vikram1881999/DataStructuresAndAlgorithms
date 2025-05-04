package com.vikram.dsa.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class StreamNumbers {

  public static void main( String[] args  ){
    StreamNumbers numbers = new StreamNumbers();
    int[] nums = {1, 2, 1,2,2};
    System.out.println(Arrays.toString(numbers.solve(nums)));
  }

  public int[] solve(int[] A) {
       Map<Integer, TreeSet<Integer>> map = new HashMap<>();
       for( int i = 0; i < A.length; i++ ) {
           if( !map.containsKey(A[i]) || map.get(A[i]).isEmpty())  {
               TreeSet<Integer> indexSet = new TreeSet<>();
               indexSet.add(i);
               map.put(A[i], indexSet);
           }
           else {
               TreeSet<Integer> indexSet = map.get(A[i]);
               int index = indexSet.first();
               indexSet.remove(index);
               map.put(A[i], indexSet);
               A[index] += 1;
               if( map.containsKey(A[index]) ) {
                   TreeSet<Integer> set = map.get(A[index]);
                   set.add(index);
                   map.put(A[index], set);
               }
               else {
                   TreeSet<Integer> set = new TreeSet<>();
                   set.add(index);
                   map.put(A[index], set);
               }
           }
           
       }
        
        
        return A;
    }
  
}
