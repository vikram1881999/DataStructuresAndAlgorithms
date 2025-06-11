package com.vikram.dsa.arrays;

public class PongalBunk {
  public static void main( String[] args ) {
    int[] nums = new int[5];
    int[][] q = {{0,2}, {1,3}, {0, 4}};
    PongalBunk bunk = new PongalBunk();
    System.out.println(bunk.solve(nums, q));
  }

  public int[] solve( int[] nums, int[][] q ) {
    int[] arr = new int[nums.length];
    for( int i = 0; i < q.length; i++ ) {
        int l = q[i][0];
        int r = q[i][1];
        if( r < nums.length-1) {
            arr[r+1] = -(r-l+1);
            nums[r+1] = -1;
        }
        nums[l] += 1;
    }
    
    for( int i = 1; i < nums.length; i++ ) {
        nums[i] = nums[i-1] + nums[i];
    }
    
    for( int i = 1; i < nums.length; i++ ) {
        nums[i] = nums[i-1] + nums[i] + arr[i];
    }
    
    return nums;
}
}
