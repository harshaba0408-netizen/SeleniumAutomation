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

        WebDriverManager.chromedriver()
                        .browserVersion("146")
                        .setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        try {

            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name"))
                    .sendKeys("standard_user");

            driver.findElement(By.id("password"))
                    .sendKeys("secret_sauce");

            driver.findElement(By.id("login-button"))
                    .click();

            Thread.sleep(2000);

            String currentUrl = driver.getCurrentUrl();

            System.out.println("Login Successful");
            System.out.println("Current URL: " + currentUrl);

        } finally {

            driver.quit();

        }
    }
}
