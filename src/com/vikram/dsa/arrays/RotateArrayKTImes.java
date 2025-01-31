package com.vikram.dsa.arrays;

import java.util.Arrays;

/**
 *  Given N array elements, Rotate array from last to first by k times
 */
public class RotateArrayKTImes {

    public static void main(String[] args) {
        RotateArrayKTImes obj = new RotateArrayKTImes();
        int[] arr =  { -2, 3, 1, 4, 6, 2, 8, 7, 9, 3};
        obj.rotateKTimes1(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Idea -> Rotate first from 0 to n, second rotate from 0 to k-1, rotate from k to n-1
     * @param nums
     * @param k
     * TC -> O(N)
     * SC -> O(1)
     */
    public void rotateKTimes1(int[] nums, int k) {
        rotate( nums, 0, nums.length-1);
        rotate( nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    /**
     * Idea -> Rotate first from 0 to k-1, second rotate from k to n-1, third rotate whole array
     * @param nums
     * @param k
     */
    public void rotateKTimes(int[] nums, int k) {
        rotate( nums, 0, nums.length -  (k+1));
        rotate( nums, nums.length - k, nums.length - 1);
        rotate(nums, 0, nums.length - 1);
    }

    public void rotate(int[] nums, int p1, int p2) {
        int i = p1;
        int j = p2;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }


}
