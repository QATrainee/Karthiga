package RecruiterLogin;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	WebDriverWait wait;
	static WebDriver d;
	public static Logger log = Logger.getLogger("Logger");
	public static String workingDir;

	public static WebElement xp(String xpath) {

		return d.findElement(By.xpath(xpath));
	}

	public static WebElement id(String id) {

		return d.findElement(By.id(id));
	}

	public static WebElement css(String cssSelector) {

		return d.findElement(By.cssSelector(cssSelector));
	}

	public void browserOpen() throws InterruptedException {
		workingDir = System.getProperty("user.dir");
		BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", workingDir + "\\Resources\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	public void logIn() throws Exception {
		File file = new File(workingDir + "\\Resources\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.get(prop.getProperty("URL"));
		log.info("Opening Techfetch webiste");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		xp(prop.getProperty("Recuriterloginclick")).click();
		log.info("Opening Recuriter menu");
	
		xp(prop.getProperty("loginbutton")).click();
		log.info("Clicking Login button");
		d.switchTo().defaultContent();
		d.switchTo().frame("empcontentframe");
		wait = new WebDriverWait(d, 30);
		xp(prop.getProperty("MailidField")).sendKeys(prop.getProperty("username"));
		log.info("Entering mailid");
		xp(prop.getProperty("PasswordField")).sendKeys(prop.getProperty("password"));
		log.info("Entering password");
		xp(prop.getProperty("submitbutton")).click();
		log.debug("Clicking submit button");
		
		String mytitle = "Top Jobs for Smart Talent | TechFetch.com";
		if (!d.getTitle().equals(mytitle)) {
			wait = new WebDriverWait(d, 30);
			xp(".//*[@id='alertify-ok']").click();
			xp(prop.getProperty("PasswordField")).sendKeys(prop.getProperty("password"));
			xp(prop.getProperty("submitbutton")).click();
			//d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

	}

	public void logOut() throws Exception {
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		File file = new File(workingDir + "\\Resources\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		// Logout...
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		xp(prop.getProperty("logoutbutton")).click();
		log.debug("Clicking logout button ");

	}

	public void browserClose() {
		d.quit();
	}

}