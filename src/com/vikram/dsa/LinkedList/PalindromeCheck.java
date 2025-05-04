package com.vikram.dsa.LinkedList;

import java.util.List;

public class PalindromeCheck {


  public static void main( String[] args  ){
    List<Integer> list = List.of(1,2, 3, 3, 1);
    Node head = new Node(list.get(0));
    Node t = head;
    for( int i = 1;  i < list.size(); i++ ) {
      t.next = new Node(list.get(i));
      t = t.next;
    }
    PalindromeCheck palindromeCheck = new PalindromeCheck();
    System.out.println( palindromeCheck.checkPalindrome(head));
  } 

  public boolean checkPalindrome( Node h ) {
    if( h == null || h.next == null ) {
      return true;
    }
    Node m = getMid(h);
    Node nn = m.next;
    m.next = null;
    Node nh =  reverseLinkList(nn);
    while( nh != null && h != null ) {
      if( h.val != nh.val ) {
        return false;
      }
      nh = nh.next;
      h = h.next;
    }

    return true;
  }

  private Node reverseLinkList(Node h) {
    Node t = null;
    Node nh = null;
    while( h != null ) {
      t = h;
      h = h.next;
      t.next = nh;
      nh = t;
    }
    return nh;
  }

  private Node getMid( Node h ) {
    Node s = h;
    Node f = h;
    while( f.next != null && f.next.next != null ) {
      s = s.next;
      f = f.next.next;
    }

    return s;
  }
  
}

class Node {
  int val;
  Node next;
  public Node( int x ) {
    this.val = x;
    this.next = null;
  }
}
