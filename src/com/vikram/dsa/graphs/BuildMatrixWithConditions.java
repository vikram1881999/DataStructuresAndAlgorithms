package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BuildMatrixWithConditions {

  public static void main( String[] args ) {
    int k = 9;
    int[][] row = {
      {
        7,
        1
      },
      {
        1,
        4
      },
      {
        5,
        8
      },
      {
        3,
        6
      },
      {
        7,
        1
      },
      {
        3,
        7
      },
      {
        6,
        9
      },
      {
        6,
        8
      },
      {
        7,
        9
      }
    };
    int[][] col = {{5,2},{5,3},{5,7},{4,2}};
    BuildMatrixWithConditions buildMatrixWithConditions = new BuildMatrixWithConditions();
    System.out.println( Arrays.deepToString(buildMatrixWithConditions.buildMatrix(k, row, col)));
  }

  public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
    int[][] matrix = new int[k][k];
    List<Integer> rowAdjList[] = new ArrayList[k+1];
    List<Integer> colAdjList[] = new ArrayList[k+1];
    int[] rowDependency = new int[k+1];
    int[] colDependency = new int[k+1];
    for( int i = 0; i < colConditions.length; i++ ) {
        int left = colConditions[i][0];
        int right = colConditions[i][1];
        if( colAdjList[left] == null ) {
            colAdjList[left] = new ArrayList<>();
        }
        colAdjList[left].add(right);
        colDependency[right]++;
    }

    for( int i = 0; i < rowConditions.length; i++ ){
        int above = rowConditions[i][0];
        int below = rowConditions[i][1];
        if( rowAdjList[above] == null ) {
            rowAdjList[above] = new ArrayList<>();
        }
        rowAdjList[above].add(below);
        rowDependency[below]++;
    }

    Map<Integer, Integer> rowCoordinates = getCoordinates( rowAdjList, rowDependency );
    if( rowCoordinates.size() != k ) {
        return new int[][]{};
    }
    Map<Integer, Integer> colCoordinates = getCoordinates( colAdjList, colDependency );
    if( colCoordinates.size() != k ) {
        return new int[][]{};
    }
    for( Map.Entry<Integer, Integer> entry: rowCoordinates.entrySet() ) {
        int key = entry.getKey();
        int row = entry.getValue();
        int col = colCoordinates.get(key);
        matrix[row][col] = key;
    }

    return matrix;
}

private Map<Integer, Integer> getCoordinates( List<Integer> adjList[], int[] dependency ) {
    Map<Integer, Integer> coords = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    for( int i = 1; i < dependency.length; i++ ){
        if( dependency[i] == 0 ) {
            queue.add(i);
        }
    }
    int coord = 0;
    while( !queue.isEmpty() ) {
        int ele = queue.remove();
        coords.put( ele, coord );
        coord++;
        if(  adjList[ele] == null ) {
            continue;
        }
        for( int neighbour: adjList[ele] ) {
            dependency[neighbour]--;
            if( dependency[neighbour] == 0 ) {
                queue.add( neighbour );
            }
        }
    }

    return coords;
}
}
