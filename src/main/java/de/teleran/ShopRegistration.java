package de.teleran;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopRegistration {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Acer\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/register");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public double funcCalc(double x) {
        return log(abs(12 * sin(x)));

    }

    @Test
    public void successRegistrationAllValidFields() {
        //Input all data
        //Text "Your registration" is displayed
        //Button "Continue" is displayed

        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();


        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.sendKeys("Mickle");

        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.sendKeys("Miller");

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys(randomEmail);

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("1234567aq");

        WebElement confirmPasswordInput = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordInput.sendKeys("1234567aq");


        WebElement registrationButton = driver.findElement(By.id("register-button"));
        registrationButton.click();


        //Text "Your registration completed" is displayed
        WebElement header = driver.findElement(By.cssSelector(".page-body .result"));
        assertTrue(header.getText().contains("Your registration completed"));

        WebElement continueButton = driver.findElement(By.cssSelector("[class=\"button-1 register-continue-button\"]"));
        assertTrue(continueButton.isDisplayed());

    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        String saltStr = salt.toString();
        return saltStr.toLowerCase() + "@gmail.com";
    }

    @Test
    public void emailGenerateTest() {
        System.out.println(getSaltString());
    }


    @Test
    public void invalidDataEmptyFirstNameTest() throws InterruptedException {


        //check that "First name is required." error message text is displayed

        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();


        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.sendKeys("Miller");

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys(randomEmail);

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("1234567aq");

        WebElement confirmPasswordInput = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordInput.sendKeys("1234567aq");


        WebElement registrationButton = driver.findElement(By.id("register-button"));
        registrationButton.click();


        WebElement header = driver.findElement(By.cssSelector(".field-validation-error>span"));
        assertTrue(header.getText().contains("First name is required."));

        //Specify all fields with valid data, Last name is empty, check the error message text
        //Specify all fields with valid data, Email is empty, check the error message text
        //Specify all fields with valid data, Email invalid format (without @), check the error message text


    }


    @Test
    public void emptyEmailInput() throws InterruptedException {


        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.sendKeys("Mickle");

        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.sendKeys("Miller");


        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("1234567aq");

        WebElement confirmPasswordInput = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordInput.sendKeys("1234567aq");


        WebElement registrationButton = driver.findElement(By.id("register-button"));
        registrationButton.click();


        WebElement header = driver.findElement(By.cssSelector(".field-validation-error>span"));
        assertTrue(header.getText().contains("Email is required."));

        sleep(5000);
    }

    @Test
    public void emptyLastNameInput() throws InterruptedException {
        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();

        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.sendKeys("Mickle");

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys(randomEmail);

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("1234567aq");

        WebElement confirmPasswordInput = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordInput.sendKeys("1234567aq");


        WebElement registrationButton = driver.findElement(By.id("register-button"));
        registrationButton.click();


        WebElement header = driver.findElement(By.cssSelector(".field-validation-error>span"));
        assertTrue(header.getText().contains("Last name is required."));

        sleep(5000);
    }

    @Test
    public void emptyInvalidEmailInput() throws InterruptedException {


        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.sendKeys("Mickle");

        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.sendKeys("Miller");

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("text.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("1234567aq");

        WebElement confirmPasswordInput = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordInput.sendKeys("1234567aq");


        WebElement registrationButton = driver.findElement(By.id("register-button"));
        registrationButton.click();


        WebElement header = driver.findElement(By.xpath("//span[@for='Email']"));
        assertTrue(header.getText().contains("Wrong email"));

        sleep(5000);
    }
}


