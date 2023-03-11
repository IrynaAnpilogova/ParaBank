package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.LoginErrorPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestLogin extends BaseTest {

    // constructor
    public TestLogin() throws IOException, ParseException {
    }

    //
    JSONParser parser = new JSONParser();
    FileReader reader;

    {
        try {
            reader = new FileReader("src/test/java/resources/testData/Login.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    JSONObject jsonObject = (JSONObject) parser.parse(reader);
    JSONObject validLogin = (JSONObject) jsonObject.get("validLogin");
    JSONObject invalidLogin = (JSONObject) jsonObject.get("invalidLogin");




    @Test
    void testValidLogin() throws InterruptedException {

        HomePage homePage = CustomerLoginPage.open(driver)
                .validLogin(
                        (String) validLogin.get("userName"),
                        (String) validLogin.get("password")
                );


        Assertions.assertTrue(homePage.getLoginConfirmation().contains("Accounts Overview"));
    }

    @Test
    void testInvalidLogin() { // does not work, mistake on the website
        LoginErrorPage errorPage = CustomerLoginPage.open(driver)
                .invalidLogin(
                        (String) invalidLogin.get("userName"),
                        (String) invalidLogin.get("password")
                );

        Assertions.assertTrue(errorPage.getLoginConfirmation().contains("The username and password could not be verified."));
    }





}
