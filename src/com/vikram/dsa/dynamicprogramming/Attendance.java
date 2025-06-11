package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class Attendance {

  public static void main( String[] args ) {
    Attendance attendance = new Attendance();
    System.out.println( attendance.checkRecord(2));
  }

  public int checkRecord(int n) {
    int mod = 1_000_000_007;
    // dp[i][a][l] will store the number of valid attendance records of length i with a absences (0 or 1) and l consecutive late days (0, 1, or 2)
    long[][][] dp = new long[n + 1][2][3];
    
    // Initialize dp array to -1 indicating that the values are not computed yet
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j < 2; j++) {
            Arrays.fill(dp[i][j], -1L);
        }
    }

    // Start the recursive call to compute the result for n days and at most 1 absence
    return (int) (checkRecord(dp, n, 1, 0) % mod);
}

public long checkRecord(long[][][] dp, int i, int a, int l) {
    // Base case: if there are no more days left, return 1 (valid empty record)
    if (i == 0) {
        return 1;
    }

    // If this state is already computed, return the memoized value
    if (dp[i][a][l] != -1L) {
        return dp[i][a][l];
    }

    dp[i][a][l] = checkRecord(dp, i - 1, a, 0);  // Last day is 'P' (Present), reset consecutive 'L' count

    // Case when the last day is 'A' (Absent), reduce one absence if available
    if (a > 0) {
        dp[i][a][l] += checkRecord(dp, i - 1, a - 1, 0); // Last day is 'A', reset consecutive 'L' count
    }

    // Case when the last day is 'L' (Late), check if we can have one or two consecutive 'L' days
    if (l < 2) { // Only allow 1 or 2 consecutive 'L' days
        dp[i][a][l] += checkRecord(dp, i - 1, a, l + 1); // Last day is 'L', increment consecutive 'L' count
    }

    // Memoize the result and return
    return dp[i][a][l];
}
  
}
