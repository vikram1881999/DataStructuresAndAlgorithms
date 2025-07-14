package com.vikram.dsa.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

  private static final class Node {
      int key, val, freq = 1;
      Node prev, next;
      Node(int k, int v) { key = k; val = v; }
  }

  private static final class DoublyLinkedList {
      private final Node head = new Node(-1, -1);
      private final Node tail = new Node(-1, -1);
      DoublyLinkedList() { head.next = tail; tail.prev = head; }

      void add(Node n) {
          n.next = tail;
          n.prev = tail.prev;
          tail.prev.next = n;
          tail.prev = n;
      }

      void remove(Node n) {
          n.prev.next = n.next;
          n.next.prev = n.prev;
      }

      Node removeLRU() {
          if (isEmpty()) return null;
          Node lru = head.next;
          remove(lru);
          return lru;
      }

      boolean isEmpty() { return head.next == tail; }
  }

  private final int capacity;
  private int size = 0;
  private int minFreq = 0;

  private final Map<Integer, Node> keyTable   = new HashMap<>();
  private final Map<Integer, DoublyLinkedList> freqTable = new HashMap<>();

  public LFUCache(int capacity) { 
    this.capacity = capacity; 
  }

  public int get(int key) {
      Node n = keyTable.get(key);
      if (n == null) return -1;
      touch(n);
      return n.val;
  }

  public void put(int key, int value) {
      if (capacity == 0) return;

      if (keyTable.containsKey(key)) {
          Node n = keyTable.get(key);
          n.val = value;
          touch(n);
          return;
      }

      if (size == capacity) evict();
      Node n = new Node(key, value);
      keyTable.put(key, n);
      freqTable.computeIfAbsent(1, k -> new DoublyLinkedList())
                .add(n);
      minFreq = 1;
      size++;
  }

  private void touch(Node n) {
      int oldFreq = n.freq;
      DoublyLinkedList oldList = freqTable.get(oldFreq);
      oldList.remove(n);
      if (oldList.isEmpty() && oldFreq == minFreq) {
          minFreq++;
      }

      n.freq++;
      freqTable.computeIfAbsent(n.freq, k -> new DoublyLinkedList())
               .add(n);
  }

  private void evict() {
      DoublyLinkedList minList = freqTable.get(minFreq);
      Node victim = minList.removeLRU();
      keyTable.remove(victim.key);
      size--;
  }
}