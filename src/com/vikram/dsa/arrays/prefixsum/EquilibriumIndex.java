package com.vikram.dsa.arrays.prefixsum;

/**
 * Given N array elements, count no of Equilibrium index. An index i is said to be Equilibrium index if sum of all elements
 * before ith index  =  sum all elements after i index
 */
public class EquilibriumIndex {

    public static void main(String[] args) {

        EquilibriumIndex obj = new EquilibriumIndex();
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println( obj.countEquilibrium(arr));
    }

    public int countEquilibrium(int[] A) {
        int[] prefixSum = new int[A.length];
        int c = 0;
        prefixSum[0] = A[0];
        for( int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        for( int i = 0; i < A.length; i++) {
            int sumBeforeI = 0;
            int sumAfterI = prefixSum[A.length-1] - prefixSum[i];
            if( i > 0 ) {
                sumBeforeI = prefixSum[i-1];
            }
            if( sumBeforeI == sumAfterI ) {
                c++;
            }
        }
        return c;
    }


}
