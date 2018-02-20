import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver.findElement(By.cssSelector("div #box-apps-menu-wrapper li")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("div #box-apps-menu-wrapper li #doc-template")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("div #box-apps-menu-wrapper li #doc-logotype")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("div #box-apps-menu-wrapper a[href$='doc=catalog']")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("div #box-apps-menu-wrapper a[href$='product_groups']")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-option_groups")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//li[@id='doc-manufacturers']")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//div[@id='box-apps-menu-wrapper']//li[5]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(@href,'delivery_statuses')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-sold_out_statuses")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-quantity_units")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-csv")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'Countries')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//div[@id='box-apps-menu-wrapper']//li[4]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//div[@id='box-apps-menu-wrapper']//li[5]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//div[@id='box-apps-menu-wrapper']//li[5]//li[2]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//div[@id='box-apps-menu-wrapper']//li[5]//li[3]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'Modules')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-jobs")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-customer")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-shipping")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-payment")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-order_total")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-order_success")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-order_action")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'Orders')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-orders")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-order_statuses")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'Pages')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'Reports')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-monthly_sales")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-most_sold_products")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-most_shopping_customers")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'Settings')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-store_info")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-defaults")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-general")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-listings")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-images")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-checkout")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-advanced")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-security")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'Slides')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'Tax')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-tax_classes")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-tax_rates")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'Translations')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-search")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-scan")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-csv")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'Users')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//a[contains(.,'vQmods')]")).click();
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.id("doc-vqmods")).click();
        driver.findElement(By.cssSelector("h1"));

    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
