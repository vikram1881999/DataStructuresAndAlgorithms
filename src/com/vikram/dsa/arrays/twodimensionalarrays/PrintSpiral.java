package com.vikram.dsa.arrays.twodimensionalarrays;

public class PrintSpiral {

    public static void main( String[] args ) {
        PrintSpiral printSpiral = new PrintSpiral();
        int[][] arr = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13, 14, 15, 16}};
        int[][] arr1 = { {1,2,3,4, 5}, {6,7,8,9, 10}, {11,12, 13, 14, 15} ,{ 16, 17,18,19,20}, {21, 22, 23, 24, 25}};
        printSpiral.printSpiral(arr);
        printSpiral.printSpiral(arr1);
    }

    public void printSpiral(int[][] arr){
        int n = arr.length;
        int i = 0;
        int j = 0;
        while( n > 1 ) {
            int a = i;
            int b = j;
            for( int k = 0; k < n-1; k++ ) {
                System.out.println(arr[a][b]);
                b++;
            }
            for( int k = 0; k < n-1; k++ ) {
                System.out.println(arr[a][b]);
                a++;
            }
            for( int k = 0; k < n-1; k++ ) {
                System.out.println(arr[a][b]);
                b--;
            }
            for( int k = 0; k < n-1; k++ ) {
                System.out.println(arr[a][b]);
                a--;
            }
            n = n-2;
            i++;
            j++;
        }

        if( n%2 == 1 ) {
            System.out.print(arr[i][j]);
        }
    }
}
