package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyRegistrationSuccessPage extends Utils{
    // assertion to verify
    public void verifyRegistrationCompleted(){
        String actual = getTextElement(By.xpath("//div[@class = \"result\"]"));
        String expected = "Your registration completed";
        Assert.assertEquals(actual,expected,"Registration is not successfull");
    }

}
