package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    VerifyRegistrationSuccessPage registrationSuccessPage = new VerifyRegistrationSuccessPage();
    CurrencyPage currencyPage = new CurrencyPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourComputerPage buildYourComputerPage = new BuildYourComputerPage();
    VerifyProductAddedToCart verifyProductAddedToCart = new VerifyProductAddedToCart();
    AddToCartPage addToCartPage = new AddToCartPage();
    EmailToFriendPage emailToFriendPage = new EmailToFriendPage();
    RegisterResultPage registerResultPage = new RegisterResultPage();
    VerifyCommunityPollPage verifycommunitypollpage = new VerifyCommunityPollPage();
    VerifyEmailMessagePage verifyEmailMessagePage = new VerifyEmailMessagePage();
    SelectProductPage selectProductPage = new SelectProductPage();
    @Test(priority = 1)
    public void UserIsAbleToRegister() {
        //verify user can register successfully
        homePage.userClicksOnRegistration();
        registrationPage.UserFillsRegistrationForm();
        registrationSuccessPage.verifyRegistrationCompleted();
    }

    @Test(priority = 2)
    public void CurrencyForProduct() {
        // verify the correct currency for a product
        currencyPage.CheckTheCurrencyForProduct();
    }

    @Test(priority = 5)
    public void UserIsAbleToAddProductToCart() {
        homePage.userClicksOnComputer();
        desktopPage.clicksOnDeskTop();
        addToCartPage.clickOnAddToCart();
        buildYourComputerPage.ownComputerPage();
        verifyProductAddedToCart.CorrectProduct();
        verifyProductAddedToCart.correctPageTitle();
    }

    @Test(priority = 4)
    public void ReferAProductToFriend() {
        homePage.userClicksOnRegistration();
        registrationPage.UserFillsRegistrationForm();
        registrationSuccessPage.verifyRegistrationCompleted();
        registerResultPage.clickContinue();
        selectProductPage.ProductSelected();
        emailToFriendPage.EmailFriend();
        verifyEmailMessagePage.emailSent();

    }

    @Test(priority = 3)
    public void HomePageCommunityPollVote() {
        homePage.UserClicksOnCommunityPoll();
        verifycommunitypollpage.VerifyVoteErrorMsg();
        homePage.userClicksOnRegistration();
        registrationPage.UserFillsRegistrationForm();
        registerResultPage.clickContinue();
        homePage.UserClicksOnCommunityPoll();
        verifycommunitypollpage.VerifyVoteAfterRegister();

    }
    //user can view all the product is listed for  camera/photo
    @Test(priority = 6)
    public void getListOfProduct() {
        homePage.getProductTitlesForCamera();
    }

    @Test(priority = 7)
    public void userClicksOnAlert() {
        homePage.votePopUp();
    }
// verify user can  sortBy Name : z to A for a product correctly
    @Test(priority = 8)
    public void userSortBYZtoA() {
        homePage.userClicksOnComputer();
        desktopPage.clicksOnDeskTop();
        desktopPage.SortByZToA();
    }
    // user can navigate from  nopcommerce page to facebook successfully
    @Test(priority = 9)
    public void userNavigateToFacebookPage()
    {
        homePage.clickFaceBook();
    }
    // user can search for any product type from search box.
    @Test(priority = 10)
    public  void verifyUserCanSearchAnyProductType(){
      homePage.searchProduct("Nike");
    }
    // user can add the comment successfully
    @Test(priority = 11)
    public void commentAdded(){
        homePage.nopCommerceNewRelease();
    }
}