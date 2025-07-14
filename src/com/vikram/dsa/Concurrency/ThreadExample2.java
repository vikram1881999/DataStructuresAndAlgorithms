package com.vikram.dsa.Concurrency;

public class ThreadExample2 {

  public static class MyThread extends Thread {

    @Override
    public void run() {
      System.out.println("My thread runnig");
    }

  }
  public static void main( String[] args ) {
    MyThread myThread = new MyThread();
    myThread.start();
    
  }
  
}
