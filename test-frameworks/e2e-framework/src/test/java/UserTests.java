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
    
    
    /*
     * TEMPLATE FOR MANUAL TEST CASE:
     * Objective: Check if an empty user is not created as undefined.
     * Scope: List users by UI
     *
     * Scenario: List an empty user
     *   Given the command "crear" is send
     *    When I send the command "mostrar"
     *    Then I expect to see an error message or the user is not listed as undefined.
     * */
    @Test
    public void createEmptyUser() throws IOException{
    	//Arrange
        HomePO homePO = new HomePO(driver);
        homePO.goToHome();
        String command = "mostrar";
        String commandCrear = "crear";

        homePO.sendCommand(commandCrear);

        homePO.sendCommand(command);

        Assert.assertTrue(!homePO.isNameListed("undefined"));
    }
    
    /*
     * TEMPLATE FOR MANUAL TEST CASE:
     * Objective: Check if a user is deleted as expected
     * Scope: Delete users by UI
     *
     * Scenario: List an user
     *   Given the user "Jerson" exists
     *    When I send the command "borrar Jerson"
     *    Then I expect to not to see the name Jerson in the list anymore
     * */
    @Test
    public void deleteUserByUI() throws IOException{
    	//Arrange
        HomePO homePO = new HomePO(driver);
        homePO.goToHome();
        String user = "Jerson";
        String command = "mostrar";
        String commandBorrar = "borrar "+user;
        
        //Create a user
        ApiManager.callBackendAPI("command=crear&name="+user);

        //Delete a user
        homePO.sendCommand(commandBorrar);

        
        homePO.sendCommand(command);

        //User should not appear anymore.
        Assert.assertTrue(!homePO.isNameListed(user));
    }
}
