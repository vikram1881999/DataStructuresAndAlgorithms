package com.vikram.dsa.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  public static void main( String[] args  ){
    LRUCache cache = new LRUCache( 2 );
    cache.put(1,1);
    cache.put(2,2);
    System.out.println( cache.get(1));
    cache.put(3,3);
    System.out.println( cache.get(2));
    cache.put(4,4);
    System.out.println( cache.get(1));
    System.out.println( cache.get(3));
    System.out.println( cache.get(4));
  }

  Node head;
  Node tail;
  Map<Integer, Node> cache = new HashMap<>();
  int capacity;

  public LRUCache(int capacity) {
      head = new Node(-1, -1);
      tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
      this.capacity = capacity;
  }
  
  public int get(int key) {
      if( cache.containsKey(key) ) {
          return cache.get(key).val;
      }
      return -1;
  }
  
  public void put(int key, int value) {
      if( cache.size() < capacity ) {
          if( cache.containsKey(key) ) {
              remove( cache.get(key) );
              insertFromBack( value, key );
          }
          else {
              insertFromBack( value, key );
          }
      }
      else {
          if( cache.containsKey(key) ) {
              remove( cache.get(key) );
              insertFromBack( value, key );
          }
          else {
              remove( head.next );
              insertFromBack( value, key );
          }
      }
  }

  private void insertFromBack( int val, int key ) {
      Node nn = new Node(val, key);
      nn.prev = tail.prev;
      nn.next = tail;
      tail.prev.next = nn;
      tail.prev = nn;
      cache.put(key, nn);
  }

  private void remove( Node node ) {
      Node nn1 = node.prev;
      Node nn2 = node.next;
      nn2.prev = nn1;
      nn1.next = nn2;
      node.prev = null;
      node.next = null;
      cache.remove(node.key);
  }


  private class Node {
    Node prev;
    Node next;
    int val;
    int key;
    public Node( int val, int key ) {
        this.val = val;
        this.key = key;
    }
  }  
}