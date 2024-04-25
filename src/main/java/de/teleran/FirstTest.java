package de.teleran;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Acer\\Desktop\\QA\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}
