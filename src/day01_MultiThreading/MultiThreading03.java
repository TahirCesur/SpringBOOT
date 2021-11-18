package day01_MultiThreading;

public class MultiThreading03 {

    public static void main(String[] args){

        Brackets obj1 = new Brackets();
        Brackets obj2 = new Brackets();

        Thread thread1 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                for(int i=1; i<=7; i++){
                    obj1.generateBrackets();
                }
            }
        });
        thread1.start();

        //=======================================================================================
        // Threadleri farkli objelerle kullandigimiz zaman syncronized kullanirsak
        // senkronizasyon problemi yasariz. Bu gibi durumlarda, join kullanmaliyiz.

        // Duzgun olarak istedigimiz sekilde olsun istiyorsak try catch ile join kullaniyoruz...
        // Not : Elimizde birden fazla obje oldugu icin 'synchronized' yeterli gelmedi..
        // 50. satirda synchronized keywordu istedigimizi vermedi...

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //=======================================================================================

        System.out.println("***************");

        Thread thread2 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                for(int i=1; i<=7; i++){
                    obj2.generateBrackets();
                }
            }
        });
        thread2.start();
    }
}
class Brackets {
    /*synchronized*/ public void generateBrackets() {
        // Elimizde birden fazla obje oldugu icin 'synchronized' yeterli gelmedi..
        // Bu yuzden 29. satir da join kullandik.
        for(int i=1; i<=10; i++) {
            if(i<=5) {
                System.out.print("[");
            }else {
                System.out.print("]");
            }
        }
        System.out.println();
    }
}