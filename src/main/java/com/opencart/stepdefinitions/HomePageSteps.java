package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);
    @Given("HomePage is displayed")
    public void homepageIsDisplayed() {
        driver.get("https://andreisecuqa.host/");
        System.out.println("The driver accessed the Home Page.");
    }

    @When("registerLink from Header is clicked")
    public void registerlinkFromHeaderIsClicked() {
        homePage.navigateToRegisterPageFromHeader();
        System.out.println("The register link has been accessed from Header Menu.");
    }
}
