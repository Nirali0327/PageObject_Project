package org.example;

import org.openqa.selenium.By;



public class BuildYourComputerPage extends Utils {
    private By _Processor = By.id("product_attribute_1");
    String Value3 = "1";
    private By _RAM = By.id("product_attribute_2");
    String Value4 = "3";
    private By _HDD = By.xpath("//label[contains(text(),\"320 GB\")]");
    private By _OS = By.id("product_attribute_4_9");
    private By _software1 = By.id("product_attribute_5_10");
    private By _software2 = By.id("product_attribute_5_11");
    private By _software3 = By.id("product_attribute_5_12");
    public void ownComputerPage() {
        // select from processor dropdown
        selectDropdownValue((_Processor),Value3);
        // select RAM
        selectDropdownValue((_RAM),Value4);
        // click on HDD radioButton
        clickElement(_HDD);
        //click on OS radiobutton
        clickElement(_OS);
        // select  software checkbox all
        clickElement(_software1);
        clickElement(_software2);
        clickElement(_software3);
       // click on  Add to cart button
       driverElementToBeClickable(3,By.xpath("//div[@class=\"add-to-cart\"]//child::button"));
       // click on shopping cart button
        driverElementToBeClickable(5,By.xpath("//span[@class=\"cart-label\"]"));
    }
}