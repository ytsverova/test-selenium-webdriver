import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckProduct {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void CheckProduct(){
        driver.get("http://localhost/litecart/");
        for (int i=1; i<driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).size();i=i+1){
            String homeName=driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).findElement(By.cssSelector("div.name")).getText();
            WebElement homePrice;
            WebElement homeRegularPrice;
            WebElement homeCompainPrice;
            if (driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).findElements(By.cssSelector("span.price")).size()>0) {
                homePrice = driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).findElement(By.cssSelector("span.price"));

            }

            else{
                homeRegularPrice=driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).findElement(By.cssSelector("s.regular-price"));
                homeCompainPrice=driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).findElement(By.cssSelector("strong.campaign-price"));
                System.out.println(homeRegularPrice.getCssValue("color"));

            }
            driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).click();
            String productName =driver.findElement(By.cssSelector("h1")).getText();
            if (homeName.compareTo(productName)!=0) System.out.println("значения наименований не совпадают");
            WebElement productPrice;
            WebElement productRegularPrice;
            WebElement productCompainPrice;
            if (driver.findElements(By.cssSelector("span.price")).size()>0) {
                productPrice = driver.findElement(By.cssSelector("span.price"));
                //if (Integer.parseInt(productPrice.getText())!=Integer.parseInt(homePrice.getText())) System.out.println("значение цены не совпадает");
            }
            else{
                productRegularPrice=driver.findElement(By.cssSelector("s.regular-price"));
                productCompainPrice=driver.findElement(By.cssSelector("strong.campaign-price"));
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
