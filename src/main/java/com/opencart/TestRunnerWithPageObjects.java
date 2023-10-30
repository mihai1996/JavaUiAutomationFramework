package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.AccountCreatedPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunnerWithPageObjects {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeader();

        RegisterPage registerPage = new RegisterPage(driver);


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
        Thread.sleep(2000);

        // Log out
        AccountCreatedPage account = new AccountCreatedPage(driver);
        account.navigateToLogOutFromHeader();

        LoginPage loginPage = new LoginPage(driver);

        // Login
        Thread.sleep(2000);
        homePage.navigateToLoginPageFromHeader();
        Thread.sleep(1000);
        // input login data
        loginPage.fillInTheLoginForm(emailInput, passwordInput);
        loginPage.clickLoginBtn();
        Thread.sleep(1000);

        // log out
        account.navigateToLogOutFromHeader();
        Thread.sleep(3000);

        DriverManager.getInstance().tearDown();

       System.out.println("The execution is over.");

    }
}