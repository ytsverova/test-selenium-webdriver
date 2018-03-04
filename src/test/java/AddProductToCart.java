import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddProductToCart {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void addProducToCart(){
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("84191@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("pass-1588058092");
        driver.findElement(By.cssSelector("button[name='login']")).click();
        for (int i=0;i<3;i++) {
            driver.findElement(By.cssSelector("li[class='product column shadow hover-light']")).click();
            Integer count = Integer.parseInt(driver.findElement(By.cssSelector(".quantity")).getText());
            if (driver.findElements(By.cssSelector(".options select")).size()>0) {
                for (int j = 0; j < driver.findElements(By.cssSelector(".options select")).size();j++)
                {
                    Select options=new Select(driver.findElements(By.cssSelector(".options select")).get(j));
                    options.selectByIndex(1);

                }
            }
            driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".quantity"), String.valueOf(count+1)));
            driver.navigate().back();
        }

        driver.findElement(By.cssSelector("a[href$='checkout']")).click();
        while (driver.findElements(By.cssSelector("li.shortcut")).size()>0)
        {
            driver.findElements(By.cssSelector("li.shortcut")).get(0).click();
            Integer count=driver.findElements(By.cssSelector("#order_confirmation-wrapper tbody tr")).size();
            driver.findElement(By.cssSelector("button[name='remove_cart_item']")).click();
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("#order_confirmation-wrapper tbo"),count));

        }
        driver.findElement(By.cssSelector("button[name='remove_cart_item']")).click();




    }

    @After
    public void stop(){
        //driver.quit();
       // driver=null;
    }
}
