package core;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getNewDriver() {
        WebDriverManager.getInstance(CHROME).setup();
        return new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getNewDriver();
        }
        return driver;
    }
}
