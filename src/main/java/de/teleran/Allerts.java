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

import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Allerts {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Acer\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public double funcCalc(double x) {
        return log(abs(12 * sin(x)));

    }


    @Test
    public void firstAlertText() throws InterruptedException {

        WebElement firstButton = driver.findElement(By.id("alertButton"));
        firstButton.click();


        //Check that alert has text "You clicked a button"

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("This alert appeared after 5 seconds", alert.getText());
    }

    @Test
    public void secondAlertText() {

        //Check that alert has text «This alert appeared after 5 seconds»

        WebElement secondButton = driver.findElement(By.id("timerAlertButton"));
        secondButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("This alert appeared after 5 seconds", alert.getText());
    }


    @Test
    public void thirdAlertText() {

        //Check that «You selected Ok» is displayed after alert confirmation


        WebElement thirdButton = driver.findElement(By.id("confirmButton"));
        thirdButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        WebElement text = driver.findElement(By.id("confirmResult"));
        System.out.println(text.getText());
        assertEquals("You selected OK", text.getText());
    }
}
