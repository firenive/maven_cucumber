package nicebank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BalanceStore {
    private static String BALANCE_FILE_PATH = "./balance";

    public static void clear() {
        new File(BALANCE_FILE_PATH).delete();
        setBalance(BigDecimal.ZERO);
    }
    public static BigDecimal getBalance() {
        BigDecimal balance;
        File balanceFile = new File(BALANCE_FILE_PATH);
        try (Scanner scanner = new Scanner(balanceFile)) {
             balance = new BigDecimal(scanner.nextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return balance;
    }

    public static void setBalance (BigDecimal newBalance) {
        try (PrintWriter writer = new PrintWriter(BALANCE_FILE_PATH, StandardCharsets.UTF_8)) {
            writer.println(newBalance.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
