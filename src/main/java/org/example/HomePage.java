package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends Utils {
    private By _clickRegister = By.className("ico-register");
    private By _clickComputer = By.partialLinkText("Computers");
    private By _clickVoteRadio = By.xpath("//input[@id=\"pollanswers-2\"]");
    private By _clickVote = By.xpath("//button[@id=\"vote-poll-1\"]");
    private By _clickFaceBook = By.xpath("//a[@href=\"http://www.facebook.com/nopCommerce\"]");
    private By _typeText = By.xpath("//input[@id=\"small-searchterms\"]");
    private By _clickSearch = By.xpath("//button[@class=\"button-1 search-box-button\"]");
    private By _checkProduct = By.xpath("//h2[@class=\"product-title\"]");
    private By _enterTitle = By.xpath("//input[@class=\"enter-comment-title\"]");
    private By _enterComment = By.xpath("//textarea[@class=\"enter-comment-text\"]");
    private By _clickDetail = By.xpath("//div[3]/a[@href=\"/nopcommerce-new-release\"]");
    private By _clickComment = By.xpath("//button[@name=\"add-comment\"]");
    private By _findElement = By.xpath("//div[@class=\"result\"]");

    private By _findElement1 = By.xpath("//div[@class=\"comment-title\"]");
    public void userClicksOnRegistration() {
        // click on register button
        clickElement(_clickRegister);
    }

    public void userClicksOnComputer() {
        //click on a computer
        // clickElement(By.partialLinkText("Computers"));
        clickElement(_clickComputer);

    }

    public void UserClicksOnCommunityPoll() {
        //click on vote radio button
        clickElement(_clickVoteRadio);

        //click on vote button
        clickElement(_clickVote);
    }

    // get productTiles/names on camera page
    public void getProductTitlesForCamera() {
        driver.get("https://demo.nopcommerce.com/camera-photo");
        List<WebElement> productTitles = driver.findElements(By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2"));
        System.out.println(productTitles.size());
        for (WebElement e : productTitles) {
            System.out.println(e.getText());
            System.out.println("-------------------------------");
        }
    }
    // Alert for a pop-up window by clicking on vote

    public void votePopUp() {

        clickElement(_clickVote);
        String text = "Please select an answer";
        String alertMsg = driver.switchTo().alert().getText();
        Assert.assertEquals(text,alertMsg,"alert message is not correct");
        System.out.println(alertMsg);
        driver.switchTo().alert().accept();
    }

    //    // click on facebook link from homepage
    public void clickFaceBook() {
        // click on facebook tab
        clickElement(_clickFaceBook);
        // window handler command to direct that current window is main window
        String mainWindow = driver.getWindowHandle();
        //handle multiple  window
        Set<String> s1 = driver.getWindowHandles();
        int count = s1.size();
        System.out.println("Total window" + count);
        for (String childWindow : s1) {
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                //switch to child  window
                driver.switchTo().window(childWindow);
                System.out.println("child window url " + driver.getCurrentUrl());
                String actualPageTitle = driver.getCurrentUrl();
                Assert.assertEquals( actualPageTitle,"https://www.facebook.com/nopCommerce", "Page not found");
                // closing the child window
                driver.close();
                //switch to the parent window
                driver.switchTo().window(mainWindow);
                System.out.println("main window title is " + driver.getCurrentUrl());
            }
        }

    }

    // user can search for any product type from search box
    public void searchProduct(String product) {
        //type product in search bar
        sendKeys(_typeText, product);
        //click on search
        clickElement(_clickSearch);
        // check all products
        List<WebElement> productTitles = driver.findElements(_checkProduct);
        for (WebElement e : productTitles) {
            System.out.println(e.getText());
            Assert.assertTrue(e.getText().contains(product)); //
        }
    }

    // user can add comment successfully
    public void nopCommerceNewRelease() {
        //click on newRelease Details
        clickElement(_clickDetail);
        String actualPageTitle = driver.getCurrentUrl();
        String expectedPageTitle = "https://demo.nopcommerce.com/nopcommerce-new-release";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title is wrong");
        //type Text in the title box
        String title = "Request for a new product for Nirali";
        sendKeys(_enterTitle, title);
        //type comment in the comment box
        sendKeys(_enterComment, "please send me the detail of new product");
        //click on new comment
        clickElement(_clickComment);
        String expectedMessage = "News comment is successfully added.";
        String actualMessage = getTextElement(_findElement);
        Assert.assertEquals(actualMessage, "News comment is successfully added.", "your comment is not added");
        //check comments
        List<WebElement> comments = driver.findElements(_findElement1);
        List<String> Comments = new ArrayList<>();
        for (WebElement e : comments) {
            Comments.add(e.getText());
        }
        Assert.assertTrue(Comments.contains(title));
        //last comment verification
        String lastComment = Comments.get(Comments.size() - 1);
        System.out.println(lastComment);
        Assert.assertEquals(lastComment, title, "Comment is not listed as last.");


    }


}








