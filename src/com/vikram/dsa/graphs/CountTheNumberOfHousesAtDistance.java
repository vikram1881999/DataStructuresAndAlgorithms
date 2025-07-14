package com.vikram.dsa.graphs;

import java.util.Arrays;

public class CountTheNumberOfHousesAtDistance {

  public static void main(String[] args) {
    CountTheNumberOfHousesAtDistance countTheNumberOfHousesAtDistance = new CountTheNumberOfHousesAtDistance();
    System.out.println(Arrays.toString(countTheNumberOfHousesAtDistance.countOfPairs(5, 2, 4)));
  }

  public int[] countOfPairs(int n, int x, int y) {
    int[] count = new int[n];
    int[][] adjMatrix = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        adjMatrix[i][j] = Integer.MAX_VALUE;
        if (i == j) {
          adjMatrix[i][j] = 0;
        }
      }
    }
    if( x != y ) {
      adjMatrix[x][y] = 1;
      adjMatrix[y][x] = 1;
    }

    for (int i = 1; i <= n; i++) {
      if (i + 1 <= n) {
        adjMatrix[i][i + 1] = 1;
        adjMatrix[i + 1][i] = 1;
      }
      if (i - 1 >= 1) {
        adjMatrix[i][i - 1] = 1;
        adjMatrix[i - 1][i] = 1;
      }
    }

    for (int i = 1; i <= n; i++) {

      for (int j = 1; j <= n; j++) {
        if (j == i) {
          continue;
        }
        for (int k = 1; k <= n; k++) {
          if (k == j || k == i || adjMatrix[j][i] == Integer.MAX_VALUE || adjMatrix[i][k] == Integer.MAX_VALUE) {
            continue;
          }
          adjMatrix[j][k] = Math.min(adjMatrix[j][k], adjMatrix[j][i] + adjMatrix[i][k]);
          adjMatrix[k][j] = Math.min(adjMatrix[j][k], adjMatrix[j][i] + adjMatrix[i][k]);
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (adjMatrix[i][j] != 0) {
          count[adjMatrix[i][j] - 1]++;
        }
      }
    }

    return count;

  }

}
