package com.vikram.dsa.arrays.twodimensionalarrays;

import java.util.Arrays;

public class RotateMatrix {

    public static void main( String[] args ) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] mat1= {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        int[][] mat2= {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        int[][] mat3= {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        System.out.println(Arrays.deepToString(rotateMatrix.rotateMatrix90(mat1)));
        System.out.println(Arrays.deepToString(rotateMatrix.rotate180(mat2)));
        System.out.println(Arrays.deepToString(rotateMatrix.rotate270(mat3)));
    }

    public int[][] rotateMatrix90( int[][] arr ) {
        int[][] newArr = transposeMatrix(arr);
        int n = newArr.length;
        for( int i = 0; i < n; i++ ){
            int p1 = 0;
            int p2 = n-1;
            while( p1 < p2 ) {
                int temp = newArr[i][p1];
                newArr[i][p1] = newArr[i][p2];
                newArr[i][p2] = temp;
                p1++;
                p2--;
            }
        }
        return arr;
    }

    public int[][] rotate180( int[][] arr ) {
        int n = arr.length;
        for( int i = 0; i < n; i++ ){
            int p1 = 0;
            int p2 = n-1;
            while( p1 < p2 ) {
                int temp = arr[i][p1];
                arr[i][p1] = arr[i][p2];
                arr[i][p2] = temp;
                p1++;
                p2--;
            }
        }
        return arr;
    }

    public int[][] rotate270( int[][] arr ) {
        int[][] rotate180 = rotate180(arr);
        int[][] transpose = transposeMatrix(rotate180);
        int n = transpose.length;
        for( int i = 0; i < n; i++ ){
            int p1 = 0;
            int p2 = n-1;
            while( p1 < p2 ) {
                int temp = transpose[i][p1];
                transpose[i][p1] = transpose[i][p2];
                transpose[i][p2] = temp;
                p1++;
                p2--;
            }
        }
        return arr;

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
