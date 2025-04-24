package com.vikram.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class TusharBirthdayParty {

  public static void main( String[] args )  {
    TusharBirthdayParty birthdayParty  = new TusharBirthdayParty();
    System.out.println(birthdayParty.solve( new ArrayList<>(List.of(2,4,6)), new ArrayList<>(List.of(2,1,3)) , new ArrayList<>(List.of(2,5,3))));
  }


  public long solve(List<Integer> A, List<Integer> B, List<Integer> C) {
    int maxCapacity = A.stream().max(Integer::compare).get();
    long[][] dp = new long[B.size()][maxCapacity + 1];
    
    // Initialize DP table
    for (int i = 0; i < B.size(); i++) {
        for (int j = 0; j <= maxCapacity; j++) {
            dp[i][j] = Integer.MAX_VALUE;
        }
    }
    
    // Fill DP table
    knapsack(B, C, B.size() - 1, maxCapacity, dp);
    
    // Sum costs for each friend
    long totalCost = 0;
    for (int capacity : A) {
        totalCost += dp[B.size() - 1][capacity];
    }
    return totalCost;
}

private long knapsack(List<Integer> fill, List<Integer> cost, int i, int j, long[][] dp) {
    if (j <= 0) return 0; // Base case: no capacity left
    if (i < 0) return Integer.MAX_VALUE; // Can’t satisfy capacity
    
    if (dp[i][j] == Integer.MAX_VALUE) {
        long exclude = knapsack(fill, cost, i - 1, j, dp);
        long include = Integer.MAX_VALUE;
        if (j >= fill.get(i)) {
            include = knapsack(fill, cost, i, j - fill.get(i), dp);
            if (include != Integer.MAX_VALUE) {
                include += cost.get(i); // Safe addition
            }
        }
        dp[i][j] = Math.min(exclude, include);
    }
    return dp[i][j];
}
  
}
