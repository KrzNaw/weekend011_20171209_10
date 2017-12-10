
package pluralsight;

public class TxWorker implements Runnable {

    protected BankAccount account;
    protected char txType; // ‘w’ -> withdrawal, ‘d’ -> deposit
    protected int amt;

    public TxWorker(BankAccount account, char txType, int amt) {

    }

    @Override
    public void run() {
        if (txType == 'w')
        account.withdrawal(amt);
        if (txType == 'd')
        account.deposit(amt);
    }
}
