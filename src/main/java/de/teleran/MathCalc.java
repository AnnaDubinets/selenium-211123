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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathCalc {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Acer\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/math.html");

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    public double funcCalc(double x){
        return log(abs(12 * sin(x)));

    }


    @Test
    public void validAnswer() throws InterruptedException {
        WebElement x = driver.findElement(By.id("input_value"));
        double result = funcCalc(Double.parseDouble(x.getText()));
        WebElement answerInputField = driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));


        //check checkbox

        WebElement checkBox = driver.findElement(By.id("robotCheckbox"));
        checkBox.click();

        //choose Robots rule

        WebElement radioButton = driver.findElement(By.id("robotsRule"));
        radioButton.click();

        //Click Submit button

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        sleep(5000);
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }
}
