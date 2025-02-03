package com.vikram.dsa.arrays.graphs;

/**
 * Given N nodes and E edges detect cycle in undirected graph
 */
public class CycleDetectionUndirected {

  public static void main( String[] args ) {
    CycleDetectionUndirected components = new CycleDetectionUndirected();
    int[] u = {1, 1, 1, 3, 3, 4, 5, 5, 9, 7, 10, 10, 11, 11, 12, 15};
    int[] v = {3, 6, 2, 4, 4, 6, 9, 7, 8, 8, 11, 14, 14, 12, 14, 13};
    System.out.println(components.detectCycle(u, v, 15));
  }

  public boolean detectCycle( int[] u, int[] v, int nodes ) {
    UnidirectedConnectedComponents components = new UnidirectedConnectedComponents();
    int component = components.countConnectedComponents(u, v, nodes);
    int edges = u.length;
    return edges == nodes-component;
  }
  
}
