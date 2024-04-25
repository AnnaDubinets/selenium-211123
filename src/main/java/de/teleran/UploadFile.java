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

public class UploadFile {

    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Acer\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/file_input.html");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void uploadFileTest() throws InterruptedException {
        //Input First Name

        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Enter first name\"]"));
        firstNameInputField.sendKeys("Anna");

        //Input Last Name

        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Enter last name\"]"));
        lastNameInputField.sendKeys("Smith");

        //Input Email

        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder=\"Enter email\"]"));
        emailInputField.sendKeys("qwerty@gmail.com");


        WebElement uploadFileInput = driver.findElement(By.id("file"));
        uploadFileInput.sendKeys("C:\\Users\\Acer\\Desktop\\textfile.txt");

        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }
}
