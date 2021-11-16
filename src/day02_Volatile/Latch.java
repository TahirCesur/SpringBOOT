package day02_Volatile;

import java.util.concurrent.CountDownLatch;

public class Latch {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(6);
        ThreadCreator1 thread1 = new ThreadCreator1(latch);
        ThreadCreator1 thread2 = new ThreadCreator1(latch);
        ThreadCreator1 thread3 = new ThreadCreator1(latch);
        ThreadCreator1 thread4 = new ThreadCreator1(latch);
        ThreadCreator1 thread5 = new ThreadCreator1(latch);
        ThreadCreator1 thread6 = new ThreadCreator1(latch);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("Waiting for the latch to interrupt...");
        }
        System.out.println("All threads finished, now it is my turn");
    }
}
class ThreadCreator1 extends Thread {
    private CountDownLatch latch;
    // Constructor
    public ThreadCreator1(CountDownLatch latch) {
        this.latch = latch;
    }

    // Overriding Run()
    @Override
    public void run() {
        System.out.println("Thread is running " + Thread.currentThread().getName());
        System.out.println("Thread execution is completed " + Thread.currentThread().getName());
        System.out.println("=============================================");
    }
}