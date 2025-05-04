package com.vikram.dsa.LinkedList;

import java.util.List;

public class ParitionList {

  public static void main( String[] args ) {
    ParitionList paritionList = new ParitionList();
    List<Integer> list = List.of(4,1,3, 2,5);
    ListNode head = new ListNode(list.get(0));
    ListNode t = head;
    for( int i = 1;  i < list.size(); i++ ) {
      t.next = new ListNode(list.get(i));
      t = t.next;
    }
    System.out.println(paritionList.partition(head, 6));
  }

  public ListNode partition(ListNode A, int B) {
        if( A == null || A.next == null ) {
           return A;
        }
        ListNode th = getGreatestSmallerElemenet(A, B);
        ListNode h2 = th == null ? A : th.next;
        if( B > h2.val ) {
            return A;
        }
        if( th != null ) {
          th.next = null;
        }
        ListNode t1 = h2;
        ListNode t2 = h2.next;

        while( t2 != null ) {
            if( t2.val < B) {
                t1.next = t2.next;
                if( th == null ) {
                  th = t2;
                  th.next = null;
                  A = th;
                }
                else {
                  th.next = t2;
                  th = th.next;
                  th.next = null;
                }
                t2 = t1.next;
            }
            else {
                t1 = t1.next;
                t2 = t2.next;
            }
        }
        if( th != null ){
          th.next = h2;
        }

        return A;
    }

    public ListNode getGreatestSmallerElemenet( ListNode h, int x ) {
        if( h.val >= x ) {
          return null;  
        }
        ListNode t = h;
        while( t != null && t.next != null && t.next.val < x ) {
            t = t.next;
        }
        return t;
    }
  
}
