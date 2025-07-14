package com.vikram.dsa.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DetectCycle2DGrid {

  public static void main( String[] args ) {
    char[][] grid = {{'f','c','b','d','f','a','e','e','a','c','e'},{'d','f','f','c','c','a','b','b','a','c','f'},{'e','d','d','a','d','d','d','c','f','b','e'},{'e','a','d','d','a','e','e','a','c','f','b'},{'d','c','f','a','b','c','c','d','e','c','b'},{'d','a','e','d','a','a','a','e','f','a','b'},{'d','f','e','a','f','b','c','b','d','a','e'},{'c','f','d','c','d','a','e','e','a','a','e'},{'f','b','c','e','e','b','e','b','a','a','a'},{'d','d','b','c','b','f','a','c','b','c','d'},{'e','e','c','c','e','b','e','f','b','c','d'}};
    DetectCycle2DGrid cycle2dGrid = new DetectCycle2DGrid();
    System.out.println( cycle2dGrid.containsCycle(grid));
  }
  

  public boolean containsCycle(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    boolean[][] visited = new boolean[n][m];

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if (!visited[i][j]) {
                if (bfs(grid, visited, i, j, moves)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private boolean bfs(char[][] grid, boolean[][] visited, int r, int c, int[][] moves) {
    int n = grid.length, m = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{r, c, -1, -1});
    visited[r][c] = true;

    while(!queue.isEmpty()) {
        int[] curr = queue.poll();
        int x = curr[0], y = curr[1], px = curr[2], py = curr[3];

        for(int[] move : moves) {
            int nx = x + move[0], ny = y + move[1];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == grid[x][y]) {
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, x, y});
                } else if(nx != px || ny != py) {
                    // Visited node that isn't the immediate parent
                    return true;
                }
            }
        }
    }
    return false;
}
}
