package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestPathWithAlternatingColors {

  public static void main( String[] args ) {
    int[][] redEdge = {{0,1},{1,2},{2,3},{3,4}};
    int[][] blueEdge = {{1,2},{2,3},{3,1}};
    ShortestPathWithAlternatingColors alternatingColors = new ShortestPathWithAlternatingColors();
    System.out.println( Arrays.toString(alternatingColors.shortestAlternatingPaths(5, redEdge, blueEdge)));
  }

  public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer> red[] = new ArrayList[n];
        List<Integer> blue[] = new ArrayList[n];
        int[] distance = new int[n];
        Set<String> visited = new HashSet<>();
        Arrays.fill( distance, -1 );

        for( int[] redEdge: redEdges) {
            int s = redEdge[0];
            int d = redEdge[1];
            if( red[s] == null ){
                red[s] = new ArrayList<>();
            }
            red[s].add(d);
        }

        for( int[] blueEdge: blueEdges) {
            int s = blueEdge[0];
            int d = blueEdge[1];
            if( blue[s] == null ){
                blue[s] = new ArrayList<>();
            }
            blue[s].add(d);
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] start = {0,0, 3};
        queue.add(start);
        visited.add(0+"_"+3);
        while( !queue.isEmpty()) {
            int[] currentPos = queue.remove();
            int s = currentPos[0];
            int d = currentPos[1];
            int c = currentPos[2];
            if( distance[s] == -1 ) {
                distance[s] = d;
            }
            if( c != 2 && red[s] != null ) {
                for( int dest : red[s] ) {
                    String key = dest+"_"+1;
                    if( !visited.contains(key) ) {
                        visited.add(key);
                        int[] destination = { dest, d+1, 2 };
                        queue.add(destination);
                    }
                }
            }
            if( c != 1  &&  blue[s] != null ) {
                for( int dest : blue[s] ) {
                    String key = dest+"_"+2;
                    if( !visited.contains(key) ) {
                        visited.add(key);
                        int[] destination = { dest, d+1, 1 };
                        queue.add(destination);
                    }
                }
            }
        }

        return distance;
    }
}
