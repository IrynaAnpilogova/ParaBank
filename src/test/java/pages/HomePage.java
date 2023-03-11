package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class HomePage extends BasePage {



   // elements

    private By logOut = By.linkText("Log Out");
    private By title = By.className("title");

   // constructor

   public HomePage (WebDriver driver) {
       this.driver = driver;

   }


   // servises

    public CustomerLoginPage logOut() {
       driver.findElement(logOut).click();
       return new CustomerLoginPage(driver);
    }

    public String getLoginConfirmation() {

        return driver.findElement(title).getText();
    }


}
