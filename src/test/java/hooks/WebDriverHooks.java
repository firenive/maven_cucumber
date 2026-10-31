package hooks;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import support.MyWebDriver;
@ScenarioScoped
public class WebDriverHooks {
    private final MyWebDriver myWebDriver;

    @Inject
    public WebDriverHooks(MyWebDriver myWebDriver) {
        this.myWebDriver = myWebDriver;
    }
    @After
    public void finish(Scenario scenario) {
        WebDriver webDriver = myWebDriver.getDriver();
        try {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "screenshot");
        } catch (WebDriverException e) {
            System.err.println(e.getMessage());
        } finally {
            myWebDriver.quit();
        }
    }
}

