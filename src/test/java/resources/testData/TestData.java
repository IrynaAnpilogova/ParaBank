package resources.testData;

import base.BasePage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestData extends BasePage {

    protected JSONObject validLogin;
    protected JSONObject invalidLogin;


    // constructor
    public TestData (WebDriver driver) {
        this.driver = driver;
    }

    // reading from json files
    // valid Login test data

    public  JSONObject validLoginTestData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader;

        try {
            reader = new FileReader("src/test/java/resources/testData/Login.json");
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            validLogin = (JSONObject) jsonObject.get("validLogin");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return validLogin;
    }

    // invalid Login test data

    public  JSONObject invalidLoginTestData() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader;

        try {
            reader = new FileReader("src/test/java/resources/testData/Login.json");
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            invalidLogin = (JSONObject) jsonObject.get("invalidLogin");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return invalidLogin;
    }
}
