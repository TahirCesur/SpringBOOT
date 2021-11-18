package day01_MultiThreading;

public class MultiThreading01 {

    // DERS NOTLARİ

    /*
    ============================================ THREAD, PROCESS==========================================
    Thread : Kelime manası iplik olmasına karsin IT alaninda is parcacigi olarak adlandirilir.
    Thread, Process olarak adlandirilan ve her bir calısan programın alt is parcacigi olarak dusunulebilir.
    Kısaca Thread (iş parçacığı) kullanımı, birden fazla işlemin tek bir akışı paylaşarak
    neredeyse eşzamanlı bir şekilde gerçekleşmesini sağlar.

    Single-Thread: Tek is parcacigi vardır. Ve tüm işler sira ile yapilir.

    Multi-Thread: Bir den fazla is parcacigi vardir ve bu isler ayni anda yapilabilir
    (farklı işlemciler yardımıyla)....

    Single Thread ile MultiThread Modellerinin Karşılaştırılması

    Single Thread:

    Bu tür programlamada bir seferde tek bir iş parçacığı çalışır.
    Tek iş parçacıklı model, sorgulamalı bir süreç olay döngüsü kullanır.
    CPU zamanı boşa harcanır. Boşta kalma süresi daha fazladır.
    Daha az verimli programlarla sonuçlanır.
    Bir iş parçacığı duraklatıldığında, sistem bu iş parçacığı devam ettirilene kadar bekler.

    Multi Thread:

    Bu tür programlamada birden çok iş parçacığı aynı anda çalışır.
    Çok iş parçacıklı model, sorgulamalı olay döngüsü kullanmaz.
    CPU zamanı asla boşa harcanmaz. Boşta kalma süresi minimumdur.
    Daha verimli programlarla sonuçlanır.
    Herhangi bir nedenle bir iş parçacığı duraklatıldığında, diğer iş parçacıkları normal şekilde çalışır.


    Javada 2 yöntem ile Thread olusturmak mumkundur.
    ----------------------------------------------
    1- Thread classından bir class extends (tureterek)
    2- Runnable Interface'inden implements ederek.

    Thread class'inin yaygin kullanilan metotlari:
    -----------------------------------------------
    public void run(): Bir threat'in calistiracagi islemleri tanimlamak amaciyla kullanilir.
    public void start(): Bir thread'in baslatilmasini saglar.JVM, thread'in run() methodunu calistirir.
    public void sleep(long miliseconds): Bir thread'in belirtilen sure (ms) boyunca bekletilmesini saglar.
    public void join(): Bir thread olmesini (bitmesi) beklemek icin kullanilir.
    public int getPriority(): Bir thread'in onceligini dondurur.
    public int setPriority(int priority): Bir thread icin oncelik ayarlamaya yarar.
    public String getName(): Bir thread'in adini dondurur.
    public void setName(String name): Bir thread'e isim vermeye yarar.
    public Thread currentThread(): Su an calisan thread'in referansini dondurur.
    public int getId(): Bir thread'in id numarasini dondurur.
    public Thread.State getState(): Bir thread'in state (durum)'ini dondurur.
    public boolean isAlive(): Bir thread'in canlı (alive) olup olmadigini soyler.
    public void yield(): Aktif olan bir thread'in gecici olarak durdurulmasini ve
    baska thread'lerin calistirilmasini saglar.
    public boolean isDaemon(): Bir thread'in Deamon threat lup olmadıgını test eder.
    public void setDaemon(boolean b): Bir thread'i deoman thread olarak isaretler.
    public void interrupt(): Thread kesintiye ugratır.
    public boolean isInterrupted(): Bir thread'in kesilip kesilmedigini test eder.
 */

    public static void main(String[] args) throws InterruptedException {

        // MultiThreading Olmadan
        long StartingTime00 = System.currentTimeMillis();
        CounterWithoutMultiThread obj1 = new CounterWithoutMultiThread(1);
        obj1.countMe();
        System.out.println("==================================");
        CounterWithoutMultiThread obj2 = new CounterWithoutMultiThread(2);
        obj2.countMe();
        long EndingTime00 = System.currentTimeMillis();
        System.out.println("MultiThreading olmadan zaman farkı: " +(EndingTime00 - StartingTime00));

        // MultiThreading ile
        long StartingTime01 = System.currentTimeMillis();
        CounterWithMultiThread obj3 = new CounterWithMultiThread(3);
        obj3.start();
        System.out.println("==================================");
        CounterWithMultiThread obj4 = new CounterWithMultiThread(4);
        obj4.start();
        //Thread.sleep(5000);
        obj4.join();
        long EndingTime01 = System.currentTimeMillis();
        System.out.println("MultiThreading ile zaman farkı: " +(EndingTime01 - StartingTime01));

    }
}

class CounterWithoutMultiThread{
    private int threadNum;

    // Constructor
    public CounterWithoutMultiThread(int threadNum) { // MultiThreading Olmadan Saymak
        this.threadNum = threadNum;
    }
    public void countMe() {
        for(int i=1; i<=9; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i: " + i + "Thread Number: " + threadNum);
        }
    }

}


class CounterWithMultiThread extends Thread { // MultiThreading ile Saymak
    private int threadNum;

    // Constructor
    public CounterWithMultiThread(int threadNum) { // MultiThreading Olmadan Saymak
        this.threadNum = threadNum;

    }

    @Override
    public void run() {
        countMe();
    }
    public void countMe() {
        for (int i = 1; i <= 9; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i: " + i + "Thread Number: " + threadNum);
        }
    }

}