package org.example;

import org.openqa.selenium.By;

public class SelectProductPage extends Utils {
    private By _BuildComputerLink = By.xpath("//h2/a[@href=\"/build-your-own-computer\"]");
    private By _emailAFriend = By.xpath("//button[@class=\"button-2 email-a-friend-button\"]");
    public void ProductSelected() {
        // click on build your own computer
        clickElement(_BuildComputerLink);


        //click on  email a friend
        clickElement(_emailAFriend);
    }

}

