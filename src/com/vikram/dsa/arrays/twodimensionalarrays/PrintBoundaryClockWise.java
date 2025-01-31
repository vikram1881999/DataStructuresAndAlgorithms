package com.vikram.dsa.arrays.twodimensionalarrays;

public class PrintBoundaryClockWise {

    public static void main( String[] args ) {
        PrintBoundaryClockWise printBoundaryClockWise = new PrintBoundaryClockWise();
        int[][] arr = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13, 14, 15, 16}};
        printBoundaryClockWise.printBoundary(arr);
    }

    public void printBoundary( int[][] arr ) {
        int n = arr.length;
        int m = arr[0].length;
        for( int i = 0; i < m-1; i++ ) {
            System.out.print(arr[0][i] + " ");
        }
        System.out.println();
        for( int i = 0; i < n-1; i++ ) {
            System.out.print(arr[i][m-1] + " ");
        }
        System.out.println();
        for( int i = m-1; i > 0; i-- ) {
            System.out.print(arr[n-1][i] + " ");
        }
        System.out.println();
        for( int i = n-1; i > 0; i-- ) {
            System.out.print(arr[i][0]+ " ");
        }
    }
}
