import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ClickAdmin {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void clickAdmin(){
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();


        for (int i=0;i<driver.findElements(By.cssSelector("div #box-apps-menu>li")).size();i++)
        {
            driver.findElements(By.cssSelector("div #box-apps-menu>li")).get(i).click();
            for (int j=0; j<driver.findElements(By.cssSelector("div #box-apps-menu>li")).get(i).findElements(By.cssSelector("li")).size();j++)
            {
                driver.findElements(By.cssSelector("div #box-apps-menu>li")).get(i).findElements(By.cssSelector("li")).get(j).click();
                driver.findElement(By.cssSelector("h1"));
            }

            driver.findElement(By.cssSelector("h1"));

        }


    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
