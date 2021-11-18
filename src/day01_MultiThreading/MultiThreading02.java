package day01_MultiThreading;

public class MultiThreading02 {

    // DERS NOTLARİ

    /*
     =========================================   SYNCHRONIZED  ===========================================
     Multi-threading calisma kosullarinda birden fazla thread'in aynı kaynaga
     (değişken metot, class, bellek vb) erişimi (okuma veya yazma) sırasında verinin güncellenmesi ve
     tutarlılığı ile ilgili sorunlar çıkabilir.
     Bu tutarsızlığı engellemek için synchronized keywordu kullanılabilir.
     Kısaca, Syncronization bir kaynağın tread'ler tarafından eş zamanlı kullanımına
     kapatılması(Lock) işlemidir.

     Synchronized keywordunun farklı kullanımları bulunmaktadır.

     1- Eğer bir metot "synronized" yapılırsa (Method-Level Syncronization) bu metota
     aynı andan birden fazla thread'inerişimine izin verilmez.

     2- Eğer bir metot yerine o metodun ait olduğu class'ı aynı anda birden fazla thread'in
     kullanımına kapatmak (class-level Syncronization) istersek o zaman "synchronized static" kullanmalıyız.

     3- Eğer bir metot içerisinde belirli bir kismin eş zamanlı thread kullanımına kapatılmasını
     ister isek o zaman "synchronized block" (block-level Syncronization) kullanmalıyız.

     */

    public static int counter = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                Counter.count();
                System.out.println("thread1 tamamlandi...");
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                Counter.count();
                System.out.println("thread2 tamamlandi...");
            }
        });
        thread2.start();
    }
}

class Counter { // Counter = Sayıcı
    synchronized public static void count() {
        // Elimizde bir obje oldugu icin (counter) 'synchronized' kullandik..
        for (int i = 1; i <= 1000; i++) {
            MultiThreading02.counter++;
        }
        System.out.println("Counter: " + MultiThreading02.counter);
    }
}