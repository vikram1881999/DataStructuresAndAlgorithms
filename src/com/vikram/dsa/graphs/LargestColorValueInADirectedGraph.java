package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LargestColorValueInADirectedGraph {

  public static void main( String[] args ) {
    LargestColorValueInADirectedGraph lADirectedGraph = new LargestColorValueInADirectedGraph();
    String colors = "hhqhuqhqff";
    int[][] arr = {
      {
        0,
        1
      },
      {
        0,
        2
      },
      {
        2,
        3
      },
      {
        3,
        4
      },
      {
        3,
        5
      },
      {
        5,
        6
      },
      {
        2,
        7
      },
      {
        6,
        7
      },
      {
        7,
        8
      },
      {
        3,
        8
      },
      {
        5,
        8
      },
      {
        8,
        9
      },
      {
        3,
        9
      },
      {
        6,
        9
      }
    };
    System.out.println( lADirectedGraph.largestPathValue(colors, arr));
  }

  public int largestPathValue(String colors, int[][] edges) {
        int ans = 0;
        int n = colors.length();
        List<Integer> adjList[] = new ArrayList[n];
        int[] dependency = new int[n];
        Map<Character, Integer> adjMap[] = new HashMap[n];
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0; i < edges.length; i++ ) {
            int u = edges[i][0];
            int v = edges[i][1];
            if( adjList[u] == null ) {
                adjList[u] = new ArrayList<>();
            }
            adjList[u].add(v);
            dependency[v]++;
        }

        for( int i = 0; i < n; i++ ) {
            if( dependency[i] == 0 ) {
                queue.add( i );
            }
            if( adjMap[i] == null ) {
                adjMap[i] = new HashMap<>();
            }
        }

        while( !queue.isEmpty() ) {
            int item = queue.remove();
            char currentColor = colors.charAt(item);
            Map<Character, Integer> charMap = adjMap[item];
            charMap.put( currentColor, charMap.getOrDefault(currentColor, 0) + 1 );
            for( Map.Entry<Character, Integer> entry: charMap.entrySet() ) {
                ans = Math.max( entry.getValue(), ans );
            }
            
            if( adjList[item] == null) continue;
            for( int neighbour : adjList[item] ) {
                for( Map.Entry<Character, Integer> entry: charMap.entrySet() ) {
                  adjMap[neighbour].put( entry.getKey(), Math.max(adjMap[neighbour].getOrDefault(entry.getKey(), 0) , entry.getValue()) );
                }
                dependency[neighbour]--;
                if( dependency[neighbour] == 0 ) {
                    queue.add(neighbour);
                }
            }
        }

        for( int i = 0; i < n; i++ ) {
          if( dependency[i] != 0 ) {
            return -1;
          }
        }

        return ans;
    }
  
}
