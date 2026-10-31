package support;

import com.google.inject.Singleton;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
@Singleton
public class MyWebDriver  {
    private final WebDriver driver;
    public  MyWebDriver() {
        driver = new FirefoxDriver();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void quit() {
        driver.quit();
    }
}
