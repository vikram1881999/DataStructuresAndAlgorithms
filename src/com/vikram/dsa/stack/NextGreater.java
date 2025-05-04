package com.vikram.dsa.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreater {

  public static void main( String[] args ) {
    NextGreater greater = new NextGreater();
    ArrayList<Integer> list = new ArrayList<>(List.of(34,35,27,42,5,28,39,20,28));
    
    System.out.println( greater.nextGreater(list));
  }


  public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        int[] ans = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        
        for( int i = A.size()-1; i >= 0; i-- ) {
            while( !stack.isEmpty() && stack.peek() <= A.get(i) ) {
                stack.pop();
            }
            if( stack.isEmpty() ) {
                ans[i] = -1;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(ans[i]);
        }

        ArrayList<Integer> ansList = new ArrayList<>();
        for( int i = 0; i < ans.length; i++ ) {
            ansList.add(ans[i]);
        }
        return ansList;
    }
  
}
