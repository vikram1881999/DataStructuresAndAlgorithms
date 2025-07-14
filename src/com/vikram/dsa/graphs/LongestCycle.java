package com.vikram.dsa.graphs;

import java.util.HashMap;
import java.util.Map;

public class LongestCycle {

  public static void main( String[] args) {
    int[] arr = {3,3,4,2,3};
    LongestCycle longestCycle = new LongestCycle();
    longestCycle.longestCycle(arr);
  }

  int longestCycle = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        for( int i = 0; i < n; i++ ) {
            if( !visited[i] ) {
                Map<Integer, Integer> distanceMap = new HashMap<>();
                distanceMap.put( i, 1 );
                dfs( edges, visited, i, distanceMap);
            }
        }

        return longestCycle;
    }

    private void dfs( int[] edges, boolean[] visited, int ele, Map<Integer, Integer> distanceMap ) {
        visited[ele] = true;
        int to = edges[ele];
        int currDistance = distanceMap.get(ele);
        if( to != -1 && !visited[to] ) {
            distanceMap.put(to, currDistance+1);
            dfs( edges, visited, to, distanceMap );
        }
        else if(  to != -1 && visited[to] && distanceMap.get(to) != null) {
            longestCycle = Math.max(  currDistance - distanceMap.get(to) + 1, longestCycle);
        }
    }
  
}
