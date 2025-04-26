package com.vikram.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

  public static void main( String[] args) {
    NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
    int[][] islands = {{1,1,0}, {1,1,0}, {0,0,1}};
    numberOfProvinces.findCircleNum(islands);
  }


  public int findCircleNum(int[][] isConnected) {
        if(  isConnected == null || isConnected.length <= 0 ) {
            return 0;
        }
        int c = 0;
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        for( int i = 0; i < n; i++ ) {
            if( !visited[i]) {
                c++;
                Queue<Integer> queue = new LinkedList();
                queue.add(i);
                visited[i] = true;
                while( !queue.isEmpty() ) {
                    int city1 = queue.remove();
                    for( int j = 0; j < isConnected[city1].length; j++ ) {
                        if( isConnected[city1][j] == 1 ) {
                            if( !visited[j] ){
                                visited[j] = true;
                                queue.add(j);
                            }
                        }
                    }
                }
            }
        }

        return c;
    }
  
}
