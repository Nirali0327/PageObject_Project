package org.example;

import org.openqa.selenium.By;

public class AddToCartPage extends Utils {
    // private By _AddToCart = By.xpath("//div[@data-productid='1']//child::button[contains(text(),\"Add to cart\")]");
    public void clickOnAddToCart() {
        //click on Add to cart button on desktop
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement(By.xpath("//div[@data-productid='1']//child::button[contains(text(),\"Add to cart\")]"));
       // clickElement(By.xpath("//button[normalize-space()='Add to cart']"));


    }
}