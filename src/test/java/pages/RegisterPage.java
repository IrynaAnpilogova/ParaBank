package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private String title = "Signing up is easy!";


    //constructor
    public RegisterPage(WebDriver driver) {

        this.driver = driver;



    }


    //elements
    private By customerFirstName = By.id("customer.firstName");
    private By custimerLastName = By.id("customer.lastName");
    private By customerAddress = By.id("customer.address.street");
    private By customerCity = By.id("customer.address.city");
    private By customerState = By.id("customer.address.state");
    private By customerZipCode = By.id("customer.address.zipCode");
    private By custimerPhoneNumber = By.id("customer.phoneNumber");
    private By customerSSN = By.id("customer.ssn");
    private By customerUserName = By.id("customer.username");
    private By customerPassword= By.id("customer.password");
    private By customerPasswordConfirmation = By.id("repeatedPassword");

    private By submitRegister = By.xpath("//input[@value='Register']");




    public RegisterPage validRegistration (String name, String lastName, String address,
                                           String city, String state, String zip,
                                           String phone, String ssn, String userName,
                                           String password, String repeatedPassword) {

        driver.findElement(customerFirstName).sendKeys(name);
        driver.findElement(custimerLastName).sendKeys(lastName);
        driver.findElement(customerAddress).sendKeys(address);
        driver.findElement(customerCity).sendKeys(city);
        driver.findElement(customerState).sendKeys(state);
        driver.findElement(customerZipCode).sendKeys(zip);
        driver.findElement(custimerPhoneNumber).sendKeys(phone);
        driver.findElement(customerSSN).sendKeys(ssn);
        driver.findElement(customerUserName).sendKeys(userName);
        driver.findElement(customerPassword).sendKeys(password);
        driver.findElement(customerPasswordConfirmation).sendKeys(repeatedPassword);

//        driver.findElement(submitRegister).click();

        return this;
    }

    public HomePage submitRegistration() {
        driver.findElement(submitRegister).click();
        return new HomePage(driver);
    }









}
