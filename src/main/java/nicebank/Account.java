package nicebank;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public void setBalance(BigDecimal amount) {
        this.balance = amount;

    }
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public Account() {
        this.balance = BigDecimal.ZERO;
    }



    public BigDecimal getBalance() {
        return balance;
    }
}
