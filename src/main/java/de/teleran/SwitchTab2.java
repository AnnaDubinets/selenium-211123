package de.teleran;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwitchTab2 {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Acer\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");

    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        driver.quit();

    }

    @Test
    public void switchToTabTest() throws InterruptedException {
        //click on New Tab
        WebElement inputNewTab = driver.findElement(By.id("tabButton"));
        inputNewTab.click();

        //switch to  new opened tab

        System.out.println(driver.getWindowHandles());//return all opened tabs ids
        System.out.println(driver.getWindowHandle());//return active tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


        //check that text "This is a sample page" is displayed

        WebElement samplePage = driver.findElement(By.id("sampleHeading"));
        assertTrue(samplePage.isDisplayed());

        sleep(5000);

    }
}
