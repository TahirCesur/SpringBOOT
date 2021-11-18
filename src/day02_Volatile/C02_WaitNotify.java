package day02_Volatile;

public class C02_WaitNotify {

   /* ========================================= WAIT, NOTIFY =========================================
   Object.wait() metodu bir thread'i suresiz olarak askıya alir.
   Diğer bir ifade ile bu thread'in kilitlemiş (locked) olduğu bir kaynağı
   salıvermesini ve askıya geçmesini sağlar.
   Thread bu durumdan bir başka thread Onu bilgilendirirse (notify) çıkabilir.

   Object.notify() metodu ise aynı nesne üzerinde askıya alınan bir thread'in uyanmasini saglar.
   Object.notifyAll() metodu bir nesne üzerinde askıya alınan tum thread'lerin uyandirilmasini saglar.

   Bu metotlar, thread'ler arasi iletişim metodu olarak kullanılır.
   */

    public static double bakiye = 0;

    public static void main(String[] args) {

        C02_WaitNotify obj = new C02_WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                obj.paraCekme(800);
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                obj.paraYatirma(2000);
            }
        });
        thread2.start();

    }

    public void paraCekme(double miktar) {
        synchronized (this) {
            if (bakiye <= 0 || bakiye < miktar) {

                try {
                    System.out.println("Hesaba para yatirilmasi gerekiyor....");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        bakiye = bakiye - miktar;
        System.out.println("Para cekme basarili. \nGuncel Bakiyeniz : " + bakiye);
    }

    public void paraYatirma(double miktar) {
        bakiye = bakiye + miktar;
        System.out.println("Bakiyeniz Guncellendi. \nGuncel Bakiyeniz : " + bakiye);
        synchronized (this) {
            notify();
        }

    }
}