package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        //String currentWindowName = driver.getWindowHandle();
        // New window code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host/");
        Thread.sleep(1000);
        WebElement myAccount = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccount.click();

        WebElement registerBtn = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerBtn.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.cssSelector("#input-firstname"));
        firstName.sendKeys(DataFakerManager.generateFakeFirstName());

        WebElement lastName = driver.findElement(By.cssSelector("#input-lastname"));
        lastName.sendKeys(DataFakerManager.generateFakeLastName());

        WebElement email = driver.findElement(By.cssSelector("#input-email"));
        email.sendKeys(DataFakerManager.generateFakeEmail());

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys(DataFakerManager.generateFakePassword());

        WebElement subscribeRadioBtn = driver.findElement(By.xpath("//input[@id='input-newsletter']"));
        subscribeRadioBtn.click();

        WebElement privacyPolicyRadioBtn = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicyRadioBtn.click();

        WebElement continueBtn = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueBtn.click();
        Thread.sleep(1000);
        driver.close();
        driver.quit();


        // TA-1
//        driver.get("https://www.google.com/");
//        Thread.sleep(2000);
//        System.out.println(driver.getTitle());
//        driver.close();
//
//        driver.switchTo().window(currentWindowName);
//        driver.get("https://tekwill.md/");
//        Thread.sleep(1000);
//        System.out.println(driver.getTitle());
//        driver.quit();
//
//        System.out.println("The execution is over.");
    }
}