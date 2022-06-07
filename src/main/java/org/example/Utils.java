package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage {
    // ---------------------------UserDefineMethods(Utills)-----------------------------//
    // click on element
    public static void clickElement(By by) {
        driver.findElement(by).click();
    }

    // To send the value
    public static void sendKeys(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // To get the text
    public static String getTextElement(By by) {
        return driver.findElement(by).getText();
    }
    // To clear the text
    public void clearText(By by){
        driver.findElement(by).clear();
    }

    //To use a Timestamp
    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formater.format(date);
    }

    public static void selectDropdownText(By by, String textValue) {
        Select dropdown1 = new Select(driver.findElement(by));
        dropdown1.selectByVisibleText(textValue);
    }


    public static void selectDropdownIndex(By by, int index) {
        Select dropdown2 = new Select(driver.findElement(by));
        dropdown2.selectByIndex(index);
    }

    public static void selectDropdownValue(By by, String value) {
        Select dropdown3 = new Select(driver.findElement(by));
        dropdown3.selectByValue(value);
    }




    //---------------------- Explicit waits ----------------------------------------------------//

    //  Explicit Wait for the clickable element
    public static void driverElementToBeClickable(int time, By by) {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait1.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    // Explicit wait for the invisibility of element
    public static void driverInvisibility(int time, WebElement element) {
        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait7.until(ExpectedConditions.invisibilityOf(element));

    }
    // Explicit wait for the url fraction
    public static void driverUrlContains(int time, String urlFraction) {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait2.until(ExpectedConditions.urlContains(urlFraction));
    }

    public static void driverTitleContains(int time, String title) {
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait4.until(ExpectedConditions.titleContains(title));
    }
 // Take a screenshot
    public static void takeScreenShot(String a) {
        // Convert web driver object to TakeScreenShot
        TakesScreenshot screenshot = (TakesScreenshot) (driver);
        //call getscreenshot As method to create image file
        File screenfile = screenshot.getScreenshotAs(OutputType.FILE);
        //copy file at destination
        try {
            FileUtils.copyFile(screenfile, new File("screenshots\\" + a + randomDate() + "screenshot.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

