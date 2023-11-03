package com.opencart.stepdefinitions;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);
    @When("the register form is populated with valid random data")
    public void theRegisterFormIsPopulatedWithValidRandomData() {
        String firstNameInput = DataFakerManager.generateFakeFirstName();
        System.out.println(firstNameInput);

        String lastNameInput = DataFakerManager.generateFakeLastName();
        System.out.println(lastNameInput);

        String emailInput = DataFakerManager.generateFakeEmail();
        System.out.println(emailInput);

        String passwordInput = DataFakerManager.generateFakePassword();
        System.out.println(passwordInput);

        registerPage.fillInTheRegisterForm(firstNameInput, lastNameInput, emailInput, passwordInput, true);
        System.out.println("The Register form is populated with valid random data.");
    }

    @And("Continue button is clicked")
    public void continueButtonIsClicked() {

        registerPage.clickTheContinueBtn();
        System.out.println("The continue button has been clicked.");
    }
}
