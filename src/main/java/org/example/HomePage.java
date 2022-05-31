package org.example;

import org.openqa.selenium.By;

public class HomePage extends Utils {
    private By _clickElement1 = By.className("ico-register");
    private By _clickElement2 = By.partialLinkText("Computers");
    private By _clickElement3 = By.xpath("//input[@id=\"pollanswers-2\"]");
    private By _clickElement4 = By.xpath("//button[@id=\"vote-poll-1\"]");

    public void userClicksOnRegistration() {
        // click on register button
        clickElement(_clickElement1);
    }

    public void userClicksOnComputer() {
        //click on a computer
        // clickElement(By.partialLinkText("Computers"));
        clickElement(_clickElement2);
    }

    public void UserClicksOnCommunityPoll() {
        //click on vote radio button
        clickElement(_clickElement3);

        //click on vote button
        clickElement(_clickElement4);
    }

}

