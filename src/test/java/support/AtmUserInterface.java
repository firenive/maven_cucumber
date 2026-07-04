package support;

import hooks.ServerHooks;
import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class AtmUserInterface implements Teller {
    private final WebDriver webDriver;
    public AtmUserInterface(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    @Override
    public void withdrawFrom(Account account, BigDecimal dollars) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        webDriver.findElement(By.id("amount")).sendKeys(dollars.toPlainString());
        webDriver.findElement(By.id("withdraw")).click();
    }

}
