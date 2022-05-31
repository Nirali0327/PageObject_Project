package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyCommunityPollPage extends Utils{
    public void VerifyVoteErrorMsg(){
        //verification for vote without registration
        String expectedResult = "Only registered users can vote.";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualResult= getTextElement(By.xpath("//div[@class='poll-vote-error']"));
        Assert.assertEquals(actualResult,expectedResult,"You are not registered user");
    }
    public void VerifyVoteAfterRegister(){
        //verification for vote after registration
        String expectedMessage = "vote(s)";
        String actualMessage= getTextElement(By.xpath("//span[@class=\"poll-total-votes\"]"));
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
