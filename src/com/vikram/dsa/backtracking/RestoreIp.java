package com.vikram.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIp {

  public static void  main( String[] args ) {
    RestoreIp ip = new RestoreIp();
    System.out.println(ip.restoreIpAddresses("1111"));
  }


   public static List<String> ans = new ArrayList<>(); 
    public List<String> restoreIpAddresses(String s) {
        ans.clear();
        restoreIP(s, 0, "", 0);
        return ans;
    }

    private void restoreIP( String s, int i, String restoredIp, int dots ) {
        if( dots >= 3 ) {
            if( s.length() - i > 3 || s.length() == i) {
                return;
            }
            String subStr = s.substring(i, s.length());
            if ( subStr.charAt(0) == '0' && subStr.length() > 1 ) {
              return;
            }
            if( Integer.parseInt(subStr) <= 255 ) {
                restoredIp = restoredIp + subStr;
                ans.add( restoredIp);
            }
            return;
            
        }

        if( s.charAt(i) == '0' ) {
            restoreIP( s, i+1, restoredIp + s.charAt(i) + ".", dots+1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for( int j = i; j < Math.min( i+3, s.length() ); j++ ) {
            sb.append( s.charAt(j) );
            if( Integer.parseInt(sb.toString()) <= 255 ) {
                restoreIP( s, j+1, restoredIp + sb.toString() +  ".", dots+1);
            }
        }
    }
  
}
