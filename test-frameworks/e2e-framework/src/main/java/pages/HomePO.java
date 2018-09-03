package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePO {

    private WebDriver driver;
    private WebDriverWait wait;
    private final int WAIT_TIMEOUT = 60;
    private final String homePageURL = "http://localhost:8080";

    // Page elements
    private final By commandInputSelector = By.id("txt-command");
    private final By commandButtonSelector = By.className("btn");

    public HomePO( WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }


    // Page Actions
    public void goToHome() throws InterruptedException {
        driver.get(homePageURL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(commandInputSelector));
    }

    public void sendCommand(String command) {
        driver.findElement(commandInputSelector).sendKeys(command);
        driver.findElement(commandButtonSelector).click();
    }
}
