package com.vikram.dsa.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CheckTwoBracketExpression {

  public static void main( String[] args ) {
    String s = "-(-(-(-a+b)-d+c)-q)";
    CheckTwoBracketExpression  bracketExpression = new CheckTwoBracketExpression();
    System.out.println(bracketExpression.postFixExpression(s));
  }



  public String postFixExpression(String A ) {
        Stack<Character> stack = new Stack<>();
        List<Character> characters = new ArrayList<>();
        for( int i = 0; i < A.length(); i++ ) {
            char ch = A.charAt(i);
            if( ch == '+' || ch == '-' ) {
                stack.push(ch);
            }
            else if(  ch == '(' ) {
              if( i > 0  &&  A.charAt(i-1) == '(' ) {
                stack.push('+');
              }
              stack.push(ch);
            }
            else if( ch == ')') {
                while( stack.peek() != '(' ) {
                    char c = stack.pop();
                    characters.add(c);
                }
                stack.pop();
                if( !stack.isEmpty() && stack.peek() == '-' ) {
                    for( int j =  characters.size()-1; j >= 0; j-- ) {
                      if( characters.get(j) == '+' ) {
                        characters.set(j, '-');
                      }
                      else if( characters.get(j) == '-' ) {
                        characters.set(j, '+');
                      }
                    }
                }
                if( !stack.isEmpty() ) {
                  stack.pop();
                }
            }
            else {
                if( i > 0  && A.charAt(i-1) == '(' && (A.charAt(i) != '-' || A.charAt(i) != ')' || A.charAt(i) != '(' )) {
                    stack.push('+');
                }
                characters.add(ch);
            }
        }
        while( !stack.isEmpty() ) {
          characters.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for( Character ch: characters  ){
          sb.append(ch);
        }

        return sb.toString();
    }
  
}
