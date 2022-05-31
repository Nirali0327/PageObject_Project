package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailToFriendPage extends Utils{
    private By _friendEmail = By.xpath("//input[@class=\"friend-email\"]");
    String Email1 = "w@gmail.com";
    private By _personalMsg = By.xpath("//textarea[@class=\"your-email\"]");
    String message = "This product is excellent";
    private By _sendMail = By.xpath("//button[@name = \"send-email\"]");
    public void EmailFriend(){

        // Enter a friend's email
        sendKeys(_friendEmail,Email1);
        //Enter a personal message
        sendKeys(_personalMsg, message);
        // click on sendmail button
        clickElement(_sendMail);
    }


        }




