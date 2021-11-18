package day02_Volatile;

public class C03_WaitInterrupt {

    static public double bakiye = 0;
    public static void main(String[] args) {

        C03_WaitInterrupt obj = new C03_WaitInterrupt();

        Thread thread1 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                obj.paraCekme(800);
            }
        });
        // thread1.setName("thread1");
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
                obj.paraYatirma(2000);
                thread1.interrupt();
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