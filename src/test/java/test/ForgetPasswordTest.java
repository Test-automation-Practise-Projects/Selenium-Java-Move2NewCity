package test;

import Pages.ForgetPasswordPage;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForgetPasswordTest {

    static WebDriver driver;
    static ForgetPasswordPage forgetpswobj;
    static HomePage logobj;


    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        forgetpswobj = new ForgetPasswordPage(driver);
        logobj = new HomePage(driver);
    }

    @Test
    public void gotoSite() {
        driver.get("https://m2nc.dev.limarktech.com/");
    }

    @Test(dependsOnMethods = {"gotoSite"})
    public void openSignIn() {
        logobj.clickSigninLink();
    }

    @Test(dependsOnMethods = {"openSignIn"})
    public void openForgetPassword(){
        forgetpswobj.clickForgetPasswordLink();
    }

    @Test(dependsOnMethods = {"openForgetPassword"})
    public void sendPassword() {
        forgetpswobj.setTextInEmailField("nethma@limarktech.com");
        forgetpswobj.clickSendButton();
    }


//    @AfterTest
//    public void tearDownTest() {
//            driver.quit();
//        System.out.println("Test was completed successfully");
//    }
}
