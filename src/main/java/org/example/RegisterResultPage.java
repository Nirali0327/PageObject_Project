package org.example;

import org.openqa.selenium.By;

public class RegisterResultPage extends Utils{
    private By _continueButton = By.xpath("//a[@class=\"button-1 register-continue-button\"]");
    public void clickContinue(){
        // click on continue button
        clickElement(_continueButton);
    }

}
