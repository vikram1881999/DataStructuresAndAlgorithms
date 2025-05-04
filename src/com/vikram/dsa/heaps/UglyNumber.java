package com.vikram.dsa.heaps;

import java.util.HashSet;

public class UglyNumber {

  public static void main( String[] args ) {
    UglyNumber number = new UglyNumber();
    System.out.println(number.nthUglyNumber(11));
  }
  public int nthUglyNumber(int n) {
        if( n == 1 ) {
            return 1;
        }
        HashSet<Integer> primes = new HashSet<Integer>();
        boolean[] notPrimes = new boolean[(5*n) + 1 ];
        for( int i = 2; i*i < notPrimes.length; i++ ) {
            if( !notPrimes[i] ) {
                for( int j = i*i; j< notPrimes.length; j += i ) {
                    notPrimes[j] = true;
                }
            }
        }

        for( int i = 1; i < notPrimes.length; i++ ) {
            if( i != 1 && i!= 2 && i!= 3 && i!=5 ) {
                if( !notPrimes[i] ) {
                    primes.add(i);
                }
            }
        }

        boolean[] arr = new boolean[(5*n) + 1 ];
        for( Integer prime: primes ) {
            arr[prime] = true;
            for( int j = prime; j < arr.length; j += prime ) {
              arr[j] = true;
            }
        }
        int ans = 1;
        int i = 1;
        while( n > 0 ) {
            if(!arr[i] && !primes.contains(arr[i])) {
                ans = i;
                n--;
            }
            i++;
        }

        return ans;
    }
  
}
