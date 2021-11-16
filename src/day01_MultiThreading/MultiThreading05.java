package day01_MultiThreading;

public class MultiThreading05 {

    public static void main(String[] args){
        Brackets3 obj1 = new Brackets3();
        Brackets3 obj2 = new Brackets3();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=5; i++) {
                    obj1.generateBrackets();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=5; i++){
                    obj2.generateBrackets();
                }
            }
        });
        thread2.start();
    }
}

class Brackets3 {
    synchronized static public void generateBrackets() {
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