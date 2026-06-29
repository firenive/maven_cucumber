package nicebank.support;

import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.math.BigDecimal;

public class AtmUserInterface implements Teller {
    private final WebDriver webDriver;
    public AtmUserInterface() {
        this.webDriver = new FirefoxDriver();
    }


    @Override
    public void withdrawFrom(Account account, BigDecimal dollars) {
        try {
            webDriver.get("http://localhost:9988");
            webDriver.findElement(By.id("Amount")).sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("Withdraw")).click();
        } finally {
            webDriver.quit();
        }

    }

}
