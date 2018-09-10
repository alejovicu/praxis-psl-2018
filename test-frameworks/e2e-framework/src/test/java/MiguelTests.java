import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import core.ApiManager;
import org.junit.Assert;
import pages.HomePO;
import core.DriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class UserTests {

    private static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        driver = DriverManager.getDriver();
    }

    @AfterClass
    public static void teardown() throws IOException {
        if (driver != null) {
            driver.quit();
        }

        //clear
        ApiManager.callBackendAPI("command=borrar&name=Alejandro-Test1");
        ApiManager.callBackendAPI("command=borrar&name=PraxisUser");
    }
    
     /*
    * TEMPLATE FOR MANUAL TEST CASE:
    * Objective: Check if a user is deleted as expected
    * Scope: Delete users using the UI
    *
    * Scenario: List an user
    *   Given the user "PraxisUser" exists
    *    When I send the command "delete"
    *    Then I expect not to see the "PraxisUser" listed in the results
    * */
    @Test
    public void deleteUser() throws IOException {
        //Arrange
        HomePO homePO = new HomePO(driver);
        homePO.goToHome();
        String user = "Alejandro-Test1";
        String command = "delete " + user;

        //Act
        homePO.sendCommand(command);

        //Assert
        assertFalse( ApiManager.callBackendAPI("command=mostrar"),
                containsString(user));
    }


}
