package com.vikram.dsa.dynamicprogramming;

public class Power {

  public static void main( String[] args ) {
    Power power = new Power();
    System.out.println( power.power(25,4));
  }


  public long power( long num, long pow ) {
    if( pow == 0 ) {
        return 1;
    }
    long total = 1;
    while( pow > 0 ) {
        if( pow%2 == 1 ) {
            total = total * num;
            pow = pow - 1;
        }
        else {
            num = num*num;
            pow = pow/2;
        }
    }

    return total;
}
  
}
