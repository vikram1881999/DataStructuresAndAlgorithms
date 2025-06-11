package com.vikram.dsa.arrays.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRobBank {

  public static void main(  String[] args ) {
    int[] arr = {5,3,3,3,5,6,2};
    FindGoodDaysToRobBank findGoodDaysToRobBank = new FindGoodDaysToRobBank();
    System.out.println( findGoodDaysToRobBank.goodDaysToRobBank(arr, 2) );
  }

  public List<Integer> goodDaysToRobBank(int[] security, int t) {
        List<Integer> ans = new ArrayList<>();
        int n = security.length;
        int pf[] = new int[n];
        pf[0] = 1;
        int[] sf = new int[n];
        sf[n-1] = 1;

        for( int i = 1; i < n; i++ )  {
            if( security[i] >= security[i-1] ) {
                pf[i] = pf[i-1] + 1;
            }
            else {
                pf[i] = 1;
            }
        }

        for( int i = n-2; i >= 0; i-- ) {
            if( security[i] >= security[i+1] ) {
                sf[i] = sf[i+1] + 1;
            }
            else {
                sf[i] = 1;
            }
        }

        for( int i = 0 + t; i < n-t; i++ ) {
            int leftIncreasingSequence = sf[i-t] - sf[i];
            int rightIncreasingSequence = pf[i+t] - pf[i];
            if( t <= leftIncreasingSequence && t <= rightIncreasingSequence ) {
                ans.add(i);
            }
        }

        return ans;
    }
  
}
