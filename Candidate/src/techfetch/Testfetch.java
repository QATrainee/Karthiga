package techfetch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import techfetch.Techfetch2;
@Test
public class Testfetch {
	public static void main(String[] args) throws Exception  {
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jdk1.8.0_121\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Techfetch2 g=new Techfetch2(driver);
	g.login();
	g.upload();
	g.profile();
	g.myresume();
	g.myjob();
	//g.features();
	
	}}
