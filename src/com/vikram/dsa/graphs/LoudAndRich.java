package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LoudAndRich {

  public static void main( String[] arg ) {
    LoudAndRich loudAndRich = new LoudAndRich();
    int[][] ans = {
      {
        1,
        0
      },
      {
        2,
        1
      },
      {
        3,
        1
      },
      {
        3,
        7
      },
      {
        4,
        3
      },
      {
        5,
        3
      },
      {
        6,
        3
      }
    };
    int[] quiet = {3,2,5,4,6,1,7,0};
    System.out.println(Arrays.toString(loudAndRich.loudAndRich(ans, quiet)));
  }


   public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer> adjList[] = new ArrayList[n];
        int[] dependency = new int[n];
        int[] ans = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0; i < richer.length; i++ ) {
            int u = richer[i][0];
            int v = richer[i][1];
            if( adjList[u] ==null ) {
                adjList[u] = new ArrayList<>();
            }
            if( adjList[v] == null ) {
                adjList[v] = new ArrayList<>();
            }
            adjList[u].add(v);
            dependency[v]++;
        }

        for( int i = 0; i < n; i++ ) {
            ans[i] = i;
            if( dependency[i] == 0 ) {
                queue.add( i );
            }
            if( adjList[i] == null ) {
                adjList[i] = new ArrayList<>();
            }
        }

        while( !queue.isEmpty() ) {
            int ele = queue.remove();
            for( int neighbour: adjList[ele] ) {
                if( quiet[ele] <=  quiet[neighbour] ) {
                    quiet[neighbour] = quiet[ele];
                    ans[neighbour] = ans[ele];
                }
                dependency[neighbour]--;
                if( dependency[neighbour] == 0 ) {
                    queue.add(neighbour);
                }
            }
        }

        return ans;
    }
  
}
