package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import support.KnowsTheDomain;

public class WebDriverHooks {
    private final KnowsTheDomain helper;
    public WebDriverHooks(KnowsTheDomain helper) {
        this.helper = helper;
    }
    @After
    public void finish(Scenario scenario) {
        WebDriver webDriver = helper.getWebDriver();
        try {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "screenshot");
        } catch (WebDriverException e) {
            System.err.println(e.getMessage());
        } finally {
            webDriver.quit();
        }
    }
}

