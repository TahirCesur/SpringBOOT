package day02_Volatile;

public class WaitInterrupt {
    static public double balance = 0;
    public static void main(String[] args) {
        WaitNotify obj = new WaitNotify();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(800);
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                obj.deposit(2000);
                thread1.interrupt();
            }
        });
        thread2.start();

    }
    public void withdraw(double amount) {
        if (balance <= 0 || balance < amount) {
            try {
                System.out.println("Waiting for the balance to be updated");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        balance = balance - amount;
        System.out.println("Withdrawal is successful.\nThe current balance is: " + balance);
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("The balance is updated.\nThe current balance is: " + balance);
    }
}