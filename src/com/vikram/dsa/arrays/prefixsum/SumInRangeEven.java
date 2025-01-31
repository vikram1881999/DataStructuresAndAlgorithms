package com.vikram.dsa.arrays.prefixsum;

import java.util.Arrays;

/**
 *  Given N Array elements & Q queries, for each query iterate & get sum of all even index element in given range
 */
public class SumInRangeEven {

    public static void main(String[] args) {
        SumInRangeEven obj = new SumInRangeEven();
        int[] arr = { 3, 2, 1, 6, -3, 2, 8, 4, 9 };
        int[][] queries = { { 1, 4 }, { 2, 7 }, { 3, 8 }, {0, 4} };
        System.out.println(Arrays.toString(obj.sumInRange(arr, queries)));
    }

    public int[] sumInRange(int[] nums, int[][] queries) {
        int[] sums = new int[queries.length];
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for( int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }

        for( int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if( l == 0 ) {
                sums[i] = prefixSum[r];
            }
            else {
                sums[i] = prefixSum[r] - prefixSum[l-1];
            }
        }

        return sums;
    }
}
