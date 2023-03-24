package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LoginErrorPage extends BasePage  {

    private String title = "ParaBank | Error";

    //elements

    private By error = By.xpath("//*[@id=\"rightPanel\"]/p");

    private By username = By.name("username");
    private By password = By.name("password");
    private By buttonLogin = By.className("button");
    private By linkRegister = By.linkText("Register");

    //constructor

    public LoginErrorPage(WebDriver driver) {
        this.driver = driver;


    }

    //services

    public HomePage validLogin(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(buttonLogin).click();
        return new HomePage(driver);
    }

    public String getLoginConfirmation() {

        return driver.findElement(error).getText();
    }






}
