package com.vikram.dsa.dynamicprogramming;

public class WaysToDecode {

  public static void main( String[] args ) {
    WaysToDecode toDecode = new WaysToDecode();
    System.out.println(toDecode.numDecodings("17"));
  }


  int[] dp;
    public int numDecodings(String A) {
        dp = new int[A.length()];
        for( int i = 0; i < A.length(); i++) {
            dp[i] = -1;
        }
        int ans = numDecode(A.length() -1, A);
        return ans%mod;
    }
    int mod = 1000000007;
	public int numDecode(int i, String A) {
        if( i < 0) {
            return 1;
        }
		if( dp[i] == -1 ) {
            int a = 0;
            int b = 0;
            if( A.charAt(i) != '0' ) {
                a = numDecode( i-1, A.substring(0, i));
            }
            if( i >= 1 ) {
                int num1 = Integer.parseInt(A.charAt(i) + "" + A.charAt(i-1));
                int num2 = Integer.parseInt(A.charAt(i) + "");
                if(  num1 <= 26 && num1 != num2 ) {
                    b = numDecode(i-2, A);
                }
            }
            dp[i] = (int)((long)a+(long)b)%mod;
		}
		
		return dp[i];
	}
  
}
