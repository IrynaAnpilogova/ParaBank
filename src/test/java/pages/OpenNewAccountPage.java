package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends BasePage {

    // elements
    private By accountType = By.id("type");
    private By openNewAccountButton = By.className("button");
    private By getOpenNewAccountConfirmationTitle = By.className("title");

    // constructor
    public OpenNewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // services

    //open new account
    public void openNewAccount(String accountTypeValue) {
        WebElement dropDown = driver.findElement(accountType);
        Select s = new Select(dropDown);
        s.selectByValue(accountTypeValue);
        driver.findElement(openNewAccountButton).click();
    }

    //get account confirmation
    public String getOpenNewAccountConfirmation() {
        return driver.findElement(getOpenNewAccountConfirmationTitle).getText();
    }




}
