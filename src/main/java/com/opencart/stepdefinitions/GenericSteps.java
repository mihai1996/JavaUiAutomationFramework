package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    @Then("the current url contains {string} keyword")
    public void theCurrentUrlContainsKeyword(String keywordFromTheUrl) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String currentUrl = driver.getCurrentUrl();
        boolean currentUrlContainsKeyword = currentUrl.contains(keywordFromTheUrl);
        Assertions.assertTrue(currentUrlContainsKeyword, "The keyword: " + keywordFromTheUrl + " is present in " + currentUrl);
        System.out.println("The Step number 3 prints the keyword: " + keywordFromTheUrl);
    }

    @Given("{string} end point is accessed")
    public void endPointIsAccessed(String endPointValue) {

        driver.get("https://andreisecuqa.host" + endPointValue);
    }
}
