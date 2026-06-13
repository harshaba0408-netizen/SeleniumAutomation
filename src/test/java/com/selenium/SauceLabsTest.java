package com.example;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SauceLabsTest {

    @Test
    public void sauceDemoLoginTest() throws Exception {

        String username = "oauth-harshaba0408-a07a9";
        String accessKey = "84c3e36c-f674-4242-a64a-553455bb02ed";

        String sauceURL =
                "https://" + username + ":" + accessKey
                + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

        ChromeOptions options = new ChromeOptions();

        options.setCapability("platformName", "Windows 11");
        options.setCapability("browserVersion", "latest");

        options.setCapability("sauce:options", new java.util.HashMap<String, Object>() {{
            put("name", "SauceDemo Login Test");
            put("build", "Build-1");
        }});

        WebDriver driver = new RemoteWebDriver(new URL(sauceURL), options);

        try {

            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name"))
                    .sendKeys("standard_user");

            driver.findElement(By.id("password"))
                    .sendKeys("secret_sauce");

            driver.findElement(By.id("login-button"))
                    .click();

            System.out.println("Login Successful");

        } finally {

            driver.quit();
        }
    }
}
