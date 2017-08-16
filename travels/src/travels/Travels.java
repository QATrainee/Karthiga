package travels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Travels 
{
	 public static void main(String[] args) throws InterruptedException
	 {
		 WebDriver driver;
	        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jdk1.8.0_121\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("http://www.phptravels.net");
	        driver.manage().window().maximize();
            driver.findElement(By.xpath(".//*[@id='s2id_autogen3']/a/span[2]")).click();
            Thread.sleep(1000);
           driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input")).sendKeys("dub");
           Thread.sleep(1000);
           driver.findElement(By.cssSelector(".select2-result-label")).click();
       //    driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li/ul/li[2]/div")).click();
   
            
            driver.findElement(By.xpath(".//*[@id='dpd1']/div/input")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("html/body/div[13]/div[1]/table/tbody/tr[3]/td[5]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(".//*[@id='dpd2']/div/input")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("html/body/div[14]/div[1]/table/tbody/tr[4]/td[3]")).click();
            Thread.sleep(1000);
            Select select = new Select(driver.findElement(By.xpath(".//*[@id='adults']")));
            List <WebElement> l = select.getOptions();
            for(int i = 0 ; i< l.size(); i++);
            {
            	select.selectByIndex(1);
            	//driver.findElement(By.xpath(".//*[@id='HOTELS']/div/form/div[6]/div/button")).click();
            	 Thread.sleep(1000);
            }
     
            Select sel = new Select(driver.findElement(By.xpath(".//*[@id='child']")));
            List <WebElement> k = sel.getOptions();
            for(int i = 0 ; i< k.size(); i++);
            {
            	sel.selectByIndex(1);
            	driver.findElement(By.xpath(".//*[@id='HOTELS']/div/form/div[6]/div/button")).click();
            	 Thread.sleep(1000);
            }
	 }
}
