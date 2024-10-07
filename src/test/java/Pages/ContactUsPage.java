package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactUsPage {


    WebDriver driver;
    WebDriverWait wait;

    By send_button = By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[3]/form/button");

    By name_field = By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[3]/form/div[1]/input");
    By email_field = By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[3]/form/div[2]/div[1]/input");

    By city_dropdown = By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[3]/form/div[2]/div[2]/div[1]/div/input[1]");

    By message_field = By.xpath("//*[@id=\"message\"]");


    By city_options = By.xpath("//*[@id=\"city\"]");


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String nametext){
        driver.findElement(name_field).sendKeys(nametext);
    }

    public void setEmail(String emailtxt){
        driver.findElement(email_field).sendKeys(emailtxt);
    }

    public void selectCity(){
        driver.findElement(city_dropdown).click();

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust wait time as needed

        // Wait for the dropdown options to be visible
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(city_options));

        // Select the second option (index 1, as index starts from 0)
        if (options.size() > 1) {
            options.get(5).click(); // Select the second option
        } else if (options.size() == 1) {
            options.get(0).click(); // Select the only available option, if necessary
            System.out.println("pritig oly sydey");
        } else {
            System.out.println("Dropdown has no selectable options.");
        }
    }

    public void setMessage(String messagetxt){
        driver.findElement(message_field).sendKeys(messagetxt);
    }
    public void clickSendButton(){
        driver.findElement(send_button).click();
    }


}
