package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;

    // Locators
    By signin_link = By.xpath("//*[@id=\"root\"]/div[1]/header/nav/div[2]/button");
    By becomefriend_link = By.xpath("//*[@id=\"root\"]/div[1]/header/nav/div[2]/a[2]");
    By home_link = By.xpath("//*[@id=\"root\"]/div[1]/header/nav/div[2]/a[1]");
    By demo_button = By.xpath("//*[@id=\"root\"]/div[1]/header/nav/div[2]/a[4]");
    By signin_close_button = By.xpath("//*[@id=\"root\"]/div[1]/header/div/div[2]/div/div[1]/button");
    By m2nclogo = By.xpath("//*[@id=\"root\"]/div[1]/header/nav/a/img");
    By search_bar = By.xpath("//*[@id=\"root\"]/div[1]/main/div/div[1]/div/div/div/div/input");  // Assuming an ID for the search bar
    By search_button = By.xpath("//*[@id=\"root\"]/div[1]/main/div/div[1]/div/div/div/div/div/div");  // Assuming an ID for the search button

    By becomefriend_button = By.xpath("//*[@id=\"root\"]/div[1]/main/div/div[4]/div[2]/div[2]/button");

    // Footer links
    By about_us_link = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[2]/div/div[1]/a[1]");
    By contact_us_link = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[2]/div/div[1]/a[4]");
    By how_it_works_link = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[2]/div/div[1]/a[2]");
    By terms_conditions_link = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[2]/div/div[2]/a[1]");
   By cookie_policy_link = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[2]/div/div[2]/a[2]");
    By privacy_policy_link = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[2]/div/div[2]/a[3]");

    By faq_link = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[2]/div/div[2]/a[4]");
    By becomeafriendfooter_link = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[2]/div/div[1]/a[3]");

    By facebook_icon = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[3]/div/a[1]");

    By linkedin_icon = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[3]/div/a[2]");
    By instagram_icon = By.xpath("//*[@id=\"root\"]/div[1]/footer/div[1]/div[3]/div/a[3]");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickSigninLink() {
        driver.findElement(signin_link).click();
    }

    public void closeSigninScreen() {
        driver.findElement(signin_close_button).click();
    }

    public void clickBecomeFriendLink() {
        driver.findElement(becomefriend_link).click();
    }

    public void clickBecomeFriendButton() {
        driver.findElement(becomefriend_button).click();
    }

    public void clickDemoButton() {
        driver.findElement(demo_button).click();
    }

    public void clickHomeLink() {
        driver.findElement(home_link).click();
    }

    public void clickLogo() {
        driver.findElement(m2nclogo).click();
    }

    public void searchCity(String cityName) {
        WebElement searchBar = driver.findElement(search_bar);
        searchBar.clear();
        searchBar.sendKeys(cityName);
        driver.findElement(search_button).click();
    }

    public void searchCityAndPressEnter(String cityName) {
        WebElement searchBar = driver.findElement(search_bar);
        searchBar.clear();
        searchBar.sendKeys(cityName + Keys.ENTER);  // Hitting the Enter key
    }

    // Footer Actions
    public void clickAboutUsLink() {
        driver.findElement(about_us_link).click();
    }

    public void clickContactUsLink() {
        driver.findElement(contact_us_link).click();
    }

    public void clickHowItWorksLink() {
        driver.findElement(how_it_works_link).click();
    }

    public void clickTermsConditionsLink() {
        driver.findElement(terms_conditions_link).click();
    }

    public void clickCookiePolicyLink(){
        driver.findElement(cookie_policy_link).click();
    }

    public void clickPrivacyPolicyLink() {
        driver.findElement(privacy_policy_link).click();
    }

    public void clickFaqLink(){
        driver.findElement(faq_link).click();
    }
    public void clickBecomeFriendFooterLink(){
        driver.findElement(becomeafriendfooter_link).click();
    }

    public void clickFacebookIcon() {
        driver.findElement(facebook_icon).click();
    }

    public void clickLinkedInIcon() {
        driver.findElement(linkedin_icon).click();
    }

    public void clickInstagramIcon() {
        driver.findElement(instagram_icon).click();
    }
    // Validations
    public boolean isOnHomePage() {
        return driver.getCurrentUrl().equals("https://m2nc.dev.limarktech.com/");
    }

    public boolean isOnBecomeFriendPage() {
        return driver.getCurrentUrl().contains("/become-a-friend");
    }

    public boolean isOnSignInPage() {
        return driver.findElement(signin_close_button).isDisplayed();
    }

    public boolean isOnDemoPage() {
        return driver.getCurrentUrl().contains("/demo");
    }

    // New Validations
    public boolean isOnAboutUsPage() {
        return driver.getCurrentUrl().contains("/about-us");
    }

    public boolean isOnContactUsPage() {
        return driver.getCurrentUrl().contains("/contact-us");
    }

    public boolean isOnHowItWorksPage() {
        return driver.getCurrentUrl().contains("/how-it-works");
    }

    public boolean isOnTermsConditionsPage() {
        return driver.getCurrentUrl().contains("/terms-and-conditions");
    }

    public boolean isOnCookiePolicyPage() {
        return driver.getCurrentUrl().contains("/cookie-policy");
    }


    public boolean isOnPrivacyPolicyPage() {
        return driver.getCurrentUrl().contains("/privacy-policy");
    }

    public boolean isOnFaqPage() {
        return driver.getCurrentUrl().contains("/faqs");
    }

    public boolean isOnBecomeFriendFooterPage(){
        return driver.getCurrentUrl().contains("/become-a-friend");
    }



    public boolean isOnFacebookPage() {
        // Store the current URL
        String currentUrl = driver.getCurrentUrl();

        // Check if the current URL matches the target URL
        boolean isOnFacebook = currentUrl.equals("https://www.facebook.com/move2newcity");

        // Navigate back to the original page
        driver.navigate().back();

        return isOnFacebook;
    }



    public boolean isOnLinkedInPage() {
        String currentUrl = driver.getCurrentUrl();
        boolean isOnLinkedin = currentUrl.equals("https://www.linkedin.com/company/move2newcity/");
        driver.navigate().back();
        return isOnLinkedin;
    }

    public boolean isOnInstagramPage() {
        String currentUrl = driver.getCurrentUrl();
        boolean isOnInstagram = currentUrl.equals("https://www.instagram.com/move2newcity/");
        driver.navigate().back();
        return isOnInstagram;
    }




    // Helper Methods
    private void switchToNewTab() {
        // Switch to the new tab
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    private void closeCurrentTabAndSwitchBack() {
        // Close the current tab and switch back to the original tab
        driver.close();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

}
