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

    public boolean containsMessage(String message) {
        return webDriver.findElement(By.id("message"))
                .getText()
                .contains(message);
    }


    @Override
    public void withdrawFrom(Account account, BigDecimal dollars) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        String buttonId = "withdraw" + dollars.stripTrailingZeros().toPlainString();
        webDriver.findElement(By.id(buttonId)).click();

    }
    public void checkBalance(Account account) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        webDriver.findElement(By.id("checkBalance")).click();
    }

}
