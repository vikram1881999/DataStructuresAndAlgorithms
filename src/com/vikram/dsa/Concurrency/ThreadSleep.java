package com.vikram.dsa.Concurrency;

public class ThreadSleep {

  public static class ThreadSleepExample implements Runnable {


    @Override
    public void run() {
      String threadName = Thread.currentThread().getName();
      System.out.println( "Konsa thread hai bhai => {}" + threadName);

      try {
        Thread.sleep(2000);
      }
      catch( InterruptedException exception ) {
        exception.printStackTrace();
      }
      System.out.println( "Konsa thread jag gaya hai bhai => {}" +  threadName);

    }

  }

  public static void main( String[] args ){
    ThreadSleepExample example = new ThreadSleepExample();
    Thread thread1 = new Thread(example, "Vikram Thread");
    Thread thread2 = new Thread( example, "Leena Thread");
    thread1.start();
    thread2.start();
  }
  
}
