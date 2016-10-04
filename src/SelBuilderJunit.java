import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class SelBuilderJunit {
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
    
    @Test
    public void SelBuilderJunit() {
        wd.get("https://wordpress.com/wp-login.php");
        wd.findElement(By.id("user_login")).click();
        wd.findElement(By.id("user_login")).clear();
        wd.findElement(By.id("user_login")).sendKeys("Test");
        wd.findElement(By.xpath("//body")).click();
        wd.findElement(By.id("user_pass")).click();
        wd.findElement(By.id("user_pass")).clear();
        wd.findElement(By.id("user_pass")).sendKeys("23432");
        wd.findElement(By.id("wp-submit")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Account Suspended!If you believe your account is suspended in error please contact us")) {
            System.out.println("verifyTextPresent failed");
        }
    }
    
    @After
    public void tearDown() {
        wd.quit();
        System.out.println("Test Completed Successfully");
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
