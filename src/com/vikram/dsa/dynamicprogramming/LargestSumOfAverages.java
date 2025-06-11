package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class LargestSumOfAverages {

  public static void main(String[] args) {
    int[] ans = { 4, 1, 7, 5, 6, 2, 3 };
    LargestSumOfAverages largestSumOfAverages = new LargestSumOfAverages();
    System.out.println(largestSumOfAverages.largestSumOfAverages(ans, 4));
  }

  public double largestSumOfAverages(int[] nums, int k) {
    int n = nums.length;
    if (k > n) {
      return 0;
    }
    int[] pf = new int[n];
    pf[0] = nums[0];
    for (int i = 1; i < n; i++) {
      pf[i] = pf[i - 1] + nums[i];
    }
    double[][] dp = new double[n][k];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return largestSumOfAverages(pf, dp, 0, k - 1);
  }

  private double largestSumOfAverages(int[] nums, double[][] dp, int i, int k) {
    int n = nums.length;
    if (k == 0) {
      double sum = (i == 0) ? nums[n - 1] : nums[n - 1] - nums[i - 1];
      return sum / (n - i);
    }
    if (dp[i][k] != -1) {
      return dp[i][k];
    }
    double max = 0.0;
    for (int index = i; index < n - k; index++) {
      double sum = nums[index];
      if (i > 0) {
        sum -= nums[i - 1];
      }
      double average = sum / (index - i + 1);
      double right = largestSumOfAverages(nums, dp, index + 1, k - 1);
      max = Math.max(max, average + right);
    }

    dp[i][k] = max;
    return dp[i][k];
  }
}
