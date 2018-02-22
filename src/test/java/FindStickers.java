import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FindStickers {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void findStickers(){
            driver.get("http://localhost/litecart/");
            List<WebElement> products = driver.findElements(By.cssSelector("li[class='product']"));
            for (int i=1; i<products.size();i=i+1){
                int count=products.get(i).findElements(By.cssSelector("div[class='sticker']")).size();
                if (count!=1) {
                    System.out.println("стикер не единтсвенный");
                }

            }

        }




    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
