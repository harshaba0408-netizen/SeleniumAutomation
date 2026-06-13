package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {

    @Test
    public void loginTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {

            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name"))
                    .sendKeys("standard_user");

            driver.findElement(By.id("password"))
                    .sendKeys("secret_sauce");

            driver.findElement(By.id("login-button"))
                    .click();

            Thread.sleep(3000);

            String currentUrl = driver.getCurrentUrl();

            if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
                System.out.println("Login Successful");
                System.out.println("Current URL: " + currentUrl);
            } else {
                System.out.println("Login Failed");
            }

        } finally {
            driver.quit();
        }
    }
}
