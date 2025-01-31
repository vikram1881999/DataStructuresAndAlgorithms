package com.vikram.dsa.arrays;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();
        int[] arr1 = { 2,4,2,1,21,4,121,3 };
        System.out.println(Arrays.toString(reverseArray.reverseArray(arr1)));
    }

    public int[] reverseArray(int[] array) {
        int i = 0;
        int j =  array.length - 1;
        while( i < j ) {
            int temp  = array[i];
            array[i]  = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return array;
    }
}
