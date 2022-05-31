package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CurrencyPage extends Utils{
    private By _Euro = By.id("customerCurrency");
     int index2 = 1;
    public void CheckTheCurrencyForProduct() {
        //selectEuro
        selectDropdownIndex((_Euro), index2);

    }
    public void CurrencyLogoUsDollar () {
        // assertion to verify correct currency for product(Dollar)

        char ActualDollar = getTextElement(By.xpath("//div[@data-productid=\"1\"]//child::span[contains(text(),\"$\")]")).charAt(0);
        char ExpectedDollar = '$';
        Assert.assertEquals(ActualDollar, ExpectedDollar, "Product price is not in Dollar");

    }
    public void CurrencyLogoEuro(){
        // assertion to verify correct currency for product(Euro)
        char ActualEuro = getTextElement(By.xpath("//div[@data-productid=\"1\"]//child::span[contains(text(),\"€\")]")).charAt(0);
        char ExpectedEuro = '€';
        Assert.assertEquals(ActualEuro, ExpectedEuro, "product price is not in Euro");

    }
}