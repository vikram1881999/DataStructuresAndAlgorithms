package com.vikram.dsa.arrays.twodimensionalarrays;

import java.util.Arrays;

public class TransposeMatrix {

    public static void main( String[] args ) {
        TransposeMatrix transposeMatrix = new TransposeMatrix();
        int[][] mat= {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        System.out.println(Arrays.deepToString(transposeMatrix.transposeMatrix(mat)));
    }

    public int[][] transposeMatrix( int[][] arr ) {
        int n = arr.length;
        for( int i = 0; i < n; i++) {
            for( int j = i+1; j < n; j++ ) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return arr;
    }
}
