import static org.junit.Assert.*;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import pages.HomePO;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;;
import org.junit.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class UserCreationTests {

    public WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void addUser() {
        HomePO homePO = new HomePO(driver);
        homePO.goToHome();
        assertTrue("A dummy assert", true);
    }
}
