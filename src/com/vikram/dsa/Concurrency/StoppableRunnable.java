package com.vikram.dsa.Concurrency;

public class StoppableRunnable {

  public static class StoppableRunnableThread implements Runnable {

    private boolean stopRequested = false;

    public synchronized void requestStop() {
      this.stopRequested = true;
    }

    public synchronized boolean isStopRequested() {
      return this.stopRequested;
    }

    private void sleep( long millis ) {
      try {
        Thread.sleep(millis);
      } catch ( InterruptedException exception  ) {
        exception.printStackTrace();
      }
    }

    @Override
    public void run() {
      System.out.println( "Stoppable Runnable Running");
      while( !isStopRequested() ) {
        sleep(1000);
        System.out.println("...");
      } 
      System.out.println("Stoppable Runnble Stoped");
    }

  }

  public static void main( String[] args ) {
    StoppableRunnableThread runnable = new StoppableRunnableThread();
    Thread thread = new Thread(runnable, "Thre  Thread");
    thread.start();

    try {
      Thread.sleep(5000);
    }catch( Exception e  ){
      e.printStackTrace();
    }

    System.out.println("Requesting stop");
    runnable.requestStop();
    System.out.println("stop requested");
  }
  
}
