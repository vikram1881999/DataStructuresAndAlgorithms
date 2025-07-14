package com.vikram.dsa.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EscapeSpreadingFire {

  public static void main( String[] args ) {
    EscapeSpreadingFire escapeSpreadingFire = new EscapeSpreadingFire();
    int[][] arr =  {{0,2,0,0,0,0,0},{0,0,0,2,2,1,0},{0,2,0,0,1,2,0},{0,0,2,2,2,0,2},{0,0,0,0,0,0,0}};
    System.out.println(escapeSpreadingFire.maximumMinutes(arr));
  }


public int maximumMinutes(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int ans = -1;
    int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    Queue<int[]> fireSpread = new LinkedList<>();
    int[][] fireTime = new int[n][m];
    for (int i = 0; i < n; i++) {
        Arrays.fill(fireTime[i], Integer.MAX_VALUE);
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1) {
                fireSpread.add(new int[]{i, j});
                fireTime[i][j] = 0;
            }
        }
    }

    while (!fireSpread.isEmpty()) {
        int[] coords = fireSpread.poll();
        int r = coords[0], c = coords[1];
        for (int[] move : moves) {
            int x = r + move[0], y = c + move[1];
            if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0 && fireTime[x][y] == Integer.MAX_VALUE) {
                fireTime[x][y] = fireTime[r][c] + 1;
                fireSpread.add(new int[]{x, y});
            }
        }
    }

    int l = 0, r = 1000000000;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (checkWaitingTime(mid, fireTime, grid, moves)) {
            ans = mid;
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return ans;
}

private boolean checkWaitingTime(int startTime, int[][] fireTime, int[][] grid, int[][] moves) {
    int n = grid.length, m = grid[0].length;
    if (fireTime[0][0] <= startTime) return false;

    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][m];
    queue.add(new int[]{0, 0, startTime});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
        int[] coords = queue.poll();
        int r = coords[0], c = coords[1], time = coords[2];

        if (r == n - 1 && c == m - 1) {
            // special case for exit cell
            if (fireTime[r][c] >= time || fireTime[r][c] == Integer.MAX_VALUE)
                return true;
        }

        for (int[] move : moves) {
            int x = r + move[0], y = c + move[1];
            int nextTime = time + 1;

            if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0 && !visited[x][y]) {
                if (fireTime[x][y] > nextTime || (x == n - 1 && y == m - 1 && fireTime[x][y] >= nextTime)) {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y, nextTime});
                }
            }
        }
    }

    return false;
}

  
}
