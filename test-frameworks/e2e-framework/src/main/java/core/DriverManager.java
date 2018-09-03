package core;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

  public static WebDriver getDriver() {
     WebDriverManager.getInstance(CHROME).setup();
     return new ChromeDriver();
   }
}
