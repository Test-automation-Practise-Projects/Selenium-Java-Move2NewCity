package test;

import Pages.EditAccountPage;
import Pages.LoginPage;
import Utils.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class EditAccountTest{

    static WebDriver driver;
    static EditAccountPage editAccountObj;

    static LoginPage loginobj;


    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        editAccountObj = new EditAccountPage(driver);
        loginobj=new LoginPage(driver);
    }

    @Test
    public void gotoSite() {
        driver.get("https://m2nc.dev.limarktech.com/");
    }

    @Test(dependsOnMethods = {"gotoSite"})
    public void openSignIn() {
        loginobj.clickSigninLink();
    }

    @Test(dependsOnMethods = {"openSignIn"})
    public void loginAsNewcomer() {

        loginobj.setTextInUsernameBox("qatestnewcomerm2nc@gmail.com");
        loginobj.setTextInPasswordBox("12345");

        loginobj.clickLoginButton();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropdown-basic\"]")));


    }


    @Test(dependsOnMethods = {"loginAsNewcomer"})
    public void gotoEditAccountPage() {

        editAccountObj.clickProfileDropdown();
        editAccountObj.clickEditDropdownOption();
    }
//    @Test
//    public void verifySuccessfulEdit() {
//        editAccountPage.clickEditIcon();
//        editAccountPage.setFullName("John Doe");
//        editAccountPage.setUsername("john_doe");
//        editAccountPage.setMobileNumber("1234567890");
//        editAccountPage.setEmail("johndoe@example.com");
//        editAccountPage.selectCityMovingTo("New York");
//        editAccountPage.selectTimeZone("EST");
//        editAccountPage.selectCategoriesInterested("Technology", "Art", "Music");
//        editAccountPage.clickSaveButton();
//
//        // Add assertions to verify successful edit
//        String successMessage = editAccountPage.getSuccessMessage();
//        Assert.assertEquals(successMessage, "Profile updated successfully", "Profile update failed.");
//    }
//
//    @AfterTest
//    public void tearDownTest() {
//        if (driver != null) {
//            driver.quit();
//        }
//        System.out.println("Test was completed successfully");
//    }
}
