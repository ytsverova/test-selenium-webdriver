import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;


import java.util.Set;

public class CheckOpenWindow {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void checkOpenWindow() {

        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("a[href*='edit_country']")).click();
        for (int i = 0; i < driver.findElements(By.cssSelector("i[class='fa fa-external-link']")).size(); i++) {
            String originalWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            driver.findElements(By.cssSelector("i[class='fa fa-external-link']")).get(i).click();
            while (driver.getWindowHandles().size()<=oldWindows.size())
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            Set<String> newWindows = driver.getWindowHandles();
            newWindows.removeAll(oldWindows);
            String newWindow=newWindows.iterator().next().toString();
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(originalWindow);
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
