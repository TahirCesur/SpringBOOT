package day02_Volatile;


public class C01_Volatile {

    // DERS NOTLARİ

    /*
    // Volatile durumunda thread'in objeye bagimliligi soz konusudur.

    ============================================= VOLATILE ============================================================
    Volatile keyword'u, Bir degiskenin farklı threadler tarafından kullanılırken degerinin degismesini
    saglamak icin kullanılmaktadir. Aynı zamanda bir class'ı thread-safe yapmak icin de kullanılır.
    Yani diger bir degisle, bir class ya da nesneyi farklı thread'lerin es zamanlı olarak problemin
    kullanımına olanak saglar.

    Volatile keywordu sadece degiskenler ile (primitif veya non-primitif) kullanılabilir.
    Nesne ve Class'lara konulmaz...

    Volatile keywordu kullanılan bir degiskenin degeri cache bellege saklanmaz.
    Her defasında ilgili class'ın bellegi (MAIN MEMORY) den okunur.
    Dolayısıyla farklı thread'ler degiskeni guncellese de her defasında en guncel deger okunmus olur.
    !!!! Bu özellikleri sayesinde Syncronization yönteminin daha iyi bir alternatifi olarak düşünülebilir.
    */

    volatile public static int flag = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                while (true) {
                    if (flag == 0) {
                        System.out.println("thread1 calisir durumda...");
                    } else {
                        break;
                    }
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = 1;
                System.out.println("flag variable inin degeri guncellendi");
            }
        });
        thread2.start();
    }
}