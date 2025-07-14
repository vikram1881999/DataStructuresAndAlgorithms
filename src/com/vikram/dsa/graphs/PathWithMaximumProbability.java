package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {

  public static void main( String[] args ) {

  }

  public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]> adjList[] = new ArrayList[n];
        double[] best = new double[n];
        for( int i = 0; i < edges.length; i++ ) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            if( adjList[u] == null ) {
                adjList[u] = new ArrayList<>();
            }
            if( adjList[v] == null ) {
                adjList[v] = new ArrayList<>();
            }
            adjList[u].add( new double[]{v, w});
            adjList[v].add( new double[]{u, w});
        }

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>( new Comparator<double[]>() {
          @Override
          public int compare(double[] o1, double[] o2) {
            return (int)(Math.floor(o2[1] - o1[1]));
          }
        });


        maxHeap.add( new double[]{ start_node, 1.0} );
        best[start_node] = 1.0;
        while( !maxHeap.isEmpty() ) {
            double[] sourceNode = maxHeap.remove();
            double source = sourceNode[0];
            double prob = sourceNode[1];
            if( prob < best[(int)source]) {
                continue;
            }
            for( double[] neigbourNode: adjList[(int)source] ) {
                double neighbour = neigbourNode[0];
                double neighBourProb = neigbourNode[1] * prob;
                if( neighBourProb > best[(int)neighbour] ) {
                    best[(int)neighbour] = neighBourProb;
                    maxHeap.add( new double[]{ neighbour, neighBourProb});
                }
            }
        }

        return best[end_node];
    }
  
}
