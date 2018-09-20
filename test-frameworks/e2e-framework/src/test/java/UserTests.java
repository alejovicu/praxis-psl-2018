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
        ApiManager.callBackendAPI("command=borrar&name=Chr&st&an");
        ApiManager.callBackendAPI("command=borrar&name= Camilo");
    }

    /*
    * TEMPLATE FOR MANUAL TEST CASE:
    * Objective: Check if create an user with the command cRear is possible
    * Scope: Create users using the UI
    *
    * Scenario: create an user with a capital letter in the command crear
    *   Given cRear "pepito" command
    *    When I send that command
    *    Then I expect an error message
    * */

    @Test
    public void addWithCL() throws IOException {
        //Arrange
        HomePO homePO = new HomePO(driver);
        homePO.goToHome();
        String user = "pepito";
        String command = "cRear " + user;
         //Act
        homePO.sendCommand(command);
         //Assert
        fail("Comando no valido: cRear");
    }

    /*
    * TEMPLATE FOR MANUAL TEST CASE:
    * Objective: Check if an user with special caracters is created
    * Scope: Create users using the UI
    *
    * Scenario: Create an user with special caracters
    *   Given the command crear "Chr&sti&an"
    *    When I send the command "mostrar"
    *    Then I expect to see "Chr&st&an" listed in the results
    * */

    @Test
    public void addUserWithSC() throws IOException {
        //Arrange
        HomePO homePO = new HomePO(driver);
        homePO.goToHome();
        String user = "Chr&st&an";
        String command = "crear " + user;

        //Act
        homePO.sendCommand(command);

        //Assert
        assertThat( ApiManager.callBackendAPI("command=mostrar"),
                containsString(user));
    }

    /*
    * TEMPLATE FOR MANUAL TEST CASE:
    * Objective: Check if an user with an space before the name is created
    * Scope: Create users using the UI
    *
    * Scenario: Create an user with an space before the name
    *   Given the command crear " Camilo"
    *    When I send the command "mostrar"
    *    Then I expect to see " Camilo" listed in the results
    * */

    @Test
    public void addUserWithSpace() throws IOException {
        //Arrange
        HomePO homePO = new HomePO(driver);
        homePO.goToHome();
        String user = " Camilo";
        String command = "crear " + user;

        //Act
        homePO.sendCommand(command);

        //Assert
        assertThat( ApiManager.callBackendAPI("command=mostrar"),
                containsString(user));
    }

    @Test
    public void addUser() throws IOException {
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


    /*
    * TEMPLATE FOR MANUAL TEST CASE:
    * Objective: Check if a user is displayed as expected
    * Scope: List users by UI
    *
    * Scenario: List an user
    *   Given the user "PraxisUser" exists
    *    When I send the command "mostrar"
    *    Then I expect to see the "PraxisUser" listed in the results
    * */
    @Test
    public void listAnUser() throws IOException {
        //Arrange
        HomePO homePO = new HomePO(driver);
        homePO.goToHome();
        String user = "PraxisUser";
        String command = "mostrar";

        // The user is created by api because user creation is not in the scope of this test
       ApiManager.callBackendAPI("command=crear&name="+user);

        //Act
        homePO.sendCommand(command);

        //Assert
        Assert.assertTrue(homePO.isNameListed(user));
    }




}
