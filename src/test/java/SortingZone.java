import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortingZone {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void sorting() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("developer");
        driver.findElement(By.name("password")).sendKeys("developer");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        for (int i=0;i<driver.findElements(By.cssSelector("tr.row")).size();i++)
        {
            driver.findElements(By.cssSelector("tr.row")).get(i).findElement(By.cssSelector("td:nth-child(3)>a")).click();
            for (int j=0;j<driver.findElements(By.cssSelector("#table-zones tr select:not(.select2-hidden-accessible)")).size()-1;j++)
            {
                if (driver.findElements(By.cssSelector("#table-zones tr select:not(.select2-hidden-accessible)")).get(j).getAttribute("value").compareTo(driver.findElements(By.cssSelector("#table-zones tr select:not(.select2-hidden-accessible)")).get(j+1).getAttribute("value"))>0)
                {
                    System.out.println("нарушен алфавитный порядок");
                }
            }
            driver.navigate().back();
        }

    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
