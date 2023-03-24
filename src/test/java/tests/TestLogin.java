package tests;

import base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.LoginErrorPage;
import resources.testData.TestData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestLogin extends BaseTest {

    // constructor
    public TestLogin() throws IOException, ParseException {

    }

    @Description("Navigate to the page, login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testValidLogin() throws InterruptedException, IOException, ParseException {
        TestData data = new TestData(driver);
        HomePage homePage = CustomerLoginPage.open(driver)
                .validLogin(
                        (String) data.validLoginTestData().get("userName"),
                        (String) data.validLoginTestData().get("password")
                );


        Assertions.assertTrue(homePage.getLoginConfirmation().contains("Accounts Overview"));
    }
    @Description("Navigate to the page, login with invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testInvalidLogin() throws InterruptedException, IOException, ParseException { //  changes on the website
        TestData data = new TestData(driver);
        LoginErrorPage errorPage = CustomerLoginPage.open(driver)
                .invalidLogin(
                        (String) data.invalidLoginTestData().get("userName"),
                        (String) data.invalidLoginTestData().get("password")
                );
        Thread.sleep(5000);
        Assertions.assertTrue(errorPage.getLoginConfirmation().contains("Please enter a username and password."));
    }


}
