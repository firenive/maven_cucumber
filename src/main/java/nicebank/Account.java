package nicebank;

import java.math.BigDecimal;

public class Account {
    private TransactionQueue queue = new TransactionQueue();
    private BigDecimal balance;

    public void setBalance(BigDecimal amount) {
        this.balance = amount;

    }
    public void credit(BigDecimal amount) {
        queue.write("+" + amount.toString());
    }

    public void debit(BigDecimal amount) {
        queue.write("-" + amount.toString());
    }

    public Account() {
        this.balance = BigDecimal.ZERO;
    }



    public BigDecimal getBalance() {
        return BalanceStore.getBalance();
    }
}
