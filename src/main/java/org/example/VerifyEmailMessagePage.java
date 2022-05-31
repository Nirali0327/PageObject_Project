package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyEmailMessagePage extends Utils{
    public void emailSent(){

        // Assertion to verify for email has sent
        String actual = getTextElement(By.xpath("//div[@class=\"result\"]"));
        String expected = "Your message has been sent.";
        Assert.assertEquals(actual,expected,"Email has not sent successfully");

    }
}
