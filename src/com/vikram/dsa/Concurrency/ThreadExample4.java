package com.vikram.dsa.Concurrency;

public class ThreadExample4 {

  public static void main( String[] args ) {
    Runnable runnable  = new Runnable() {
      @Override
      public void run() {
        System.out.println("Vikram is running thread");
      }
    };

    Thread thread = new  Thread(runnable);
    thread.start();
  }
  
}
