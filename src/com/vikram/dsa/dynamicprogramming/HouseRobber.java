package com.vikram.dsa.dynamicprogramming;

public class HouseRobber {

  public static void main( String[] args ) {
    HouseRobber houseRobber = new HouseRobber();
    int[] nums = {1,2,3,1};
    System.out.println( houseRobber.rob(nums));
  }

  public int rob(int[] nums) {
    int[] dp = new int[nums.length];
    for( int i = 0; i < nums.length; i++ ) {
        int pick = nums[i];
        int notPick = 0;
        if( i - 1 >= 0 ){
            notPick = dp[i-1];
        }
        if( i - 2>= 0 ) {
            pick += dp[i-2];
        }

        dp[i] = Math.max( pick, notPick);
    }

    return dp[nums.length-1];
}
  
}
