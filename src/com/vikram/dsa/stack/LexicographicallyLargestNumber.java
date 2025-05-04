package com.vikram.dsa.stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LexicographicallyLargestNumber {

  public static void main( String[] args ) {
    LexicographicallyLargestNumber lexicographicallyLargestNumber = new LexicographicallyLargestNumber();
    List<Integer>  list =  List.of(9,1,2,5,8,3);
    System.out.println(lexicographicallyLargestNumber.lexicographicallyLargetNumber(list, 4));
  }

  public List<Integer> lexicographicallyLargetNumber( List<Integer> number, int k  ){
    Stack<Integer> stack  = new Stack<>();
    for( int i = 0; i < number.size(); i++ ) {
      while( !stack.isEmpty() && stack.peek() <=  number.get(i) &&  stack.size() + number.size() - i - 1 >= k ) {
        stack.pop();
      }
      if( stack.size() < k ) {
        stack.push(number.get(i));
      }
    }

    List<Integer> answer = new ArrayList<>();
    while( !stack.isEmpty() ) {
      answer.add(stack.pop());
    } 

    Collections.reverse(answer);

    return answer;
  }
  
}
