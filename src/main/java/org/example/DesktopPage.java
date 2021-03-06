package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utils {
    private By _desktop = By.xpath("//li[@class='inactive']//a[contains(text(),\"Desktops\")]");
    private By _sortByZtoA = By.xpath("//select[@id=\"products-orderby\"]");

    public void clicksOnDeskTop() {
        //click on Desktop
        clickElement(_desktop);
    }

    public void SortByZToA() {
        //select sort by Z to A
        selectDropdownValue(_sortByZtoA, "6");
        // List of WebElements for product title  to get text
        List<WebElement> productTitles = driver.findElements(By.xpath("//h2[@class=\"product-title\"]"));

        // List of webelement for product title to get text  in decending order
        List<String> descendingProductTitles = new ArrayList<String>();
        for (WebElement e : productTitles) {
            descendingProductTitles.add(e.getText().substring(0, 1));
        }
        //  //sorting after list for descending order
        Collections.sort(descendingProductTitles, Collections.reverseOrder());
        System.out.println(descendingProductTitles);

        List<String> actualProductTitles = new ArrayList<String>();
        for (WebElement e : productTitles) {
            actualProductTitles.add(e.getText().substring(0, 1));
        }
        //verification for before list and after list
        System.out.println(actualProductTitles);
        Assert.assertTrue(actualProductTitles.equals(descendingProductTitles));

    }

}