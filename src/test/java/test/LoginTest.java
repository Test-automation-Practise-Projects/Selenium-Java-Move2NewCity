package test;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    static WebDriver driver;
    static LoginPage loginobj;

    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginobj = new LoginPage(driver);
    }

    @Test
    public void gotoSite() {
        driver.get("https://m2nc.dev.limarktech.com/");
    }

    @Test(dependsOnMethods = {"gotoSite"})
    public void openSignIn() {
        loginobj.clickSigninLink();
    }

//    @Test(dependsOnMethods = {"openSignIn"})
//    public void verifyRememberMeChecked() {
//        loginobj.setTextInUsernameBox("nethma@limarktech.com");
//        loginobj.setTextInPasswordBox("Nethma@123");
//
//        loginobj.clickRememberMeCheckbox(true);
//        Assert.assertTrue(loginobj.isRememberMeChecked(), "Remember Me checkbox should be checked.");
//
//        loginobj.clickLoginButton();
//
//        driver.get("https://m2nc.dev.limarktech.com/");
//        loginobj.clickSigninLink();
//
//        // Verify that the username field is autofilled and the password field is empty
//        String savedUsername = loginobj.getUsernameFieldText();
//        String savedPassword = loginobj.getPasswordFieldText();
//
//        Assert.assertEquals(savedUsername, "nethma@limarktech.com", "Username should be remembered.");
//        Assert.assertTrue(savedPassword.isEmpty(), "Password field should be empty.");
//    }

    @Test(dependsOnMethods = {"openSignIn"})
    public void verifyRememberMeUnchecked() {
        // Uncheck the Remember Me checkbox and log in again
        loginobj.clickRememberMeCheckbox(false);
        Assert.assertFalse(loginobj.isRememberMeChecked(), "Remember Me checkbox should be unchecked.");

        // Clear the username and password fields before setting new credentials
        loginobj.setTextInUsernameBox("");
        loginobj.setTextInPasswordBox("");

        loginobj.setTextInUsernameBox("nethma@limarktech.com");
        loginobj.setTextInPasswordBox("Nethma@123");

        loginobj.clickLoginButton();

        driver.get("https://m2nc.dev.limarktech.com/");
        loginobj.clickSigninLink();

        String savedUsername = loginobj.getUsernameFieldText();
        String savedPassword = loginobj.getPasswordFieldText();

        Assert.assertTrue(savedUsername.isEmpty(), "Username field should be empty.");
        Assert.assertTrue(savedPassword.isEmpty(), "Password field should be empty.");
    }

    @Test(dependsOnMethods = {"verifyRememberMeUnchecked"})
    public void verifyErrorMessagesForInvalidInputs() {
        // Test both email and password fields empty
        loginobj.setTextInUsernameBox("");
        loginobj.setTextInPasswordBox("");
        loginobj.clickLoginButton();

        String emailError = loginobj.getEmailErrorMessage();
        String passwordError = loginobj.getPasswordErrorMessage();
        String passwordError2 = loginobj.getPasswordErrorMessage2();

        System.out.println("Email Error Message: " + emailError);
        System.out.println("Password Error Message: " + passwordError);

        Assert.assertEquals(emailError, "Email is required.", "Email error message should be displayed.");
        Assert.assertEquals(passwordError, "Password is required.", "Password error message should be displayed.");

        // Test only email field empty with a valid password
        loginobj.setTextInUsernameBox("");
        loginobj.setTextInPasswordBox("Nethma#123");
        loginobj.clickLoginButton();

        emailError = loginobj.getEmailErrorMessage();
        passwordError2 = loginobj.getPasswordErrorMessage2();

        System.out.println("Email Error Message: " + emailError);
        System.out.println("Password Error Message: " + passwordError);

        Assert.assertEquals(emailError, "Email is required.", "Email error message should be displayed.");
        Assert.assertTrue(passwordError2.isEmpty(), "Password error message should not be displayed.");

        // Test invalid email format with a valid password
        loginobj.setTextInUsernameBox("invalidEmail");
        loginobj.setTextInPasswordBox("Nethma@123");
        loginobj.clickLoginButton();

        emailError = loginobj.getEmailErrorMessage();
        passwordError = loginobj.getPasswordErrorMessage();

        System.out.println("Email Error Message: " + emailError);
        System.out.println("Password Error Message: " + passwordError);

        Assert.assertEquals(emailError, "Invalid email address", "Invalid email error message should be displayed.");
//        Assert.assertTrue(passwordError.isEmpty(), "Password error message should not be displayed.");

        // Test valid email with empty password field
        loginobj.setTextInUsernameBox("nethma@limarktech.com");
        loginobj.setTextInPasswordBox("");
        loginobj.clickLoginButton();

        emailError = loginobj.getEmailErrorMessage();
        passwordError2 = loginobj.getPasswordErrorMessage2();

        System.out.println("Email Error Message: " + emailError);
        System.out.println("Password Error Message: " + passwordError2);

        Assert.assertTrue(passwordError2.contains("Enter your password"), "Password error message should be displayed.");
        Assert.assertTrue(emailError.isEmpty(), "Email error message should not be displayed.");
    }

    @AfterTest
    public void tearDownTest() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Test was completed successfully");
    }
}
