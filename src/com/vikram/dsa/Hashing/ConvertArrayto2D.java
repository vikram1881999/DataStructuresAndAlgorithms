package com.vikram.dsa.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertArrayto2D {

  public static void main( String[] args ) {
    ConvertArrayto2D arrayto2d = new ConvertArrayto2D();
    int[] ans = {1,3,4,1,2,3,1};
    arrayto2d.findMatrix(ans);
  }

  public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int c = 0;
        for( int num: nums ) {
            int count = countMap.getOrDefault(num, 0) + 1;
            c = Math.max(c, count);
            countMap.put(num, count);
        }

        List<Integer> adjList[] = new ArrayList[c+1];

        for( Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            int integer = entry.getKey();
            for( int i = 1; i <= entry.getValue(); i++ ) {
              if( adjList[i] == null  ){
                adjList[i] = new ArrayList<>();
              }
              adjList[i].add(integer);
            }
        }

        for( int i = 1; i <= c; i++ ){
            ans.add( adjList[i]); 
        }

        return ans;

    }
  
}
