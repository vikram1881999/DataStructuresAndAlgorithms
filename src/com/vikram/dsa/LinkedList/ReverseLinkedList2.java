package com.vikram.dsa.LinkedList;

import java.util.List;

public class ReverseLinkedList2 {

  public static void main(String[] args) {
    ReverseLinkedList2 linkedList2 = new ReverseLinkedList2();
    List<Integer> list = List.of(1,2,3);
    ListNode head = new ListNode(list.get(0));
    ListNode t = head;
   for( int i = 1;  i < list.size(); i++ ) {
    t.next = new ListNode(list.get(i));
    t = t.next;
   }
    System.out.println(linkedList2.reverseBetween(head, 1, 2));
  }


   public ListNode reverseBetween(ListNode A, int B, int C) {
        if( B == C || A == null ) {
            return A;
        }
        boolean inRange = false;
        ListNode h = A;
        ListNode t = null;
        int c = 1;
        while( h != null && c != B ) {
            t = h;
            h = h.next;
            c++;
        }

        ListNode nh = null;
        ListNode nt = null;
        ListNode h2 = A;
        ListNode t2 = null;
        if( t != null ) {
            h2 = t.next;
        }

        while( h2 != null && c <= C) {
            t2 = h2;
            h2 = h2.next;
            t2.next = nh;
            if( nh == null ) {
                nt = t2;
            }
            nh = t2;
            c++;
        }
        if( nt != null ) {
          nt.next = h2;
        }
        if( t == null ) {
            return nh;
        }
        t.next = nh;
        return A;
    }
  
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
