package Recruiter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Logged {
	static WebDriver driver;
	public String workingDir;
	
	protected static WebElement xp(String xpath) {

		return  driver.findElement(By.xpath(xpath));
	}

	protected static WebElement id(String id) {

		return  driver.findElement(By.id(id));
	}
	protected static WebElement css(String cssSelector) {

		return  driver.findElement(By.cssSelector(cssSelector));
	}
	void browserOpen() throws InterruptedException {
		workingDir = System.getProperty("user.dir");
		// BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver",workingDir+ "\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}
        void login() throws InterruptedException, IOException{
        	File file = new File(workingDir + "\\Resources\\login.properties");
    		FileInputStream fileInput;
    		fileInput = new FileInputStream(file);
    		Properties prop = new Properties();
    		prop.load(fileInput);
        driver.get(prop.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        xp(prop.getProperty("recruiter")).click();
        xp(prop.getProperty("login")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("empcontentframe");
        xp(prop.getProperty("user")).sendKeys(prop.getProperty("username"));
        xp(prop.getProperty("password")).sendKeys(prop.getProperty("passwords"));
        xp(prop.getProperty("submit")).click();
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       }
        void fetchresume() throws InterruptedException, IOException {
        	File file = new File(workingDir + "\\Resources\\rec.properties");
    		FileInputStream fileInput;
    		fileInput = new FileInputStream(file);
    		Properties prop = new Properties();
    		prop.load(fileInput);
    		  xp(prop.getProperty("fetch")).click();
    		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Iframe2");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        id(prop.getProperty("key")).sendKeys(prop.getProperty("keyword"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        id(prop.getProperty("all")).click();
        id(prop.getProperty("workAuthority")).click();
        id(prop.getProperty("workAuthority1")).click();
        id(prop.getProperty("workAuthority2")).click();
        id(prop.getProperty("workAuthority3")).click();
        id(prop.getProperty("preferedEmployment")).click();
        id(prop.getProperty("preferedEmployment1")).click();
        id(prop.getProperty("preferedEmployment2")).click();
        id(prop.getProperty("preferedEmployment3")).click();
        id(prop.getProperty("preferedEmployment4")).click();
        id(prop.getProperty("workAuthority")).click();
        id(prop.getProperty("workAuthority1")).click();
        id(prop.getProperty("preferedEmployment")).click();
        id(prop.getProperty("preferedEmployment1")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new Select(id(prop.getProperty("area"))).selectByVisibleText("Java, J2EE");
        new Select(id(prop.getProperty("skill"))).selectByVisibleText("Java Server Side");
        id(prop.getProperty("advancedSearch")).click();
        Thread.sleep(1000);
        xp(prop.getProperty("domain1")).click();
        xp(prop.getProperty("domain2")).click();
        id(prop.getProperty("country")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new Select(id(prop.getProperty("degree"))).selectByVisibleText("Bachelor");
        Select select =new Select(id(prop.getProperty("state")));
		List<WebElement> l = select.getOptions();
		for (int i = 0; i <6; i++) {
			select.selectByIndex(i);
			xp(prop.getProperty("arrow")).click();
		}
		id(prop.getProperty("Experience")).click();
		id(prop.getProperty("usExperience")).click();
		id(prop.getProperty("askill1")).sendKeys(prop.getProperty("skill1"));
		new Select(id(prop.getProperty("year1"))).selectByVisibleText("4");
		id(prop.getProperty("askill2")).sendKeys(prop.getProperty("skill1"));
		new Select(id(prop.getProperty("year2"))).selectByVisibleText("2");
		id(prop.getProperty("askill3")).sendKeys(prop.getProperty("skill1"));
		new Select(id(prop.getProperty("year3"))).selectByVisibleText("4");
	
		xp(prop.getProperty("save")).sendKeys(prop.getProperty("fetching"));
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new Select(id(prop.getProperty("days"))).selectByVisibleText("90 Days");
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        id(prop.getProperty("fetched")).click();
     
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        
        void logout() throws InterruptedException, IOException {
        	File file = new File(workingDir + "\\Resources\\rec.properties");
    		FileInputStream fileInput;
    		fileInput = new FileInputStream(file);
    		Properties prop = new Properties();
    		prop.load(fileInput);
        driver.switchTo().defaultContent();
        xp(prop.getProperty("logout")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.close(); 
    
        }
    public static void main(String[] args) throws InterruptedException, IOException {
    Logged log = new Logged();
    log.browserOpen();
    log.login();
    log.fetchresume();
    log.logout();
}}