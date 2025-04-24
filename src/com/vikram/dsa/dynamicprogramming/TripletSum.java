package com.vikram.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {

  public static void main(String[] args ) {
    TripletSum tripletSum = new TripletSum();
    
    System.out.println(tripletSum.solve(new ArrayList<>(List.of(-6,5,-3,4,-2)), 2, 1, -1));
  }


  public int solve(ArrayList<Integer> A, int B, int C, int D) {
       List<Integer> triplet = new ArrayList<>();
       triplet.add(B);
       triplet.add(C);
       triplet.add(D);
       int[][] dp = new int[A.size()][triplet.size()];
       for( int i = 0; i < A.size(); i++ ) {
           Arrays.fill(dp[i], -1);
       }
        return getMaxSumValue(dp, A, triplet, A.size()-1, triplet.size()-1);
    }

    public int getMaxSumValue( int[][] dp, ArrayList<Integer> A, List<Integer> triplet, int i, int j) {
          if( i < 0 ) {
            if( j > 0 ) {
                return Integer.MIN_VALUE;
            }
            return 0;
        }
        if( j < 0 ) {
            return 0;
        }


        if( dp[i][j] ==  -1 ) {
            dp[i][j] = Math.max( A.get(i) * triplet.get(j) + getMaxSumValue(dp, A, triplet, i, j-1 ), getMaxSumValue(dp, A, triplet, i-1, j ));
        }

        return dp[i][j];
    }
  
}
