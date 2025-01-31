package com.vikram.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given N array elements, check if there exists a pair(i, j) such that arr[i] + arr[j] = k && i != j
 */
public class PairSum1 {

    public static void main(String[] args) {
        PairSum1 pairSum1 = new PairSum1();
        int[] arr1 =  { 3, -2, 1, 4, 3, 6, 8};
        System.out.println(pairSum1.bruteForce(arr1, 10));
        System.out.println(pairSum1.optimizeWithSet(arr1, 10));
    }

    // TC O(N*N)
    // SC O(1)
    public boolean bruteForce(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    // TC O(N)
    // SC O(N)
    public boolean optimizeWithSet(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for( int num: nums ) {
            set.add(num);
        }
        for( int i = 0; i < nums.length; i++) {
            int num = nums[i] - k;
            if(set.contains(num)) {
                return true;
            }
        }
        return false;
    }

}
