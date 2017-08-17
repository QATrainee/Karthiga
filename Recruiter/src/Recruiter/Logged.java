package Recruiter;

import java.io.File;
import java.io.FileInputStream;
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
        	File file = new File(workingDir + "\\Resources\\rec.properties");
    		FileInputStream fileInput;
    		fileInput = new FileInputStream(file);
    		Properties prop = new Properties();
    		prop.load(fileInput);
        driver.get(prop.getProperty("URL"));
        Thread.sleep(1000);
        driver.manage().window().maximize();
        xp(prop.getProperty("recruiter")).click();
        xp(prop.getProperty("login")).click();
       // driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divRecruiter']/a")).click();
      //  driver.findElement(By.xpath(".//*[@id='emploginpop']")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("empcontentframe");
        
        driver.findElement(By.xpath(".//*[@id='txtemailid']")).sendKeys(prop.getProperty("username"));
        driver.findElement(By.xpath(".//*[@id='txtpwd']")).sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
        Thread.sleep(1000);
     driver.findElement(By.xpath(".//*[@id='LeftMenu11']/div/img")).click();
        Thread.sleep(10000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("Iframe2");
        driver.findElement(By.id("txtKeywords")).sendKeys(prop.getProperty("keyword"));
        Thread.sleep(10000);
        driver.findElement(By.id("rbKeywordsAll")).click();
     //   Thread.sleep(1000);
        driver.findElement(By.id("chkWorkAuthorization_0")).click();
        driver.findElement(By.id("chkWorkAuthorization_1")).click();
        driver.findElement(By.id("chkWorkAuthorization_2")).click();
        driver.findElement(By.id("chkWorkAuthorization_3")).click();
        
        driver.findElement(By.id("chkPreferredEmployment_0")).click();
        driver.findElement(By.id("chkPreferredEmployment_1")).click();
        driver.findElement(By.id("chkPreferredEmployment_2")).click();
        driver.findElement(By.id("chkPreferredEmployment_3")).click();
        driver.findElement(By.id("chkPreferredEmployment_4")).click();
        
        driver.findElement(By.id("chkWorkAuthorization_0")).click();
        driver.findElement(By.id("chkWorkAuthorization_1")).click();
        
   /*     driver.findElement(By.id("chkPreferredEmployment_0")).click();
        driver.findElement(By.id("chkPreferredEmployment_1")).click();
        driver.findElement(By.id("chkPreferredEmployment_2")).click();
        driver.findElement(By.id("chkPreferredEmployment_3")).click();
        driver.findElement(By.id("chkPreferredEmployment_4")).click();
        */
        driver.findElement(By.id("chkPreferredEmployment_0")).click();
        driver.findElement(By.id("chkPreferredEmployment_1")).click();
        Thread.sleep(1000);
       new Select(driver.findElement(By.id("ddlSpecializedArea"))).selectByVisibleText("Java, J2EE");
        new Select(driver.findElement(By.id("ddlSpecializedSkill"))).selectByVisibleText("Java Server Side");
        Thread.sleep(1000);
        driver.findElement(By.id("li1")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("chkBusinessDomain_0")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("chkBusinessDomain_9")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ddlCountry")).click();
        Thread.sleep(1000);
        new Select(driver.findElement(By.id("ddlDegree"))).selectByVisibleText("Bachelor");
        Select select = new Select(driver.findElement(By.id("lbStates")));
		List<WebElement> l = select.getOptions();
		for (int i = 0; i <6; i++) {
			select.selectByIndex(i);
			driver.findElement(By.xpath(".//*[@id='AdvSearchOptions']/table/tbody/tr[2]/td/table[2]/tbody/tr[2]/td[2]/input[1]")).click();
		}
		driver.findElement(By.id("cbExpAny")).click();
		driver.findElement(By.id("cbUSExpAny")).click();
		driver.findElement(By.id("txtSkill1")).sendKeys(prop.getProperty("skill1"));
		new Select(driver.findElement(By.id("ddlYears1"))).selectByVisibleText("4");
		driver.findElement(By.id("txtSkill2")).sendKeys(prop.getProperty("skill2"));
		new Select(driver.findElement(By.id("ddlYears2"))).selectByVisibleText("2");
		driver.findElement(By.id("txtSkill3")).sendKeys(prop.getProperty("skill3"));
		new Select(driver.findElement(By.id("ddlYears3"))).selectByVisibleText("5");
        //driver.findElement(By.id("chkSaveSearch")).click();
        driver.findElement(By.xpath(".//*[@id='txtSearchName']")).sendKeys(prop.getProperty("fetch"));
        Thread.sleep(1000);
        new Select(driver.findElement(By.id("ddlResumeDays"))).selectByVisibleText("90 Days");
        Thread.sleep(1000);
        driver.findElement(By.id("btnAdvancedSearch")).click();
        Thread.sleep(10000);
        
        }
        void logout() throws InterruptedException {
        
       // driver.findElement(By.xpath(".//*[@id='WelcomeUser']")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[@id='LogoutMTLTaskName']")).click();
        Thread.sleep(1000);
     driver.close(); 
    
        }
    public static void main(String[] args) throws InterruptedException, IOException {
    Logged log = new Logged();
    log.browserOpen();
    log.login();
    log.logout();
}}