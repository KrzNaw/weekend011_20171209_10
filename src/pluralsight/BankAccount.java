package pluralsight;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccount {
    private int balance;


    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdrawal(int amount){
        balance -= amount;
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(100);

        for (int i = 0; i < 5; i++) {
            pluralsight.Worker worker = new pluralsight.Worker(account);
            es.submit(worker);
        }

        System.out.println(account.getBalance());

        //es.shutdown();
    }
}
