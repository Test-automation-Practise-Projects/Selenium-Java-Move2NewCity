import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {

        m2ncLogin();
    }

    public static void m2ncLogin(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        driver.get("https://www.move2newcity.com/");

        WebElement signInLink = driver.findElement(By.xpath("//*[@id=\"responsive-navbar-nav\"]/div/a[3]"));
        signInLink.click();

        driver.findElement(By.id("email")).sendKeys("qatestnewcomerm2nc@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");

        driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/button")).click();

    }
}
