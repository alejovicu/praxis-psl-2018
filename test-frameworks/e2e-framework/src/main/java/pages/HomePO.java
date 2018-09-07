package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePO {

    private WebDriver driver;
    private WebDriverWait wait;
    private final int WAIT_TIMEOUT = 60;
    private final String homePageURL = "http://localhost:8080";

    // Page elements
    private final By commandInputSelector = By.id("txt-command");
    private final By commandButtonSelector = By.className("btn");
    private final By resultHeader = By.className("result-header");
    private final By resultRow = By.className("result-row");


    public HomePO( WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }


    // Page Actions
    public void goToHome() {
        driver.get(homePageURL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(commandInputSelector));
    }

    public void sendCommand(String command) {
        driver.findElement(commandInputSelector).sendKeys(command);
        driver.findElement(commandButtonSelector).click();
    }

    public boolean isNameListed(String name) {
        List <WebElement> results = driver.findElements(resultRow);

        for (WebElement result : results) {
            if (result.getText().equals(name))
                return true;
        }

        return false;
    }
}
