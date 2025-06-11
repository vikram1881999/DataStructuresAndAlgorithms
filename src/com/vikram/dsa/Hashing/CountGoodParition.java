package com.vikram.dsa.Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountGoodParition {

  public static void main( String[] args ) {
    int[] num = {1,2,2,4};
    CountGoodParition countGoodParition = new CountGoodParition();
    System.out.println( countGoodParition.numberOfGoodPartitions(num));
  }

  public int numberOfGoodPartitions(int[] nums) {
        int mod = 1_000_000_007;
        Map<Integer, Integer> indexMapGreater = new HashMap<>();
        Map<Integer, Integer> indexMapSmaller = new HashMap<>();
        for( int i = 0; i < nums.length; i++ ) {
            indexMapGreater.put(nums[i], i);
        }

        for( int i = nums.length-1; i >= 0; i-- ) {
            indexMapSmaller.put(nums[i], i);
        }

        int i = 0;
        int j = nums.length-1;
        long left = 0;
        long right = 0;
        long ans = 0;
        while( i < j ) {
            int index = indexMapGreater.get(nums[i]);
            for( int k = i; k <= index; k++ ) {
                i = Math.max(indexMapGreater.get(nums[k]), i);
            }
            index = indexMapSmaller.get(nums[j]);
            for( int k = j; k >= index; k-- ) {
                j = Math.min(indexMapSmaller.get(nums[k]), j);
            }
            if( i >= j ) {
                left++;
                break;
            }
            left++;
            right++;
            i++;
            j--;
        }
        long length = left+right;
        if( i != j ) {
            length -= 1;
            length = Math.max(length, 0);
        }
        ans = (ans + length%mod)%mod;

        return (int)ans;
    }
  
}
