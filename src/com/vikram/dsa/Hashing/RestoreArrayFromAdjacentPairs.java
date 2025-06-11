package com.vikram.dsa.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RestoreArrayFromAdjacentPairs {

  public static void main( String[] args ){
    RestoreArrayFromAdjacentPairs adjacentPairs = new RestoreArrayFromAdjacentPairs();
    int[][] arr = {{4,-2},{1,4},{-3,1}};
    System.out.println( Arrays.toString(adjacentPairs.restoreArray(arr)));
  }


  public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        int[] ans = new int[n+1];
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for( int[] pairs: adjacentPairs) {
            int u = pairs[0];
            int v = pairs[1];
            List<Integer> list1 = adjMap.getOrDefault(u, new ArrayList<>());
            list1.add(v);
            List<Integer> list2 = adjMap.getOrDefault(v, new ArrayList<>());
            list2.add(u);
            adjMap.put(u, list1);
            adjMap.put(v, list2);
        }
        int start = 0;
        for( Map.Entry<Integer, List<Integer>> entry: adjMap.entrySet()) {
            if( entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        int i = 0;
        queue.add(start);
        visited.add(start);
        while( !queue.isEmpty()) {
            int num = queue.remove();
            ans[i] = num;
            i++;
            List<Integer> list = adjMap.get(num);
            for( int j = 0; j < list.size(); j++ ) {
                int ele = list.get(j);
                if( !visited.contains(ele) ) {
                    queue.add(ele);
                    visited.add(ele);
                }
            }
        }

        return ans;
    }
  
}
