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
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void CheckProduct(){
        driver.get("http://localhost/litecart/");
        for (int i=1; i<driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).size();i=i+1){
            String homeName=driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).findElement(By.cssSelector("div.name")).getText();
            WebElement homePriceElement;
            WebElement homeRegularPriceElement;
            WebElement homeCompainPriceElement;
            Double homePrice=0.00;
            Double homeRegularPrice=0.00;
            Double homeCompainPrice=0.00;
            if (driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).findElements(By.cssSelector("span.price")).size()>0) {
                homePriceElement = driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).findElement(By.cssSelector("span.price"));
                homePrice=Double.parseDouble(homePriceElement.getText().replace("$",""));
            }

            else{
                homeRegularPriceElement=driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).findElement(By.cssSelector("s.regular-price"));
                if (!checkGrey(homeRegularPriceElement)) System.out.println("регулярная цена не серая");
                if (!(homeRegularPriceElement.getAttribute("localName").equals("s"))) System.out.println("регулярная цена не зачеркнута");

                homeCompainPriceElement=driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).findElement(By.cssSelector("strong.campaign-price"));
                if (!checkRed(homeCompainPriceElement)) System.out.println("акционная цена не красная");

                homeRegularPrice=Double.parseDouble(homeRegularPriceElement.getText().replace("$",""));
                homeCompainPrice=Double.parseDouble(homeCompainPriceElement.getText().replace("$",""));
                if (Integer.parseInt(homeRegularPriceElement.getAttribute("offsetHeight"))>Integer.parseInt(homeCompainPriceElement.getAttribute("offsetHeight"))) System.out.println("акционная цена не крупнее регулярной");

            }
            driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(i).click();
            String productName =driver.findElement(By.cssSelector("h1")).getText();
            if (homeName.compareTo(productName)!=0) System.out.println("значения наименований не совпадают");
            WebElement productPrice;
            WebElement productRegularPrice;
            WebElement productCompainPrice;
            if (driver.findElements(By.cssSelector("#box-product span.price")).size()>0) {
                productPrice = driver.findElement(By.cssSelector("#box-product span.price"));
                if (Double.parseDouble(productPrice.getText().replace("$",""))!=homePrice) System.out.println("значение цены не совпадает");
            }
            else{
                productRegularPrice=driver.findElement(By.cssSelector("#box-product s.regular-price"));
                if (Double.parseDouble(productRegularPrice.getText().replace("$",""))!=homeRegularPrice) System.out.println("значение регулярной цены не совпадает");

                if (!checkGrey(productRegularPrice)) System.out.println("регулярная цена не серая");
                if (!(productRegularPrice.getAttribute("localName").equals("s"))) System.out.println("регулярная цена не зачеркнута");



                productCompainPrice=driver.findElement(By.cssSelector("#box-product strong.campaign-price"));
                if (Double.parseDouble(productCompainPrice.getText().replace("$",""))!=homeCompainPrice) System.out.println("значение акционной цены не совпадает");
                if (!checkRed(productCompainPrice)) System.out.println("акционная цена не красная");
                if (Integer.parseInt(productRegularPrice.getAttribute("offsetHeight"))>Integer.parseInt(productCompainPrice.getAttribute("offsetHeight"))) System.out.println("акционная цена не крупнее регулярной");
            }

            driver.navigate().back();

        }

    }

    public boolean checkGrey(WebElement element)
    {

        myColor color=new myColor(element.getCssValue("color"));
        if (color.r!=color.g) return false;
        else if (color.r!=color.b) return false;
        return true;

    }

    public boolean checkRed (WebElement element){

        //String color=element.getCssValue("color");
        myColor color=new myColor(element.getCssValue("color"));

        if (color.r==0) return false;
        else if (color.g!=0) return false;
        else if (color.b!=0) return false;
        return true;
    }

    public class myColor {
        int r,g,b;

        public myColor(String color) {
            if (color.contains(("rgba")))
                color = color.substring(0, color.lastIndexOf(","));
            color = color.replace("rgba", "");
            color = color.replace("rgb", "");
            color = color.replace("(", "");
            color = color.replace(")", "");
            color = color.replace(", ", ",");
            r = Integer.parseInt(color.substring(0, color.indexOf(",")));
            color = color.substring(color.indexOf(",") + 1);
            g = Integer.parseInt(color.substring(0, color.indexOf(",")));
            color = color.substring(color.indexOf(",") + 1);
            b = Integer.parseInt(color);
        }

    }



    @After
    public void stop(){
        driver.quit();
        driver=null;
    }

}
