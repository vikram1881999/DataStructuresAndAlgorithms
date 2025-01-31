package com.vikram.dsa.arrays.prefixsum;

import java.util.Arrays;

/**
 * Given N array elements & Q queries in same array for each query calculate sum of all elements in Given Range?
 */
public class SumInRange {

    public static void main(String[] args) {
        SumInRange obj = new SumInRange();
        int[] arr = { -3, 6, 2, 4, 5, 2, 8, -9, 3, 1 };
        int[][] queries =  {{4, 8}, {3, 7}, { 1, 3 }, { 0, 4 }, { 6, 9 }, { 7, 7}};
        System.out.println(Arrays.toString(obj.sumInRange(arr, queries)));
        System.out.println(Arrays.toString(obj.sumInRangePrefixSum(arr, queries)));

    }

    /**
     * Brute force TC = O(N*M) and  SC = O(M)
     * @param nums
     * @param queries
     * @return
     */
    public int[] sumInRange(int[] nums, int[][] queries ) {
        int[ ] sums = new int[ queries.length ];
        for( int i = 0; i < queries.length; i++ ) {
            int l = queries[i][0];
            int r = queries[i][1];
            int sum = 0;
            for( int j = l; j <= r; j++ ) {
                sum = sum + nums[j];
            }
            sums[i] = sum;
        }
        return sums;
    }

    /**
     * Idea -> Prefix sum like cricket score keep cumulating and if we have to find run b/w overs for exam b/w 12 to 19th over
     * then we will subtract cumlative sum till 11th over with cummulative sum till 19th over and we get result/
     *
     * TC -> O(N)
     * SC -> O(M)
     */
    public int[] sumInRangePrefixSum( int[] nums, int[][] queries ) {
        int[] sums = new int[ queries.length ];
        int[] pf = new int[ nums.length ];
        pf[0] = nums[0];
        for( int i = 1; i < nums.length; i++ ) {
            pf[i] = pf[i-1] + nums[i];
        }

        for( int i = 0; i < queries.length; i++ ) {
            int l = queries[i][0];
            int r = queries[i][1];
            if( l == 0 ) {
                sums[i] = pf[r];
            }
            else {
                sums[i] = pf[r] -  pf[l-1];
            }
        }

        return sums;
    }
}
