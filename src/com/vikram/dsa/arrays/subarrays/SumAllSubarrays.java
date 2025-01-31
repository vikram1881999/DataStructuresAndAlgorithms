package com.vikram.dsa.arrays.subarrays;

/**
 * 1> Print all subarrays sum
 */
public class SumAllSubarrays {

    public static void main(String[] args) {
        SumAllSubarrays obj = new SumAllSubarrays();
        int[] arr = {1,2,3,4};
        obj.printAllSum(arr);
        System.out.println();
        obj.printAllSumCarryForward(arr);
        System.out.println();
        System.out.println(obj.sumAllSubarrays(arr));
    }

    // TC -> O(N)
    // IDEA -> Contribution technique
    public int sumAllSubarrays( int[] arr ) {
        int n = arr.length;
        int sum = 0;
        for( int i = 0; i < n; i++) {
            sum = sum + ( (i+1)*(n-i)*arr[i]);
        }
        return sum;
    }

    // TC -> O(N^2)
    // SC -> O(N)
    public void printAllSum( int[] arr ) {
        int n = arr.length;
        int[] pf = new int[n];
        pf[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i-1] + arr[i];
        }
        for( int i = 0; i < n; i++ ) {
            for( int j = i; j < n; j++ ) {
                if( i == 0 ) {
                    System.out.print(pf[j] + " ");
                }
                else {
                    System.out.print(pf[j] - pf[i-1] + " ");
                }
            }
        }
    }

    // TC -> O(N^2)
    // SC -> O(1)
    public void printAllSumCarryForward( int[] arr ) {
        int allSum = 0;
        int n = arr.length;
        for( int i = 0; i < n; i++ ) {
            int sum = 0;
            for( int j = i; j < n; j++ ) {
                sum = sum + arr[j];
                allSum = allSum + sum;
                System.out.print( sum + " ");
            }
        }
        System.out.println(allSum);
    }

}
