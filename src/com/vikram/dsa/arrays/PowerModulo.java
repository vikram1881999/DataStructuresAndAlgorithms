package com.vikram.dsa.arrays;

public class PowerModulo {
  
  public static void main( String[] args ) {
    PowerModulo modulo = new PowerModulo();
    System.out.println(modulo.powerModulo(2, 5));
  }

  public int powerModulo( int n, int p ) {
    char ch = 'z';
    int num = (int)ch;
    System.out.println(num);
    int ans = 1;
    while( p > 0 ) {
      if( p%2 == 1 ) {
        ans = ans*n;
        p = p-1;
      }
      else {
        n = n*n;
        p = p/2;
      }
    }
    return ans;
  }
}