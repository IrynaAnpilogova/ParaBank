package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.OpenNewAccountPage;
import resources.testData.TestData;
import java.io.IOException;

public class TestAccountActions extends BaseTest {


    @Description("Login with valid credentials and open new account")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testOpenNewAccount() throws InterruptedException, IOException, ParseException {

        TestData data = new TestData(driver);

        HomePage homePage = CustomerLoginPage.open(driver)
                .validLogin(
                        (String) data.validLoginTestData().get("userName"),
                        (String) data.validLoginTestData().get("password")
                );

        homePage.clickOpenNewAccountLink();
        OpenNewAccountPage open = new OpenNewAccountPage(driver);
        open.openNewAccount("0");

        Assertions.assertTrue(open.getOpenNewAccountConfirmation().contains("Accounts Opened!"));

    }


}
