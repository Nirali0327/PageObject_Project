package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class VerifyProductAddedToCart extends Utils{
 // Assertion to verify the correct product in the cart
    public void CorrectProduct(){

        String expectedResult1 = "Build your own computer";
        String actualResult1 = getTextElement(By.partialLinkText("Build your own computer"));
       Assert.assertEquals(expectedResult1,actualResult1,"Invalid page");
    }
    public void correctPageTitle(){
        String actualResult2 = getTextElement(By.xpath("//span[@class=\"cart-label\"]"));
        String expectedResult2= "Shopping cart";
       Assert.assertEquals(actualResult2,expectedResult2,"Invalid page title");

    }

}


