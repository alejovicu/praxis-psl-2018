import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import core.ApiManager;
import pages.HomePO;
import core.DriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class UserCreationTests {

    private static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        driver = DriverManager.getDriver();
    }

    @After
    public void teardown() throws IOException {
        if (driver != null) {
            driver.quit();
        }
        ApiManager.callBackendAPI("command=borrar&name=Alejandro-Test1");
    }

    @Test
    public void addUser() throws IOException, InterruptedException {
        //Arrange
        HomePO homePO = new HomePO(driver);
        homePO.goToHome();
        String user = "Alejandro-Test1";
        String command = "crear " + user;

        //Act
        homePO.sendCommand(command);

        //Assert
        assertThat( ApiManager.callBackendAPI("command=mostrar"),
                containsString(user));
    }
}
