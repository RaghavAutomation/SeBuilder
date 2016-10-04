import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class SelBuilderOne {
    public static void main(String[] args) throws Exception {
        FirefoxDriver wd;
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://wordpress.com/wp-login.php");
        wd.findElement(By.id("user_login")).click();
        wd.findElement(By.id("user_login")).clear();
        wd.findElement(By.id("user_login")).sendKeys("Abcd");
        wd.findElement(By.id("user_pass")).click();
        wd.findElement(By.id("user_pass")).clear();
        wd.findElement(By.id("user_pass")).sendKeys("123123");
        wd.findElement(By.id("wp-submit")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("ERROR: The password you entered for the email or username abcd is incorrect. Lost your password?")) {
            System.out.println("verifyTextPresent failed");
        }
        System.out.println("Test Completed Successfully");
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
