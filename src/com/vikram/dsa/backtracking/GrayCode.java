package com.vikram.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

  public static void main( String[] args ) {
    GrayCode grayCode = new GrayCode();
    System.out.println(grayCode.grayCode(3));
  }

  public List<Integer> grayCode(int n) {
        if ( n == 1 ) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }
        List<Integer> code = grayCode(n-1);
        List<Integer> newCode = new ArrayList<>();
        for( int i = 0; i < code.size(); i++ ) {
            newCode.add(code.get(i));
        }
        for( int i = code.size()-1; i >= 0; i-- ) {
            int curr = code.get(i) + (1<<n-1);
            newCode.add(curr);
        }

        return newCode;
    }

  
}
