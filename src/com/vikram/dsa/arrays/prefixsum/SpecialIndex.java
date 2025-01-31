package com.vikram.dsa.arrays.prefixsum;

/**
 *  An index is said to be special index, if after deleting index sum of all even index = sum of all odd index
 */
public class SpecialIndex {

    public static void main(String[] args) {
        SpecialIndex obj = new SpecialIndex();
        int[] arr = { 3, 2, 6, 8, 2, 9, 7, 6, 4, 12};
        System.out.println( obj.specialIndex(arr));
    }

    /**
     * Idea -> Create pf even and pf odd
     * if we delete an index the pf even and odd remain uneffected but on right side the pf even become odd and
     * odd becomes even
     * @param A
     * @return
     */
    public int specialIndex(int[] A) {
        if( A.length <= 1) {
            return A.length;
        }
        int c = 0;
        int pfE[] = new int[ A.length ];
        int pfO[] = new int[ A.length ];
        pfE[0] = A[0];
        pfO[0] = 0;
        for(int i = 1; i < A.length; i++) {
            if( i%2 == 0 ) {
                pfE[i] = pfE[i-1] + A[i];
                pfO[i] = pfO[i-1];
            }
            else {
                pfE[i] = pfE[i-1];
                pfO[i] = pfO[i-1] + A[i];
            }
        }

        for(int i = 0; i < A.length; i++) {
            int sumEven = pfO[A.length-1] - pfO[i];
            int sumOdd = pfO[A.length-1] - pfO[i];
            if( i != 0 ) {
                sumEven = sumEven + pfE[i-1];
                sumOdd = sumOdd + pfO[i-1];
            }
            if( sumEven == sumOdd) {
                c++;
            }
        }

        return c;
    }


}
