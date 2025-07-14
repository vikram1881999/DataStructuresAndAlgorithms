package com.vikram.dsa.Concurrency;

public class ThreadExample5 {

  public static void main( String[] args ) {
    Runnable runnable = () -> {
      System.out.println("Vikram ERunning  lambda expression runnable");
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName);
    };
    Thread thread = new Thread(runnable, "Topa Thread");
    thread.start();

    Thread thread2 = new Thread(runnable, "Topa Thread 2");
    thread2.start();
  }
  
}
