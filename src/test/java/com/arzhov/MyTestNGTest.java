package com.arzhov;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        DRIVER = new ChromeDriver(initChromeOptions());
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
        DRIVER.quit();
    }

    private static ChromeOptions initChromeOptions(){
        ChromeOptions options = new ChromeOptions();
//        options.setBinary("D:\\ProgramFiles\\GoogleChromePortableTest\\GoogleChromePortable.exe");

        options.addArguments("start-maximized"); // open Browser in maximized mode
//        options.addArguments("disable-infobars"); // disabling infobars
//        options.addArguments("--disable-extensions"); // disabling extensions
//        options.addArguments("--disable-gpu"); // applicable to windows os only
//        options.addArguments("--no-sandbox"); // Bypass OS security model
//        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("user-data-dir=C:\\Users\\hovhannesa\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");


//        options.setExperimentalOption("useAutomationExtension", false);
//        options.setHeadless(true);

        return options;
    }
}
