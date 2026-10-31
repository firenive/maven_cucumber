package nicebank;

import org.javalite.activejdbc.Base;

import java.math.BigDecimal;

public class TransactionProcessor {
    private TransactionQueue queue = new TransactionQueue();

    public void process() {
        if (!Base.hasConnection()) {
            Base.open("com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/bank",
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASSWORD"));
        }
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String message = queue.read();
                if (message.isEmpty()) {
                    Thread.sleep(100);
                    continue;
                }
                processMessage(message);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private void processMessage(String message) {
        String[] parts = message.split(",", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException(
                    "Incorrect transaction message: " + message
            );
        }
        BigDecimal transactionAmount = new BigDecimal(parts[0]);
        int accountNumber = Integer.parseInt(parts[1]);
        Account account = Account.findFirst(
                "number = ?", accountNumber);
        if (account == null) {
            throw  new IllegalStateException("Account not found: " + accountNumber);
        }
        BigDecimal newBalance = account.getBalance().add(transactionAmount);
        account.setBalance(newBalance);
    }
}
