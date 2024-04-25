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

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadFile2 {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Acer\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();


    }

    @Test
    public void uploadFile() throws InterruptedException {
        WebElement uploadFileInput = driver.findElement(By.id("uploadFile"));
        uploadFileInput.sendKeys("C:\\Users\\Acer\\Desktop\\textfile.txt");

        WebElement textUpload = driver.findElement(By.id("uploadedFilePath"));
        assertTrue(textUpload.getText().contains("C:\\fakepath\\textfile.txt"));


        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        submitButton.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }
}
