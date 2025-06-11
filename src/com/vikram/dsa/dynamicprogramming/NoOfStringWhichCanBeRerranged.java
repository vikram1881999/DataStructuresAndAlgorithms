package com.vikram.dsa.dynamicprogramming;

public class NoOfStringWhichCanBeRerranged {

  public static void main(String[] args) {
    NoOfStringWhichCanBeRerranged canBeRerranged = new NoOfStringWhichCanBeRerranged();
    System.out.println(canBeRerranged.stringCount(10));
  }

  long mod = 1_000_000_007L;

  public int stringCount(int n) {

    long allPossible = power(26, (long) n);
    // Excluding 1 word
    long res1 = (power(25, (long) n) * 3) % mod;
    // 1 repetative at pos any pos
    res1 = (res1 + ((long) n * power(25, (long) n - 1L)) % mod) % mod;

    // Excluding 2 word
    long res2 = (power(24, (long) n) * 3) % mod;
    // 1 repetative at any pos with 2 exclusions
    res2 = (res2 + (2L * (long) n * power(24, (long) n - 1)) % mod) % mod;

    // Excluding 3 word;
    long res3 = power(23, (long) n);
    res3 = (res3 + ((long) n * power(23, (long) n - 1)) % mod) % mod;

    long total = (res1 + res3) % mod;
    total = (total - res2 + mod) % mod;
    return (int) ((allPossible - total + mod) % mod);
  }

  public long power(long num, long pow) {
    if (pow == 0) {
      return 1;
    }
    long total = 1;
    while (pow > 0) {
      if (pow % 2 == 1) {
        total = (total * num) % mod;
        pow = pow - 1;
      } else {
        num = (num * num) % mod;
        pow = pow / 2;
      }
    }

    return total;
  }

}
