package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlowerPlanting {

  public static void main( String[] args ){
    int[][] path = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
    FlowerPlanting flowerPlanting = new FlowerPlanting();
    System.out.println( Arrays.toString(flowerPlanting.gardenNoAdj(4, path)));
  }


  public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer> adjList[] = new ArrayList[n+1];
        for( int i = 0; i < paths.length; i++ ) {
            int u = paths[i][0];
            int v = paths[i][1];
            if( adjList[u] == null ) {
                adjList[u] = new ArrayList<>();
            }
            if( adjList[v] == null ) {
                adjList[v] = new ArrayList<>();
            }
            adjList[u].add(v);
            adjList[v].add(u);
        }
        int[] ans = new int[n];
        for( int i = 1; i <= n; i++ ) {
          boolean[] used = new boolean[5];
          if( adjList[i] != null ) {
            for( int neighbour: adjList[i] ) {
              used[ans[neighbour-1]] = true;
            }
          }
          for (int c = 1; c <= 4; c++) {
            if (!used[c]) {
                ans[i-1] = c;
                break;
            }
          }
        }

        return ans;
       
    }
  
}
