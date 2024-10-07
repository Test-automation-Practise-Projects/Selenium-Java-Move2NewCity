package test;

import Pages.ContactUsPage;
import Pages.HomePage;
import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseTest {

    HomePage homePage;
    ContactUsPage contactUsPage;


    @Test

    public void testHomePageNavigation() {
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
        //        driver.get("https://www.move2newcity.com/");


        homePage.clickContactUsLink();
        Assert.assertTrue(homePage.isOnContactUsPage(), "Failed to navigate to Contact Us page");


        contactUsPage.setName("accde");
        contactUsPage.setEmail("a@gmail.com");
        contactUsPage.selectCity();
        contactUsPage.setMessage("message");
    }

}