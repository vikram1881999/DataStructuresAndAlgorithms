package com.vikram.dsa.arrays;

import java.util.Arrays;

/**
 * Given N array elements count number of elements, having atleast 1 element smaller than themselves
 */
public class CountSmaller {
    public static void main(String[] args) {
        int arr1[] = { -3, -2, 6, 8, 4, 8, 5 };
        int arr2[] = { 2, 3, 10, 7, 3, 2, 10, 8 };
        int arr3[] = { 2, 5, 1, 4, 8, 0, 8, 1, 3, 8};
        CountSmaller cg = new CountSmaller();

        System.out.println( cg.countBruteForce(arr1));
        System.out.println( cg.sortOptimization(arr1));
        System.out.println( cg.optimizationMinCount(arr1));
        System.out.println( "________________________________________________");
        System.out.println( cg.countBruteForce(arr2));
        System.out.println( cg.sortOptimization(arr2));
        System.out.println( cg.optimizationMinCount(arr2));
        System.out.println( "________________________________________________");
        System.out.println( cg.countBruteForce(arr3));
        System.out.println( cg.sortOptimization(arr3));
        System.out.println( cg.optimizationMinCount(arr3));
    }

    // TC O(n*n)
    // SC O(1)
    public int countBruteForce(int[] nums) {
        int count = 0;
        for( int i  = 0; i < nums.length; i++ ) {
            for (int num : nums) {
                if (nums[i] > num) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // TC O(NlogN)
    // SC O(NlogN)
    public int sortOptimization(int[] nums) {
        Arrays.sort(nums);
        int c =  0;
        for( int i = 0; i < nums.length; i++ ) {
            if( i != 0 && nums[i] > nums[i - 1] ) {
                break;
            }
            else {
                c++;
            }
        }
        return nums.length - c;
    }


    // Idea -> Maintain the count for min and as soon as min changes count become 1 return length - count
    public int optimizationMinCount(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 1;
        for( int i = 0; i < nums.length; i++ ) {
            if( nums[i] == min ) {
                count++;
            }
            else if( nums[i] < min ) {
                min = nums[i];
                count = 1;
            }

        }
        return nums.length - count;
    }
}
