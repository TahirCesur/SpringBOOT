package day02_Volatile;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

public class BlockQueue {
    static public int counter = 1;
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
        Producer producer = new Producer(queue);
        Thread producerThread = new Thread(producer);
        producerThread.start();

        Consumer consumer = new Consumer(queue);
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
}
class Producer implements Runnable {
    private ArrayBlockingQueue<Integer> queue;
    //Constructor
    public Producer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    // Override Run()
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                queue.put(BlockQueue.counter);
                BlockQueue.counter++;
                System.out.println("counter value is put to the queue array: " + BlockQueue.counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private ArrayBlockingQueue<Integer> queue;
    // Constructor
    public Consumer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    // Override Run()
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                queue.take();
                BlockQueue.counter--;
                System.out.println("counter value is removed from the queue array: " + BlockQueue.counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}