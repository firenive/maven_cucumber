package support;

import com.google.inject.Inject;
import hooks.ServerHooks;
import io.cucumber.guice.ScenarioScoped;
import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
@ScenarioScoped
public class AtmUserInterface implements Teller {
    private final WebDriver webDriver;
    @Inject
    public AtmUserInterface(MyWebDriver myWebDriver) {
        this.webDriver = myWebDriver.getDriver();
    }


    @Override
    public void withdrawFrom(Account account, BigDecimal dollars) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        webDriver.findElement(By.id("amount")).sendKeys(dollars.toPlainString());
        webDriver.findElement(By.id("withdraw")).click();
    }

}
