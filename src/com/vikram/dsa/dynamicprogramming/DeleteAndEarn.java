package com.vikram.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteAndEarn {

  public static void main(String[] args) {
    int[] arr = { 3, 1 };
    DeleteAndEarn andEarn = new DeleteAndEarn();
    System.out.println(andEarn.deleteAndEarn(arr));
  }

  public int deleteAndEarn(int[] nums) {
    List<PairO> list = new ArrayList<>();
    Arrays.sort(nums);
    PairO currPairO = new PairO(nums[0], 1);
    for (int i = 1; i < nums.length; i++) {
      if (currPairO.ele == nums[i]) {
        currPairO.count += 1;
      } else {
        list.add(currPairO);
        currPairO = new PairO(nums[i], 1);
      }
    }
    list.add(currPairO);
    int[] dp = new int[list.size()];
    Arrays.fill(dp, -1);
    return deleteAndEarn(dp, list, list.size() - 1);
  }

  private int deleteAndEarn(int[] dp, List<PairO> list, int i) {
    if (i < 0) {
      return 0;
    }

    if (dp[i] != -1) {
      return dp[i];
    }
    int cost1 = deleteAndEarn(dp, list, i - 1);
    int cost2 = list.get(i).ele * list.get(i).count;
    if (i - 1 >= 0 ) {
      if( list.get(i - 1).ele == list.get(i).ele - 1) {
        cost2 = cost2 + deleteAndEarn(dp, list, i - 2);
      }
      else {
        cost2 = cost2 + deleteAndEarn(dp, list, i - 1);
      }
    }

    dp[i] = Math.max(cost1, cost2);
    return dp[i];
  }
}


class PairO {
  int ele;
  int count;

  public PairO(int ele, int count) {
    this.ele = ele;
    this.count = count;
  }
}