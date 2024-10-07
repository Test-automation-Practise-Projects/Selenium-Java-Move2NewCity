package test;

import Pages.HomePage;
import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    HomePage homePage;

    @Test
    public void testHomePageNavigation() {
        homePage = new HomePage(driver);
        driver.get("https://m2nc.dev.limarktech.com/");

        // Test the Home link
        homePage.clickHomeLink();
        Assert.assertTrue(homePage.isOnHomePage(), "Failed to navigate to Home page");

        // Test the Become a Friend link
        homePage.clickBecomeFriendLink();
        Assert.assertTrue(homePage.isOnBecomeFriendPage(), "Failed to navigate to Become Friend page");




        // Test the Sign In link
//        homePage.clickSigninLink();
//        Assert.assertTrue(homePage.isOnSignInPage(), "Failed to navigate to Sign In page");
//
//        homePage.closeSigninScreen();

        // Test the Demo button
        homePage.clickDemoButton();
        Assert.assertTrue(homePage.isOnDemoPage(), "Failed to navigate to Demo page");

        // Test clicking the logo to return to Home page
        homePage.clickLogo();
        Assert.assertTrue(homePage.isOnHomePage(), "Failed to navigate to Home page by clicking logo");


        // Test the Become a Friend button
        homePage.clickBecomeFriendButton();
        Assert.assertTrue(homePage.isOnBecomeFriendPage(), "Failed to navigate to Become Friend page");

        homePage.clickHomeLink();

        // Test the About Us link
        homePage.clickAboutUsLink();
        Assert.assertTrue(homePage.isOnAboutUsPage(), "Failed to navigate to About Us page");

        // Navigate back to Home page
        homePage.clickHomeLink();

        // Test the Contact Us link
        homePage.clickContactUsLink();
        Assert.assertTrue(homePage.isOnContactUsPage(), "Failed to navigate to Contact Us page");

        // Navigate back to Home page
        homePage.clickHomeLink();

        // Test the How It Works link
        homePage.clickHowItWorksLink();
        Assert.assertTrue(homePage.isOnHowItWorksPage(), "Failed to navigate to How It Works page");

        // Navigate back to Home page
        homePage.clickHomeLink();

        // Test the Terms & Conditions link
        homePage.clickTermsConditionsLink();
        Assert.assertTrue(homePage.isOnTermsConditionsPage(), "Failed to navigate to Terms & Conditions page");


        homePage.clickCookiePolicyLink();
        Assert.assertTrue(homePage.isOnCookiePolicyPage(), "Failed to navigate to Cookie policy page");


        // Navigate back to Home page
        homePage.clickHomeLink();

        // Test the Privacy Policy link
        homePage.clickPrivacyPolicyLink();
        Assert.assertTrue(homePage.isOnPrivacyPolicyPage(), "Failed to navigate to Privacy Policy page");

        homePage.clickHomeLink();

        homePage.clickFaqLink();
        Assert.assertTrue(homePage.isOnFaqPage(), "Failed to navigate to FAQ page");

        homePage.clickHomeLink();

        homePage.clickBecomeFriendFooterLink();
        Assert.assertTrue(homePage.isOnBecomeFriendFooterPage(),"Failed to navigate to become friend page through footer");

        homePage.clickHomeLink();

        // Test the Facebook icon
        homePage.clickFacebookIcon();
        Assert.assertTrue(homePage.isOnFacebookPage(), "Failed to navigate to Facebook page");

        // Test the LinkedIn icon
        homePage.clickLinkedInIcon();
        Assert.assertTrue(homePage.isOnLinkedInPage(), "Failed to navigate to LinkedIn page");

        // Test the Instagram icon
        homePage.clickInstagramIcon();
        Assert.assertTrue(homePage.isOnInstagramPage(), "Failed to navigate to Instagram page");
    }

    }



