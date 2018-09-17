import java.io.Console;

public class BankAccount {
    private int accountNumber;
    private int balance;

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setbalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void credit(int sum) {
        balance += sum;
    }

    public void debit(int sum) {
        if (balance >= sum) {
            balance -= sum;
        } else {
            System.out.println("Сумма снятия больше чем остаок на счету!");
        }
    }
}
