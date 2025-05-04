package com.vikram.dsa.stack;

import java.util.Stack;

public class CreateMaximunNumber {

  public static void main( String[] args ) {
    CreateMaximunNumber createMaximunNumber  = new  CreateMaximunNumber();
    int[] num1 = {5,5,1};
    int[] num2 = {4,0,1};
    System.out.println( createMaximunNumber.maxNumber(num1, num2, 3));
  }


   public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for( int i = 1; i < k; i++ ) {
            int j = k - i;
            if( i > nums1.length || j > nums2.length ) {
              continue;
            }
            int[] number1 = lexicographyicallyLargestNumber( nums1, i );
            int[] number2 = lexicographyicallyLargestNumber( nums2, j );
            int[] mergedNumber = merge(number1, number2);
            ans = getMax( mergedNumber, ans );
        }
        
        return ans;
    }

    public int[] lexicographyicallyLargestNumber( int[] nums, int k ) {
        int[] ans = new int[k];
        Stack<Integer> stack = new Stack<>();
        for( int i = 0; i < nums.length; i++ ) {
            while( !stack.isEmpty() && stack.peek() < nums[i] && stack.size() + nums.length - i - 1 >= k ) {
                stack.pop();
            }
            if( stack.size() < k ) {
              stack.push(nums[i]);
            }
        }
        int index = k-1;
        while( !stack.isEmpty() && index > -1 ) {
            ans[index] = stack.pop();
            index--;
        }
        return ans;
    }

    public int[] getMax( int[] num1, int num2[] ) {
        for( int i = 0; i < num1.length; i++ ) {
            if( num1[i] < num2[i] ) {
                return num2;
            }
            else if( num2[i] < num1[i] ) {
                return num1;
            }
        }

        return num1;
    }

    public int[] merge( int[] number1, int[] number2 ){
        int[] ans = new int[number1.length + number2.length ];
        int p3 = 0;
        int p1 = 0;
        int p2 = 0;
        while( p1 < number1.length && p2 < number2.length ) {
            if( number1[p1] > number2[p2] ) {
                ans[p3] = number1[p1];
                p1++;
            }
            else if( number2[p2] > number1[p1] ) {
                ans[p3] = number2[p2];
                p2++;
            }
            else {
                int i = p1;
                int j = p2;
                boolean firstGreater = false;
                while( i < number1.length && j < number2.length ) {
                    if( number1[i] > number2[j] ) {
                        firstGreater = true;
                        break;
                    }
                    else if( number2[j] > number1[i] ) {
                        break;
                    }
                    i++;
                    j++;
                }
                if( firstGreater ) {
                  ans[p3] = number1[p1];
                    p1++;
                }
                else {
                  ans[p3] = number2[p2];
                    p2++;
                }
            }
            p3++;
        }

        while( p1 < number1.length ) {
            ans[p3] = number1[p1];
            p1++;
            p3++;
        }

         while( p2 < number2.length ) {
            ans[p3] = number2[p2];
            p2++;
            p3++;
        }

        return ans;
    }
  
}
