package com.vikram.dsa.arrays.prefixsum;

public class MinimumPenaltyForShop {

  public static void main( String[] args ) {
    MinimumPenaltyForShop minimumPenaltyForShop = new MinimumPenaltyForShop();
    System.out.println(minimumPenaltyForShop.bestClosingTime2("YYNY"));
  }



  public int bestClosingTime(String customers) {
    int n = customers.length();
    int[] countNoCustomerPenalty = new int[n];
    int[] futurePotentialCustomerPenalty = new int[n];
    for( int i = 0; i < n; i++ ) {
        int c = customers.charAt(i) == 'N' ?  1 : 0;
        if( i == 0 ) {
            countNoCustomerPenalty[i] = c;
            continue;
        }
        countNoCustomerPenalty[i] = countNoCustomerPenalty[i-1] + c;
    }

    for( int i = n-1; i >= 0; i-- ) {
      int c = customers.charAt(i) == 'Y' ?  1 : 0;
        if( i == n-1 ) {
            futurePotentialCustomerPenalty[i] = c;
            continue;
        }
        futurePotentialCustomerPenalty[i] = futurePotentialCustomerPenalty[i+1] + c;
    }

    int minHour = 0;
    int min = futurePotentialCustomerPenalty[0];

    for( int i = 0; i < n; i++ ) {
        int noCustomerPenalty = countNoCustomerPenalty[i];
        int futureCustomerPenalty = 0;
        if( i < n-1 ) {
           futureCustomerPenalty = futurePotentialCustomerPenalty[i+1];
        }
        int maxPenalty = noCustomerPenalty+ futureCustomerPenalty;
        if( maxPenalty < min ) {
            min = maxPenalty;
            minHour = i+1;
        }
    }

    return minHour;
}
public int bestClosingTime2(String customers) {
  int minPenalty = 0, curPenalty = 0;
  int earliestHour = 0;

  for (int i = 0; i < customers.length(); i++) {
      char ch = customers.charAt(i);
      if (ch == 'Y') {
          curPenalty--;
      } else {
          curPenalty++;
      }
      
      if (curPenalty < minPenalty) {
          earliestHour = i + 1;
          minPenalty = curPenalty;
      }
  }

  return earliestHour;
}
  
  
}
