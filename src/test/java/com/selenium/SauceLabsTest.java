package com.example;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsTest {

    public static void main(String[] args) throws Exception {

        String username = "oauth-harshaba0408-a07a9";
        String accessKey = "ffcb5a55-e174-4339-8e07-0dda05cd8d99";

        String sauceURL =
                "https://" + username + ":" + accessKey +
                "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

        ChromeOptions options = new ChromeOptions();

        options.setCapability("browserVersion", "latest");
        options.setCapability("platformName", "Windows 11");

        WebDriver driver = new RemoteWebDriver(new URL(sauceURL), options);

        driver.get("https://www.saucedemo.com");

        System.out.println(driver.getTitle());

        driver.quit();
    }
}
