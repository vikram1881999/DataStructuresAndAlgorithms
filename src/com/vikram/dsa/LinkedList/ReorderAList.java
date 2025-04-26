package com.vikram.dsa.LinkedList;

import java.util.List;

public class ReorderAList {

  public static void main( String[] args ) {
    ReorderAList reorderAList = new ReorderAList();
     List<Integer> list = List.of(1,2);
    ListNode head = new ListNode(list.get(0));
    ListNode t = head;
    for( int i = 1;  i < list.size(); i++ ) {
    t.next = new ListNode(list.get(i));
    t = t.next;
    }
    System.out.println( reorderAList.reorderList(head) );
  }

   public ListNode reorderList(ListNode A) {
        ListNode mid = getMid(A);
        if( mid == null ) {
            return A;
        }
        ListNode nn = mid.next;
        mid.next = null;
        ListNode nh = reverseList(nn);
        ListNode t1 = A;
        ListNode t2 = nh;
        ListNode t3 = null;
        while( t1 != null && t2 != null ) {
            t3 = t2.next;
            t2.next = t1.next;
            t1.next = t2;
            t1 = t2.next;
            t2 = t3;
        }

        return A;
    }

    private ListNode getMid(ListNode A ) {
        if( A == null || A.next == null ) {
            return null;
        }
        ListNode s = A.next;
        ListNode f = A.next.next;
        while( f!= null && f.next != null ) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    private ListNode reverseList( ListNode  A ) {
        if( A == null ) {
            return A;
        }
        ListNode h = A;
        ListNode nh = null;
        ListNode t = null;
        while( h != null ) {
            t = h;
            h = h.next;
            t.next = nh;
            nh = t;
        }

        return nh;
    }
}
