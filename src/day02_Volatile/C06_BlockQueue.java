package day02_Volatile;

import java.util.concurrent.ArrayBlockingQueue;

 public class C06_BlockQueue {
    /*
    ============================================= ARRAYBLOCKINGQUEUE ============================================
    ArrayBlockingQueue aslinda bir Collection'dır.
    Queue'nun bir kapasitesi bulunmaktadir ve bu kapasite bir kere belirlendi mi runtime'da değiştirilemez.
    Bu Queue'nun en büyük özelliği, queue doluyken yeni bir veri eklemeyi
    ve queue bos iken veri cikarmayi engellemesidir.
    Queue'nun calismasi LIFO mantığına goredir. Son giren ilk cikar...
    Elimizdeki verileri duzgun bi sekilde gondermeyi saglar...
    Mesela gonderilecek mesajlarin kuyrukta beklenip sirasiyla gonderilmesini saglar...
    */

    static public int counter =1;

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
 class Producer implements Runnable{ // Uretici

    private ArrayBlockingQueue<Integer> queue;

    // Constructor
    public Producer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                queue.put(C06_BlockQueue.counter);
                System.out.println("counter degeri query array'ini: " + C06_BlockQueue.counter);
                C06_BlockQueue.counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 }


 class Consumer implements Runnable{
    private ArrayBlockingQueue<Integer> queue;
    // Constructor
    public Consumer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                queue.take();
                C06_BlockQueue.counter--;
                System.out.println("Counter degerimiz queue array'inden azaltildi: " + C06_BlockQueue.counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}