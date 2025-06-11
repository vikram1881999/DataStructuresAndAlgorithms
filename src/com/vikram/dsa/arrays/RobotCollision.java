package com.vikram.dsa.arrays;

import java.util.Arrays;

public class RobotCollision {

  public static void main( String[] args ) {
    int[] arr = {-10,-13,10,14,11};
    String s = "LRLLR";
    RobotCollision collision = new RobotCollision();
    System.out.println(collision.sumDistance(arr, s, 2));
  }

   public int sumDistance(int[] nums, String s, int d) {
    final int modulo = (int) 1e9 + 7;
    final int n = nums.length;
    long[] position = new long[n];
    for (int i = 0; i < n; i++) {
      position[i] = (s.charAt(i) == 'L' ? -1L : 1L) * d + nums[i];
    }

    Arrays.sort(position);
    long distance = 0;
    long prefix = 0;
    for (int i = 0; i < n; i++) {
      distance = (distance + (i * position[i] - prefix)) % modulo;
      prefix += position[i];
    }

    return (int) distance;
  }
  
}
