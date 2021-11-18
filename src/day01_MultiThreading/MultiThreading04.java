package day01_MultiThreading;

public class MultiThreading04 {

    public static void main(String[] args){

        Brackets2 obj3 = new Brackets2();
        Brackets2 obj4 = new Brackets2();

        Thread thread1 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                for(int i=1; i<=7; i++) {
                    obj3.generateBrackets();
                }
            }
        });
        thread1.start();

        System.out.println("***************");

        Thread thread2 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                for(int i=1; i<=7; i++){
                    obj4.generateBrackets();
                }
            }
        });
        thread2.start();
    }
}

class Brackets2 {
    public void generateBrackets() {
        synchronized (this) {
            // Eğer methodun belirli bir kisminda senkronizasyon
            // yapmak istersek "syncronized(this)" i kullaniriz.
            for (int i = 1; i <= 10; i++) {
                if (i <= 5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
        }

        System.out.println();

        for(int i=1; i<=10; i++) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}