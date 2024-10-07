package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPasswordPage {

    WebDriver driver = null;

    // Locators
    By signin_link = By.xpath("//*[@id=\"responsive-navbar-nav\"]/div/a[3]");

    By forgetpsw_link = By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[4]/button");
    By email_field = By.xpath("/html/body/div[5]/div/div/div[2]/div[4]/div[1]/form/div[1]/input");

//    By email_field=By.id("email");
    By send_button = By.xpath("/html/body/div[5]/div/div/div[2]/div[4]/div[1]/form/div[3]/button");
    By backtoLogin_link = By.xpath("/html/body/div[5]/div/div/div[2]/div[4]/div[2]/button");



    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickSigninLink() {
        driver.findElement(signin_link).click();
    }

    public void clickForgetPasswordLink() {
        driver.findElement(forgetpsw_link).click();
    }

    public void setTextInEmailField(String text) {
        driver.findElement(email_field).sendKeys(text);
    }


    public void clickSendButton() {
        driver.findElement(send_button).click();
    }

    public void clickBacktoLoginLink() {
        driver.findElement(backtoLogin_link).click();
    }



}
