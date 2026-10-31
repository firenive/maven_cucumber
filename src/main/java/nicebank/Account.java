package nicebank;

import java.math.BigDecimal;
import org.javalite.activejdbc.Model;

public class Account extends Model {
    private TransactionQueue queue = new TransactionQueue();
    private BigDecimal balance;

    public void setBalance(BigDecimal amount) {
        setBigDecimal("balance", amount);
        saveIt();

    }
    public void credit(BigDecimal amount) {
        queue.write("+" + amount.toPlainString() + "," + getNumber());
    }

    public void debit(BigDecimal amount) {
        queue.write("-" + amount.toPlainString() + "," + getNumber());
    }
    public int getNumber() {
        return getInteger("number");
    }

    public Account() {
        this.balance = BigDecimal.ZERO;
    }

    public Account(int number) {
        setInteger("number", number);
        setString("balance", "0.00");
    }



    public BigDecimal getBalance() {
        refresh();
        return getBigDecimal("balance");
    }
}
