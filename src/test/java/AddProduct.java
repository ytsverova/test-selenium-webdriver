import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class AddProduct {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void addProduct(){
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.cssSelector("a[href$='app=catalog&doc=catalog']")).click();
        Integer count=driver.findElements(By.cssSelector("tbody tr")).size();
        driver.findElement(By.cssSelector("a[href$='doc=edit_product']")).click();
        driver.findElement(By.cssSelector("input[name='status']")).click();
        driver.findElement(By.cssSelector("input[name='name[en]']")).sendKeys("new product");
        driver.findElement(By.cssSelector("input[name='code']")).sendKeys("code0000");
        driver.findElement(By.cssSelector("input[name='new_images[]']")).sendKeys(System.getProperty("user.dir")+"\\src\\test\\data\\pigs.jpg");
        Random random=new Random();
        driver.findElement(By.cssSelector("input[name='quantity']")).sendKeys(String.valueOf(random.nextInt(10)));
        driver.findElement(By.cssSelector("input[name='date_valid_from']")).sendKeys("10.10.2017");
        driver.findElement(By.cssSelector("input[name='date_valid_to']")).sendKeys("10.10.2018");

        driver.findElement(By.cssSelector("a[href='#tab-information']")).click();

        Select manufacturer= new Select(driver.findElement(By.cssSelector("select[name='manufacturer_id']")));
        manufacturer.selectByIndex(1);
        driver.findElement(By.cssSelector("input[name='keywords']")).sendKeys("key");
        driver.findElement(By.cssSelector("input[name='short_description[en]']")).sendKeys("short pigs");
        driver.findElement(By.cssSelector("div[class='trumbowyg-editor']")).sendKeys("long pigs");

        driver.findElement(By.cssSelector("a[href='#tab-prices']")).click();

        driver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys(String.valueOf(random.nextInt(50)));
        Select price= new Select(driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']")));
        manufacturer.selectByIndex(1);

        driver.findElement(By.cssSelector("button[name='save']")).click();

        if (driver.findElements(By.cssSelector("tbody tr")).size()<=count) System.out.println("товар не добавлен");
    }

    @After
    public void stop(){
       driver.quit();
       driver=null;
    }
}
