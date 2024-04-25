package de.teleran;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatsTest {
    ChromeDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Acer\\Desktop\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/cats.html");

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    //@Test
    //public void headerTest(){
       // WebElement header = driver.findElement(By.tagName("h1"));
        //assertEquals("Cat memes", header.getText());
    //}


    //@org.testng.annotations.Test
    //public <WebDriver, WebElement> void headerTest(){
       // Object By = null;
        //WebElement header = driver.finalize();
        //assertEquals("Cat memes", header.getClass());
    //}

    //@Test
    //public void timeOfFirstCardTest(){
        //Object By;
        //WebElement header = driver.finalize(By.tagName("h1"));
        //assertEquals("9 mins", timeFirstCat.getText());
    //}

    //check that "I love you so much" text contains in name of last cat card

    //@Test
    //public void timeOfsixtCardTest(){
        //WebElement header = driver.findElement(By.tagName("h1"));
        //assertEquals("9 mins", timeFirstCat.getText());
    //}

    //@Test
    //public void checkImageQuantity(){
        //List<WebElement> images = driver.findElements(By.tagName("img"));
        //assertEquals(6, images.size());
    //}



   // @Test
    //public void checkAllCardsAreDisplayed(){
        //Object By = null;
        //List<WebElement> cards = driver.findElements(By.cssSelector(".col-sm-4"));
        ////each card from cards is displayed
        //for (int i=0; i<cards.size();i++){
           // assertTrue(cards.get(i).isDisplayed());
        //}
    //}
}
