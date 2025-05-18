package com.vikram.dsa.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumOperations {

  public static void main( String[] args ) {
    int[] nums= {3,1,6,8};
    int[] q = {1,5};
    MinimumOperations minimumOperations = new MinimumOperations();
    System.out.println(minimumOperations.minOperations(nums, q));
  }


  public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] pf = new long[n];
        List<Long> ans = new ArrayList<>();
        pf[0] = (long)nums[0];
        for( int i = 1; i < n; i++) {
            pf[i] = pf[i-1] + (long)nums[i];
        }

        for( int i = 0; i < queries.length; i++ ) {
            int index = getMinIndex(nums, queries[i]);
            if( index == 0 ) {
                ans.add( Math.abs(pf[n-1] - (queries[i]*n)));
            }
            else {
                long leftSum = Math.abs(queries[i]*(index-1+1) - pf[index-1] );
                long rightSum = Math.abs(queries[i]*(n-index) - ( pf[n-1] - pf[index-1]));
                ans.add( leftSum + rightSum);
            }
        }

        return ans;
    }

    private int getMinIndex( int[] nums, int k ) {
        int l = 0;
        int h = nums.length-1;
        int index = 0;
        if( nums[index] > k || nums[nums.length-1] < k ) {
            return 0;
        }
        while( l <= h ) {
            int m = (l+h)/2;
            if( nums[m] == k ) {
                return m;
            }
            else if( nums[m] < k ) {
                l = m+1;
            }
            else {
                index = m;
                h= m-1;
            }
        }

        return index;
    }
  
}
