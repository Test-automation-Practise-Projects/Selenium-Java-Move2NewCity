package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    // Locators
    By signin_link = By.xpath("//*[@id=\"root\"]/div[1]/header/nav/div[2]/button");
    By username_field = By.id("email");
    By password_field = By.id("password");
    By login_button = By.xpath("//*[@id=\"root\"]/div[1]/header/div/div[2]/div/div[2]/div/form/button");
    By remember_me_checkbox = By.xpath("//*[@id=\"headlessui-checkbox-:r0:\"]/div");

    // Error message locators
    By email_error_message = By.xpath("//*[@id=\"root\"]/div[1]/header/div/div[2]/div/div[2]/div/form/div[1]/p");  // Adjust ID as per actual locator
    By password_error_message = By.xpath("//*[@id=\"root\"]/div[1]/header/div/div[2]/div/div[2]/div/form/div[2]/p");  // Adjust ID as per actual locator
    By password_error_message2 = By.xpath("//*[@id=\"root\"]/div[1]/header/div/div[2]/div/div[2]/div/form/div[2]/p");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickSigninLink() {
        driver.findElement(signin_link).click();
    }

    public void setTextInUsernameBox(String usernametext) {
        WebElement usernameElement = driver.findElement(username_field);
        usernameElement.clear();
        usernameElement.sendKeys(usernametext);
    }

    public void setTextInPasswordBox(String pswtext) {
        WebElement passwordElement = driver.findElement(password_field);
        passwordElement.clear();
        passwordElement.sendKeys(pswtext);
    }

    public void clickLoginButton() {
        WebElement loginbtn = driver.findElement(login_button);
        loginbtn.click();
    }

    public void clickRememberMeCheckbox(boolean check) {
        WebElement rememberMeCheckbox = driver.findElement(remember_me_checkbox);
        if (check && !rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        } else if (!check && rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
    }

    public boolean isRememberMeChecked() {
        return driver.findElement(remember_me_checkbox).isSelected();
    }

    public String getUsernameFieldText() {
        return driver.findElement(username_field).getAttribute("value");
    }

    public String getPasswordFieldText() {
        return driver.findElement(password_field).getAttribute("value");
    }

    // Error Validations
    public String getEmailErrorMessage() {
        return driver.findElement(email_error_message).getText();
    }

    public String getPasswordErrorMessage() {
        WebElement passwordErrorElement = driver.findElement(password_error_message);
        return passwordErrorElement.getText();    }


    public String getPasswordErrorMessage2() {
        WebElement passwordErrorElement = driver.findElement(password_error_message2);
        return passwordErrorElement.getText();    }


}
