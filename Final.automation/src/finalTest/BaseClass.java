package finalTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	WebDriver driver;
	Logger log = Logger.getLogger("vvv");

	/*
	 * public Baseclass(WebDriver driver) throws Exception { this.driver = driver;
	 * 
	 * }
	 */

	void browserOpen() throws InterruptedException {

		// BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", "D:\\Sys1\\workspace\\Final.automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}

	void logIn() throws Exception {
		File file = new File("D:\\Sys1\\workspace\\Final.automation\\src\\finalTest\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		  FileInputStream fsIP= new FileInputStream(new File("D:\\Sys1\\workspace\\Final.automation\\src\\finalTest\\data.xlsx"));
	        XSSFWorkbook wb = new XSSFWorkbook(fsIP);
	        XSSFSheet worksheet = wb.getSheetAt(0);           
	        Cell cell ;
	        XSSFCell cell1= null;
	        
	        for (int i = 0; i<=4;i++) {
	        	
	        
		driver.get(prop.getProperty("URL"));
		log.info("Opening Techfetch webiste");
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("candidatelogin"))).click();
		log.info("Opening candidate menu");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("loginbutton"))).click();
		log.info("Clicking Login button");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("candidatecontentframe");

	/*	driver.findElement(By.xpath(prop.getProperty("mailid"))).sendKeys(prop.getProperty("username"));
		log.info("Entering mailid");

		driver.findElement(By.xpath(prop.getProperty("password1"))).sendKeys(prop.getProperty("password"));
		log.info("Entering password");*/

		
		Thread.sleep(1000); 
		
		
	   
	        	
	        // driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.xpath(prop.getProperty("mailid"))).clear();
	        	driver.findElement(By.xpath(prop.getProperty("mailid"))).sendKeys(worksheet.getRow(i).getCell(0).getStringCellValue());
	       //  driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
	         Thread.sleep(10000);
	         driver.findElement(By.xpath(prop.getProperty("password1"))).clear();
	        	driver.findElement(By.xpath(prop.getProperty("password1"))).sendKeys(worksheet.getRow(i).getCell(1).getStringCellValue());
	         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	         driver.findElement(By.xpath(prop.getProperty("submitbutton"))).click();
				log.info("Clicking submit button");
	        Thread.sleep(1000);
	       // driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
	       // Thread.sleep(2000);
	        try
	        {
	        	WebElement web1 = driver.findElement(By.xpath(".//*[@id='login']/div[1]/div"));
	        	boolean a2 = web1.isDisplayed();
	        	if(a2 = true)
	        	{
	        		cell1 = worksheet.getRow(i).getCell(2);
	        		cell1.setCellValue("Login Fail");
	        		fsIP.close();    
                    FileOutputStream output_file1 = new FileOutputStream(
                            new File("D:\\Sys1\\workspace\\Final.automation\\src\\finalTest\\data.xlsx"));
                    wb.write(output_file1);
                    output_file1.close();
	        		
	        	}
	        }
	        catch(Exception e)
	        {
	        	   cell1 = worksheet.getRow(i).getCell(2);
	                cell1.setCellValue("Login pass,,,");
	                fsIP.close();
	                FileOutputStream output_file1 = new FileOutputStream(new File(
	                        "D:\\Sys1\\workspace\\Final.automation\\src\\finalTest\\data.xlsx"));
	                wb.write(output_file1);
	                output_file1.close();
	                driver.findElement(By.xpath(prop.getProperty("usersetting"))).click();
	        		log.info("Clicking user settings ");
	        		Thread.sleep(10000);
	        		driver.findElement(By.xpath(prop.getProperty("logoutbutton"))).click();
	        		log.info("Clicking logout button ");
	        		Thread.sleep(10000);
	       
	        }
	        
	        

	        
	        }
	}
	

	void logOut() throws Exception {

		// System.out.println("dsa");
		driver.switchTo().defaultContent();

		Thread.sleep(10000);
		File file = new File("D:\\Sys1\\workspace\\Final.automation\\src\\finalTest\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		// Logout...
	//	driver.findElement(By.xpath(prop.getProperty("usersetting"))).click();
	//	log.info("Clicking user settings ");
	//	Thread.sleep(10000);
	//	driver.findElement(By.xpath(prop.getProperty("logoutbutton"))).click();
	//	log.info("Clicking logout button ");
	//	Thread.sleep(10000);
	}

	void browserClose() {
		driver.quit();
	}

}
