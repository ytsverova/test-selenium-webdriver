import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegistrationUser {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void registrationUser(){
        driver.get("http://localhost/litecart/en/create_account");
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("user");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("user");
        driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("adress");
        Random random=new Random();
        driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys(String.valueOf(random.nextInt(89999)+10000));
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys("NY");
        Select country=new Select(driver.findElement(By.cssSelector("select[name='country_code']")));
        country.selectByValue("US");
        String email=String.valueOf(random.nextInt(99999))+"@gmail.com";
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("+7"+String.valueOf(random.nextInt(99999)));
        String pass="pass"+String.valueOf(random.nextInt());
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(pass);
        driver.findElement(By.cssSelector("input[name='confirmed_password']")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[name='create_account']")).click();
        driver.findElement(By.cssSelector("a[href$='logout']")).click();
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[name='login']")).click();
        driver.findElement(By.cssSelector("a[href$='logout']")).click();







    }




    @After
    public void stop(){
       driver.quit();
       driver=null;
    }
}
