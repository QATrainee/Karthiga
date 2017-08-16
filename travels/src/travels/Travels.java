package travels;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Travels 
{
	 public static void main(String[] args) throws InterruptedException
	 {
		 WebDriver driver;
	        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jdk1.8.0_121\\chromedriver.exe");
	        driver = new ChromeDriver();
	  // driver.get("http://www.phptravels.net");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.get("http://www.phptravels.net");
	        Thread.sleep(1000);
	  // String xp =".select2-chosen";
            WebElement city = driver.findElement(By.cssSelector(".select2-chosen"));
            city.click();
           // Thread.sleep(1000);
            driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input")).sendKeys("dub");
            Thread.sleep(1000);
            Actions action = new Actions(driver);
            action.moveToElement(city).perform();
            driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li/ul/li[1]/div")).click();
            Thread.sleep(1000);
   //select date 
            driver.findElement(By.xpath(".//*[@id='dpd1']/div/input")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("html/body/div[14]/div[1]/table/tbody/tr[3]/td[6]")).click();
            Thread.sleep(1000);
     // driver.findElement(By.xpath(".//*[@id='dpd2']/div/input")).click();
     //  Thread.sleep(1000);
            driver.findElement(By.xpath("html/body/div[15]/div[1]/table/tbody/tr[4]/td[6]")).click();
            Thread.sleep(3000);
            Select select = new Select(driver.findElement(By.xpath(".//*[@id='adults']")));
            List <WebElement> l = select.getOptions();
            for(int i = 0 ; i< l.size(); i++);
            {
            	select.selectByIndex(1);
            	 Thread.sleep(1000);
            }
            Select sel = new Select(driver.findElement(By.xpath(".//*[@id='child']")));
            List <WebElement> k = sel.getOptions();
            for(int i = 0 ; i< k.size(); i++);
            {
            	sel.selectByIndex(1);
            	driver.findElement(By.xpath(".//*[@id='HOTELS']/div/form/div[6]/div/button")).click();
            	 Thread.sleep(1000);
            	 driver.findElement(By.xpath("html/body/div[5]/div[3]/div/table/tbody/tr[1]/td/div/div[2]/div/div[1]/a/button")).click();
            }
            for(int i=0;i<6;i++)
            {
            	driver.findElement(By.xpath(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]")).click();
            }
	 }
}
