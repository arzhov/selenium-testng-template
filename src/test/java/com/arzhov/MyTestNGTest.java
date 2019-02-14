package com.arzhov;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyTestNGTest {
    private static WebDriver DRIVER;

    @BeforeClass
    public static void setup(){
        String pathToChromeDriver = "D:\\ProgramFiles\\chromedriver_win32";
        System.setProperty("webdriver.chrome.DRIVER", pathToChromeDriver);
        DRIVER = new ChromeDriver();
    }

    @Test
    public void openGoogle() {
        DRIVER.navigate().to("https://www.google.com/");
        String title = DRIVER.getTitle();

        Assert.assertEquals(title, "Google");
    }

    @Test
    public void searchGoogle() {
        DRIVER.navigate().to("https://www.google.com/");

        WebElement searchInputElement = DRIVER.findElement(By.xpath("//input[@name='q']"));
        searchInputElement.sendKeys("selenium");
        searchInputElement.sendKeys(Keys.ENTER);

        String title = DRIVER.getTitle();

        Assert.assertTrue(title.contains("selenium"));
    }

    @AfterClass
    public static void teardown(){
        DRIVER.close();
    }
}
