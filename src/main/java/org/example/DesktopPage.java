package org.example;

import org.openqa.selenium.By;

public class DesktopPage extends Utils {
    private By _desktop = By.xpath("//li[@class='inactive']//a[contains(text(),\"Desktops\")]");

    public void clicksOnDeskTop(){
        //click on Desktop
        clickElement(_desktop);
    }
}
