import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver.findElement(By.cssSelector("a[href$='doc=edit_product']")).click();
        driver.findElement(By.cssSelector("input[name='status']")).click();
        driver.findElement(By.cssSelector("input[name='name[en]']")).sendKeys("new product");
        driver.findElement(By.cssSelector("input[name='code']")).sendKeys("code0000");
        //driver.findElements(By.cssSelector("input[name='categories[]']")).get(driver.findElements(By.cssSelector("input[name='categories[]']")).size()).click();
        driver.findElement(By.cssSelector("input[name='new_images[]']")).sendKeys("C:\\Users\\user\\Documents\\картинки для сайта\\категории\\chicken.jpg");



    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
