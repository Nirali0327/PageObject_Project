package org.example;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils {

    String firstname = "Nina";
    String lastName = "smith";
    int index1 = 3;
    String value1 = "3";
    String value2 = "1981 ";
    String password = "password123";
    String ConfirmPassword = "password123";
    LoadProp loadProp = new LoadProp();
    private By _gender = By.id("gender-female");
    private By _firstName = By.xpath("//input[@name =\"FirstName\"]");
    private By _lastname = By.id("LastName");
    private By _Birthday = By.name("DateOfBirthDay");
    private By _BirthMonth = By.name("DateOfBirthMonth");
    private By _BirthYear = By.name("DateOfBirthYear");
    //private By _Email = By.xpath("//input[@name=\"Email\"]");
    //String email1 = "Nina@gmail.com";
    private By _Password = By.xpath("//input[@name =\"Password\"]");
    private By _ConfirmPassword = By.xpath("//input[@name = 'ConfirmPassword']");
    private By _registrationButton = By.xpath("//button[@class = \"button-1 register-next-step-button\"]");

    public void UserFillsRegistrationForm() {
        // click on  male or female
        clickElement(_gender);
        // enter the firstname
        sendKeys((_firstName), loadProp.getProperty("firstName"));
        // enter the last name
        sendKeys((_lastname), loadProp.getProperty("lastName"));
        // select date of birthday
        selectDropdownIndex((_Birthday), index1);
        // select date of birthMonth
        selectDropdownValue((_BirthMonth), value1);
        // select date of birthYear
        selectDropdownText((_BirthYear), value2);
        // enter the email
        // enter the email
        sendKeys(By.xpath("//input[@name=\"Email\"]"), "Nina" + randomDate() + "@gmail.com");
        System.out.println(randomDate());
        // enter the password
        sendKeys((_Password), password);
        // enter the password to confirm
        sendKeys((_ConfirmPassword), ConfirmPassword);
        // click on register button
        clickElement(_registrationButton);

    }
}






