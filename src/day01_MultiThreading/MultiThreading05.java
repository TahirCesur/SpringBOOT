package day01_MultiThreading;

public class MultiThreading05 {

    public static void main(String[] args){

        Brackets3 obj5 = new Brackets3();
        Brackets3 obj6 = new Brackets3();

        Thread thread1 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                for(int i=1; i<=5; i++) {
                    obj5.generateBrackets();
                }
            }
        });
        thread1.start();

        // Eger join kullanacak olsaydik burda kullanmis olacaktik..
        // Nedeni ise ; Once tehread1 calisacak sonra 2. si calismis olacak...

        Thread thread2 = new Thread(new Runnable() {
            // new Runnable yapma sebebi otomatik olarak @Override getiriyor..
            @Override
            public void run() {
                for(int i=1; i<=5; i++){
                    obj6.generateBrackets();
                }
            }
        });
        thread2.start();
    }
}

class Brackets3 {
    synchronized static public void generateBrackets() {
        /*
        !!! synchronized static kullanmıs olduk...

        Eğer elimizde birden fazla obje varsa "syncronized" yalnız kullanilmaz.
        "syncronized static" ile kulanilir.
        Elde birden fazla obje varsa "join" methodunu da kullanabiliriz.
        Eğer methodun belirli bir kisminda senkronizasyon yapmak istersek "syncronized(this)" i kullaniriz.
        Son olarak, ne zaman "syncronized" veya "join" kullanirsak MultiThreading'i bozmus oluruz.
        Bu yüzden MultiThreading ve "Syncronized" & "join" kullanimi bir trade - off tur.
        Eger elimizde birden fazla obje varsa static ile kullanmazsak istedigimiz duzeni alamayiz...
        */

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