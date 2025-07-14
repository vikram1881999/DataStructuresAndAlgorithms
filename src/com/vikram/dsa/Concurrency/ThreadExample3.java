package com.vikram.dsa.Concurrency;

public class ThreadExample3 {
  
  public static class MyRunnable implements Runnable {

    @Override
    public void run() {
      System.out.println("Running thread");
    }
    
  }

  public static void main( String[] args ) {
    MyRunnable threadExample3 = new MyRunnable();
    Thread thread = new Thread(threadExample3);
    thread.run();
  }
}
