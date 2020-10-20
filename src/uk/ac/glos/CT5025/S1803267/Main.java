package uk.ac.glos.CT5025.S1803267;



public class Main {

  private Thread thread;

  public static void main (String[] args) {
    System.out.println("blah");
  }

  public synchronized void start() {
    Screen screen = new Screen();
    thread = new Thread(screen, "Display");
    thread.start();
  }

  public synchronized void stop() {
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
