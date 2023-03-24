package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

   // elements

    private By logOut = By.linkText("Log Out");
    private By title = By.className("title");

   // constructor

   public HomePage (WebDriver driver) {
       this.driver = driver;

   }


   // services

    //logout
    public CustomerLoginPage logOut() {
       driver.findElement(logOut).click();
       return new CustomerLoginPage(driver);
    }
    //get login confirmation
    public String getLoginConfirmation() {
        return driver.findElement(title).getText();
    }

    // click on Open Account link
    public OpenNewAccountPage clickOpenNewAccountLink() {
        driver.findElement(By.linkText("Open New Account")).click();
        return new OpenNewAccountPage(driver);
    }



}
