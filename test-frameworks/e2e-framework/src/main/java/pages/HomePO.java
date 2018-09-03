package pages;

import org.openqa.selenium.WebDriver;

public class HomePO {

   private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHome() {
        System.out.println("hi");
    }
}
