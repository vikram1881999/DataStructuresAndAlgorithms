package com.vikram.dsa.dynamicprogramming;

public class BurstBallons {

  public static void main( String[] args  ) {
    BurstBallons ballons = new BurstBallons();
    int[] nums  = {3,1,5,8};
    System.out.println(ballons.maxCoins(nums));
  }
  

  public int maxCoins(int[] nums) {
        return maxCoins( nums, 0, nums.length-1);
    }

    public int maxCoins( int[] nums, int i, int j ) {
        if ( i > j) {
            return 0;
        }
        if( i == j ) {
            return nums[i];
        }
        int cost = Integer.MIN_VALUE;
        for( int k = i; k <= j; k++ ) {
            int leftCost = maxCoins( nums, i, k-1 );
            int rightCost = maxCoins( nums, k+1, j );
            int currCost = nums[i];
            if( k-1 >= i) {
                currCost = currCost*nums[k-1];
            }
            if( k+1 <= j ) {
                currCost = currCost*nums[k+1];
            }

            cost = Math.max( cost, currCost + leftCost + rightCost );
        }

        return cost;
    }
}


