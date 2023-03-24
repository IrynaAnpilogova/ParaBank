package pages;

import base.BasePage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CustomerLoginPage extends BasePage {

    private String title = "ParaBank | Welcome | Online Banking";
    private static String URL = "https://parabank.parasoft.com/parabank/index.htm";


    // elements

    private By username = By.name("username");
    private By password = By.name("password");
    private By buttonLogin = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    private By linkRegister = By.linkText("Register");


    // constructor
    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // services
    public static CustomerLoginPage open(WebDriver driver) {
        driver.get(URL);
        return new CustomerLoginPage(driver);
    }

    //    validLogin
    public HomePage validLogin(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(buttonLogin).click();
        return new HomePage(driver);
    }
    // invalidLogin
    public LoginErrorPage invalidLogin(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(buttonLogin).click();
        return new LoginErrorPage(driver);
    }

    //click on Register button

    public RegisterPage clickOnRegisterLink() {
        driver.findElement(linkRegister).click();
        return new RegisterPage(driver);
    }










}
