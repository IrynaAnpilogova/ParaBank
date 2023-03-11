package tests;

import base.BaseTest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.RegisterPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestRegistration extends BaseTest {

    // constructor

    public TestRegistration () throws IOException, ParseException {

    }

    JSONParser parser = new JSONParser();
    FileReader reader = new FileReader("src/test/java/resources/testData/Registration.json");

    JSONObject jsonObject = (JSONObject) parser.parse(reader);


    @Test
    void testValidRegistration() throws InterruptedException {
        HomePage homePage = CustomerLoginPage.open(driver)
                .clickOnRegisterLink()
                .validRegistration(
                        (String) jsonObject.get("customer_firstName"),
                        (String) jsonObject.get("customer_lastName"),
                        (String) jsonObject.get("customer_address_street"),
                        (String) jsonObject.get("customer_address_city"),
                        (String) jsonObject.get("customer_address_state"),
                        (String) jsonObject.get("customer_address_zipCode"),
                        (String) jsonObject.get("customer_phoneNumber"),
                        (String) jsonObject.get("customer_ssn"),
                        (String) jsonObject.get("customer_username"),
                        (String) jsonObject.get("customer_password"),
                        (String) jsonObject.get("repeatedPassword")
                )
                .submitRegistration();

        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1")).getText().contains("Welcome"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1")).getText().contains((String) jsonObject.get("customer_username")));

    }



}
