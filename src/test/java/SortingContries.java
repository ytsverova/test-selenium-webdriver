import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SortingContries {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void sorting(){
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("developer");
        driver.findElement(By.name("password")).sendKeys("developer");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        for (int i=0;i<driver.findElements(By.cssSelector("tr.row td:nth-child(5) a")).size()-1;i++)
        {
            if (driver.findElements(By.cssSelector("tr.row td:nth-child(5) a")).get(i).getText().compareTo(driver.findElements(By.cssSelector("tr.row td:nth-child(5) a")).get(i+1).getText())>0)
                System.out.println("нарушен алфавитный порядок");
            if (Integer.parseInt(driver.findElements(By.cssSelector("tr.row td:nth-child(6)")).get(i).getText())>0)
            {
                driver.findElements(By.cssSelector("tr.row td:nth-child(5) a")).get(i).click();
                for (int j=0;j<driver.findElements(By.cssSelector("#table-zones tr td:nth-child(3)")).size()-1;j++)
                {
                    if (driver.findElements(By.cssSelector("#table-zones tr td:nth-child(3)")).get(j).getText().compareTo(driver.findElements(By.cssSelector("#table-zones tr td:nth-child(3)")).get(j+1).getText())>0)
                    {
                        System.out.println("нарушен алфавитный порядок");
                    }
                }
                driver.navigate().back();
            }
        }


    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
