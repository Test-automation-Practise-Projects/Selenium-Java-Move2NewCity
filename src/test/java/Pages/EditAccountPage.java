package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {

    WebDriver driver;

    // Locators

    By profileDropdownIcon = By.xpath("//*[@id=\"dropdown-basic\"]");

    By editAccountDropdownOption = By.xpath("//*[@id=\"responsive-navbar-nav\"]/div/div[2]/div/div/a[1]");
    By editIcon = By.id("edit-icon"); // Adjust the ID based on the actual locator
    By fullNameField = By.id("full-name");
    By usernameField = By.id("username");
    By mobileNumberField = By.id("mobile-number");
    By emailField = By.id("email");
    By cityMovingToDropdown = By.id("city-moving-to");
    By timeZoneDropdown = By.id("timezone"); // Adjust this locator
    By categoriesInterestedSection = By.id("categories-interested");
    By saveButton = By.id("save-button");
    By successMessage = By.id("success-message");

    public EditAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions

    public void clickProfileDropdown(){
        driver.findElement(profileDropdownIcon).click();
    }

    public void clickEditDropdownOption(){
        driver.findElement(editAccountDropdownOption).click();
    }
    public void clickEditIcon() {
        driver.findElement(editIcon).click();
    }

    public void setFullName(String fullName) {
        WebElement fullNameElement = driver.findElement(fullNameField);
        fullNameElement.clear();
        fullNameElement.sendKeys(fullName);
    }

    public void setUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void setMobileNumber(String mobileNumber) {
        WebElement mobileNumberElement = driver.findElement(mobileNumberField);
        mobileNumberElement.clear();
        mobileNumberElement.sendKeys(mobileNumber);
    }

    public void setEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void selectCityMovingTo(String city) {
        Select cityDropdown = new Select(driver.findElement(cityMovingToDropdown));
        cityDropdown.selectByVisibleText(city);
    }

    public void selectTimeZone(String timeZone) {
        Select timeZoneSelect = new Select(driver.findElement(timeZoneDropdown)); // Renamed to timeZoneSelect
        timeZoneSelect.selectByVisibleText(timeZone);
    }


    public void selectCategoriesInterested(String... categories) {
        for (String category : categories) {
            WebElement categoryElement = driver.findElement(By.xpath("//p[text()='" + category + "']"));
            if (!categoryElement.isSelected()) {
                categoryElement.click();
            }
        }
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
