package com.vikram.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMaximumLengthOfGoodSubsequence {
  public static void main(String[] args) {
    int[] nums = { 1, 2, 1, 1, 3 };
    FindMaximumLengthOfGoodSubsequence findMaximumLengthOfGoodSubsequence = new FindMaximumLengthOfGoodSubsequence();
    System.out.println(findMaximumLengthOfGoodSubsequence.maximumLengthEfficient(nums, 2));
  }

  public int maximumLength(int[] nums, int k) {
    int n = nums.length;
    int ans = 0;
    int[] prevDp = new int[n];
    for (int c = 0; c <= k; c++) {
      int[] currDp = new int[n];
      Arrays.fill(currDp, 1);
      for (int i = 0; i < n; i++) {
        int currLength = currDp[i];
        for (int j = 0; j < i; j++) {
          if (nums[i] == nums[j]) {
            currDp[i] = Math.max(currDp[i], currLength + currDp[j]);
          } else if (c > 0) {
            currDp[i] = Math.max(currDp[i], currLength + prevDp[j]);
          }
        }
      }
      prevDp = currDp;
    }

    for (int i = 0; i < n; i++) {
      ans = Math.max(prevDp[i], ans);
    }

    return ans;
  }

  public int maximumLengthEfficient(int[] nums, int k) {
    int[] ans = new int[k + 1];
        Map<Integer, Integer>[] map = new HashMap[k + 1];
        for (int i = 0; i <= k; i++) map[i] = new HashMap();
        for (int n : nums) {
            for (int i = k; i >= 0; i--) {
                int value = map[i].getOrDefault(n, 0);
                value = Math.max(value + 1, i > 0 ? ans[i - 1] + 1 : 0);
                map[i].put(n, value);
                ans[i] = Math.max(ans[i], value);
            }
        }
        return ans[k];
  }
}
