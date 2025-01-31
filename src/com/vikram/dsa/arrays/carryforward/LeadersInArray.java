package com.vikram.dsa.arrays.carryforward;

/**
 * Given an arr[n], you have to find leaders in arr[] an ele is leader, if its strictly greater than max of all elements
 * on left side
 */
public class LeadersInArray {

    public static void main(String[] args) {
        LeadersInArray leadersInArray = new LeadersInArray();
        int[] arr = { 3, 2, 4, 5, 2, 7, -1, 15};
        System.out.println(leadersInArray.countLeaders(arr));
    }

    public int countLeaders(int[] arr) {
        int c = 0;
        int max = Integer.MIN_VALUE;
        for( int i = 0; i < arr.length; i++) {
            if( arr[i] > max ) {
                max = arr[i];
                c++;
            }
        }
        return c;
    }
}
