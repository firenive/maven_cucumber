package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
