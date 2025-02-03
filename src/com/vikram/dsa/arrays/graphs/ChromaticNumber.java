package com.vikram.dsa.arrays.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Min color required to color every node of graph such that no 2 adjacent nodes have same colours called chromatic number
 */
public class ChromaticNumber {

  public static void main( String[] args ) {
    int[][] arr = {{1, 5}, { 1, 4}, { 1,3},{1,2}, {2,3}, {2,4}, {2,5}, {3,4}, {3,5}, {4,5}};
    int[][] arr1 = {{1,2}, {2,3}, {3, 6}, {6,7}, {7,8}, {8, 9}, {9,1}, {7,4}, {4,5}, {5,2}};
    ChromaticNumber chromaticNumber = new ChromaticNumber();
    System.out.println( Arrays.toString(chromaticNumber.chromaticNumbers(arr, 5)));
    System.out.println( Arrays.toString(chromaticNumber.chromaticNumbers(arr1, 9)));
  }

  public int[] chromaticNumbers( int[][] arr, int n ) {
    List<Integer>[] adjList = new ArrayList[n+1];
    Queue<Integer> queue = new LinkedList<>();
    int[] colors = new int[n+1];

    for( int i = 0; i < arr.length; i++ ) {
      int s = arr[i][0];
      int d = arr[i][1];
      if( adjList[s] == null ) {
        adjList[s] = new ArrayList<>();
      }
      if( adjList[d] == null ) {
        adjList[d] = new ArrayList<>();
      }
      adjList[s].add(d);
      adjList[d].add(s);
    }

    queue.add(1);
    colors[1] = 1;
    while( !queue.isEmpty() ) {
      int s = queue.remove();
      for( int i = 0; i < adjList[s].size(); i++ ) {
        int node = adjList[s].get(i);
        if( colors[node] == 0 ) {
          colors[node] = n - colors[s];
          queue.add(node);
        }
        else if( colors[node] == colors[s] ) {
          colors[node] = colors[s] + 1; 
        }
      }
    }
    return colors;
  }
  
}
