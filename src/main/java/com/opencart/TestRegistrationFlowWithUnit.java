package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRegistrationFlowWithUnit {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeAll
    public static void executeThisMethodBeforeAllTheTests() {
        System.out.println("The execution of the test suit has started.");
    }

    @AfterAll
    public static void executeThisMethodAfterAllTests() {
        System.out.println("The execution of the test suit has finished.");
    }

    @BeforeEach
    public void executeTheCodeBeforeEachTest() {
        System.out.println("The code is executed before each test case.");
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.navigateToRegisterPageFromHeader();
    }

    @AfterEach
    public void executeTheCodeAfterEachTest() {
        DriverManager.getInstance().tearDown();
        System.out.println("The code is executed after each test case.");
    }

    @Test
    @DisplayName("The registration of a new user with valid data redirects to the Account page.")
    public void registerWithValidDataTest() {
        System.out.println("This is the test number 1.");

        String firstNameInput = DataFakerManager.generateFakeFirstName();
        System.out.println(firstNameInput);

        String lastNameInput = DataFakerManager.generateFakeLastName();
        System.out.println(lastNameInput);

        String emailInput = DataFakerManager.generateFakeEmail();
        System.out.println(emailInput);

        String passwordInput = DataFakerManager.generateFakePassword();
        System.out.println(passwordInput);

        registerPage.fillInTheRegisterForm(firstNameInput, lastNameInput, emailInput, passwordInput, true);
        registerPage.clickTheContinueBtn();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String currentUrl = driver.getCurrentUrl();
        boolean doesCurrentUrlContainSuccessAccountRout = currentUrl.contains("route=account/success");
        Assertions.assertTrue(doesCurrentUrlContainSuccessAccountRout, "The current Url contains: " + currentUrl + " route=account/success");
    }

    @Test
    @DisplayName("The user is remaining on Register page when trying to register with invalid password.")
    public void registerWithInvalidPasswordTest() {
        System.out.println("This is the test number 2.");

        String firstNameInput = DataFakerManager.generateFakeFirstName();
        System.out.println(firstNameInput);

        String lastNameInput = DataFakerManager.generateFakeLastName();
        System.out.println(lastNameInput);

        String emailInput = DataFakerManager.generateFakeEmail();
        System.out.println(emailInput);

        String passwordInput = DataFakerManager.generateFakePassword();
        System.out.println(passwordInput);

        registerPage.fillInTheRegisterForm(firstNameInput, lastNameInput, emailInput, passwordInput="1", true);
        registerPage.clickTheContinueBtn();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://andreisecuqa.host/index.php?route=account/register&language=en-gb";
        Assertions.assertEquals(expectedUrl, actualUrl, "The Urls should be equals.");
    }

    @Test
    @DisplayName("Error message is displayed on Register page flow when password is less than 4 chars.")
    public void errorMessageIsDisplayedWhenInvalidPasswordIsUsedForRegisterFlow() {
        System.out.println("This is the test number 3.");

        String firstNameInput = DataFakerManager.generateFakeFirstName();
        System.out.println(firstNameInput);

        String lastNameInput = DataFakerManager.generateFakeLastName();
        System.out.println(lastNameInput);

        String emailInput = DataFakerManager.generateFakeEmail();
        System.out.println(emailInput);

        String passwordInput = DataFakerManager.generateFakePassword();
        System.out.println(passwordInput);

        registerPage.fillInTheRegisterForm(firstNameInput, lastNameInput, emailInput, passwordInput="Aa1", true);
        registerPage.clickTheContinueBtn();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String expectedErrorMessageForErrorPassword = "Password must be between 4 and 20 characters!";
        String actualErrorMessage = driver.findElement(By.id("error-password")).getText();

        Assertions.assertEquals(expectedErrorMessageForErrorPassword, actualErrorMessage);
    }
}
