package day01_MultiThreading;

public class MultiThreading03 {

    public static void main(String[] args){

        Brackets obj1 = new Brackets();
        Brackets obj2 = new Brackets();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=7; i++){
                    obj1.generateBrackets();
                }
            }
        });
        thread1.start();

        //------------------------------------
        // Duzgun olarak istedigimiz sekilde olsun istiyorsak try catch ile jin kullaniyoruz

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //------------------------------------

        System.out.println("***************");

        Thread thread2 = new Thread(new Runnable() {
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