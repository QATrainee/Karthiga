package techfetch;


import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Techfetch2 {
	//File file = new File("E:\\workspace\\TechFetch.Automation\\Locator.properties"); 
	WebDriver driver;

	public  Techfetch2(WebDriver driver)
    {    
    	this.driver=driver;
}@BeforeTest
    public void login() throws IOException, InterruptedException
    {
    	File file = new File("D:\\Sys1\\workspace\\Candidate\\Locator.properties"); 
    	FileInputStream fileInput;
    	fileInput = new FileInputStream(file);
    	Properties prop = new Properties();
    	prop.load(fileInput);
    	driver.get(prop.getProperty("URL"));
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Thread.sleep(1000);
    	driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divCandidate']/a")).click();
    	Thread.sleep(1000);
     	driver.findElement(By.xpath(".//*[@id='jsloginpop']")).click();
     	driver.switchTo().defaultContent();
	    driver.switchTo().frame("candidatecontentframe");
		driver.findElement(By.xpath("//.//*[@id='txtemailid']")).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath("//.//*[@id='txtpwd']")).sendKeys(prop.getProperty("Password"));
	driver.findElement(By.xpath("//.//*[@id='btnSubmit']")).click();
 	Thread.sleep(1000);

  
    }@Test
    public void upload() throws Exception
 {
    	File file = new File("D:\\Sys1\\workspace\\Candidate\\Locator.properties"); 
    	FileInputStream fileInput;
    	fileInput = new FileInputStream(file);
    	Properties prop = new Properties();
    	prop.load(fileInput);
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame("contentframe");
    	driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[4]/a/img")).click();
    	Thread.sleep(1000);
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame("replacedoccontentframe");
    	Thread.sleep(1000);
    	 driver.findElement(By.id("resumeupload")).clear();
	       driver.findElement(By.id("resumeupload")).sendKeys(prop.getProperty("path"));
    	Thread.sleep(10000);
    	//WebElement Element = driver.findElement(By.xpath(".//*[@id='dupupload2']/div/div/div"));
    	// Element.sendKeys("C:\\hai.doc");
    	driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
    	Thread.sleep(3000);
driver.findElement(By.id("btnClose")).click();
Thread.sleep(5000);


    }
    public void profile() throws Exception
    {
    	
		driver.switchTo().defaultContent();
    driver.switchTo().frame("contentframe");
	driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[4]/td[5]/a/img")).click();
    	
    	
    	File file = new File("D:\\Sys1\\workspace\\Candidate\\Locator.properties"); 
    	FileInputStream fileInput;
    	fileInput = new FileInputStream(file);
    	Properties prop = new Properties();
    	prop.load(fileInput);
    /*	driver.switchTo().defaultContent();
    	driver.switchTo().frame("candidatecontentframe");
    	Thread.sleep(1000);  

		driver.switchTo().defaultContent();
    driver.switchTo().frame("contentframe");
	driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[4]/td[5]/a/img")).click();   */
    	
    	Set<String> Wi = driver.getWindowHandles();
    	System.out.println("No of Windows:"+Wi.size());
    	Iterator it=Wi.iterator();
    	//String main=(String) it.next();
    	System.out.println(it.next());
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Thread.sleep(5000);
    	
    	
           Wi = driver.getWindowHandles();
    	System.out.println("No of Windows:"+Wi.size());
    	it=Wi.iterator();
    	it=Wi.iterator();
    	String mmm=(String) it.next();
    	String nnn=(String) it.next();
    	System.out.println(mmm);
    	System.out.println(nnn);
    	driver.switchTo().window(nnn);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Thread.sleep(10000);
    	driver.findElement(By.cssSelector("#download")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Thread.sleep(2000);
    	driver.findElement(By.xpath(".//*[@id='forward']")).click(); 
		  Thread.sleep(1000);
		  driver.switchTo().defaultContent();
		  driver.switchTo().frame("jsforwardprofilecontentframe");
		  driver.findElement(By.xpath(".//*[@id='txtTo']")).sendKeys(prop.getProperty("mailid")); 
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//*[@id='btnsendmail']")).click(); 
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//*[@id='btnPnlClose']")).click(); 
     driver.close();
  	driver.switchTo().window(mmm);
    	
    }
    public void myresume() throws Exception
    {
    	

    	File file = new File("D:\\Sys1\\workspace\\Candidate\\Locator.properties"); 
    	FileInputStream fileInput;
    	fileInput = new FileInputStream(file);
    	Properties prop = new Properties();
    	prop.load(fileInput);
    	//driver.switchTo().defaultContent();
    	//driver.switchTo().frame("contentframe");

    	driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[2]/a")).click();
    	driver.findElement(By.xpath(".//*[@id='addresumetab']")).click();
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame("contentframe");
    	
    	Thread.sleep(1000);
    	driver.findElement(By.xpath(".//*[@id='txtFName']")).sendKeys(prop.getProperty("fname")); 
    	driver.findElement(By.xpath(".//*[@id='txtMName']")).sendKeys(prop.getProperty("mname")); 
    	driver.findElement(By.xpath(".//*[@id='txtLName']")).sendKeys(prop.getProperty("lname")); 
    	Thread.sleep(2000);
    	Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='ddsCountry']")));
    	oSelect.selectByIndex(12);
    	driver.findElement(By.xpath(".//*[@id='txtCity']")).sendKeys(prop.getProperty("city"));
    	driver.findElement(By.xpath(".//*[@id='txtPhoneM']")).sendKeys(prop.getProperty("pho"));
    	driver.findElement(By.xpath(".//*[@id='txtPhoneA']")).sendKeys(prop.getProperty("pht"));
    	driver.findElement(By.xpath(".//*[@id='txtPhoneW']")).sendKeys(prop.getProperty("phth"));
    	driver.findElement(By.xpath(".//*[@id='txtExtn']")).sendKeys(prop.getProperty("phe"));

    	Select oSelect1 = new Select(driver.findElement(By.xpath(".//*[@id='ddlPreferredTime']")));
    	oSelect1.selectByIndex(2);
    	Select oSelect2 = new Select(driver.findElement(By.xpath(".//*[@id='ddlPhone']")));
    	oSelect2.selectByIndex(2);
    	Select oSelect3 = new Select(driver.findElement(By.xpath(".//*[@id='ddsCitizen']")));
    	oSelect3.selectByIndex(2);
    	driver.findElement(By.xpath(".//*[@id='chkWorkAuthorizationTNEAD']")).click();
    	Select oSelect4 = new Select(driver.findElement(By.xpath(".//*[@id='ddltneadlist']")));
    	oSelect4.selectByIndex(2);
    	driver.findElement(By.id("resumeupload")).clear();
        driver.findElement(By.id("resumeupload")).sendKeys(prop.getProperty("upload"));
    	Thread.sleep(10000);
    	driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
    	Thread.sleep(100);
    	driver.switchTo().defaultContent();
	    driver.switchTo().frame("contentframe");
	    Thread.sleep(1000);
	    driver.findElement(By.id("rdBachelor")).click();
	    new Select(driver.findElement(By.id("ddlExpectedSalaryYear"))).selectByVisibleText("$10K");
	    new Select(driver.findElement(By.id("ddlExpectedSalaryHour"))).selectByVisibleText("$15");
	    driver.findElement(By.id("txtJobTitle")).clear();
	    driver.findElement(By.id("txtJobTitle")).sendKeys("no");
	    new Select(driver.findElement(By.id("ddsTotalExperience"))).selectByVisibleText("17");
	    driver.findElement(By.cssSelector("option[value=\"17\"]")).click();
	    new Select(driver.findElement(By.id("ddsUSAExperience"))).selectByVisibleText("15");
	    driver.findElement(By.id("txtResumeTitle")).clear();
	    driver.findElement(By.id("txtResumeTitle")).sendKeys("ytry");
	    driver.findElement(By.id("resumeupload")).clear();
	    driver.findElement(By.id("resumeupload")).sendKeys(prop.getProperty("uploadfile"));
	    Thread.sleep(10000);
	    driver.findElement(By.id("btnProfessional")).click();
	    Thread.sleep(1000);
	
	  //  driver.switchTo().defaultContent();
	  //  driver.switchTo().frame("contentframe");
	   
	    //driver.findElement(By.linkText("*Skills(Incomplete)")).click();
	    new Select(driver.findElement(By.id("ddlSpecializedArea"))).selectByVisibleText("Java, J2EE");
	    new Select(driver.findElement(By.id("ddlSpecializedSkill"))).selectByVisibleText("Java Front End");
	    driver.findElement(By.id("txtSkill1")).clear();
	    driver.findElement(By.id("txtSkill1")).sendKeys(prop.getProperty("skill"));
	    new Select(driver.findElement(By.id("ddlYears1"))).selectByVisibleText("2");
	    driver.findElement(By.id("btnSkills")).click();
	    Thread.sleep(10000);
	   // driver.findElement(By.id("Skillsli")).click();
	 
	  //  driver.findElement(By.cssSelector("#Preferencesli > a")).click();
	    driver.findElement(By.id("chkBusinessDomaintelecom")).click();
	    driver.findElement(By.id("radPublishToAll")).click();
	    driver.findElement(By.id("chkprefjobyes")).click();
	    driver.findElement(By.id("btnPreferences")).click();
	    Thread.sleep(10000);
	    driver.findElement(By.id("txtKeywords")).clear();
	    driver.findElement(By.id("txtKeywords")).sendKeys(prop.getProperty("key"));
	    driver.findElement(By.id("chkcontarctjobtype")).click();
	    driver.findElement(By.id("contracttype")).click();
	    driver.findElement(By.id("chkpermanentjobtype")).click();
	    driver.findElement(By.id("txtJobwithtitle")).clear();
	    driver.findElement(By.id("txtJobwithtitle")).sendKeys(prop.getProperty("title"));
	    new Select(driver.findElement(By.id("ddlYears"))).selectByVisibleText("2");
	    driver.findElement(By.cssSelector("#ddlYears > option[value=\"2\"]")).click();
	   // new Select(driver.findElement(By.id("lbPriorityList"))).selectByVisibleText("Florida (FL)");
	   // driver.findElement(By.xpath("//div[@onclick='javascript: OptSelect();']")).click();
	    //driver.findElement(By.xpath("//div[@onclick='javascript: OptUnSelect();']")).click();
	    driver.findElement(By.id("txtAlertName")).clear();
	    driver.findElement(By.id("txtAlertName")).sendKeys(prop.getProperty("alert"));
	    driver.findElement(By.id("btnJobAlert")).click();
	    
	  }
    public void myjob() throws Exception
    {
    	File file = new File("D:\\Sys1\\workspace\\Candidate\\Locator.properties"); 
    	FileInputStream fileInput;
    	fileInput = new FileInputStream(file);
    	Properties prop = new Properties();
    	prop.load(fileInput);
    	
    	driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[3]/a")).click();
    	 driver.findElement(By.id("fetchjobstab")).click();
    	 Thread.sleep(1000);
    	 driver.switchTo().defaultContent();
   	    driver.switchTo().frame("contentframe");
    	    driver.findElement(By.id("txtKeyword")).clear();
    	    driver.findElement(By.id("txtKeyword")).sendKeys(prop.getProperty("keyword"));
    	    driver.findElement(By.id("rbKeywordsAll")).click();
    	    new Select(driver.findElement(By.id("ddlCountry"))).selectByVisibleText("India");
    	    new Select(driver.findElement(By.id("ddlSpecializedArea"))).selectByVisibleText("Java, J2EE");
    	    driver.findElement(By.id("li1")).click();
        
    	    Thread.sleep(1000);
    	    driver.findElement(By.id("txtcity")).clear();
    	    driver.findElement(By.id("txtcity")).sendKeys(prop.getProperty("cityo"));
    	   // Alert A3 = driver.switchTo().alert();
    	    //A3.accept();
    	   // driver.findElement(By.cssSelector("i.fa.fa-forward")).click();
    	    //driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
    	    //driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
    	   // driver.findElement(By.id("chkRemote")).click();
    	   // driver.findElement(By.cssSelector("i.fa.fa-forward")).click();
    	   // driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
    	  //  driver.findElement(By.cssSelector("i.fa.fa-backward")).click();
    	    driver.findElement(By.id("chkPreferredEmployment_5")).click();
    	    driver.findElement(By.id("chkWorkAuthorization_1")).click();
    	    driver.findElement(By.id("chkWorkAuthorization_5")).click();
    	    driver.findElement(By.id("chkWorkAuthorization_5")).click();
    	    driver.findElement(By.id("chkWorkAuthorization_4")).click();
    	    driver.findElement(By.id("chkWorkAuthorization_3")).click();
    	    driver.findElement(By.id("chkWorkAuthorization_2")).click();
    	    driver.findElement(By.id("chkWorkAuthorization_1")).click();
    	    driver.findElement(By.id("chkRemote")).click();
    	    driver.findElement(By.id("chkRemote")).click();
    	    driver.findElement(By.id("txtExcludeWords")).clear();
    	    driver.findElement(By.id("txtExcludeWords")).sendKeys(prop.getProperty("exkey"));
    	    new Select(driver.findElement(By.id("ddlJobPost"))).selectByVisibleText("2 Days");
    	    driver.findElement(By.id("btnFetchJobs")).click();
    }
    
    
    public void features() throws Exception
    {
    	driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='demandindextab']")).click();
		
Thread.sleep(2000);
driver.switchTo().frame("contentframe");
driver.findElement(By.xpath(".//*[@id='ddlprofile']")).click();

Select select = new Select(driver.findElement(By.id("ddlprofile")));
List<WebElement> l = select.getOptions();

Select select1=new Select(driver.findElement(By.xpath(".//*[@id='ddlspecializedarea']")));
List<WebElement> l1 = select1.getOptions();

Select select2=new Select(driver.findElement(By.xpath(".//*[@id='ddlmonthyear']")));
List<WebElement> l2 = select2.getOptions();

Select select3=new Select(driver.findElement(By.xpath(".//*[@id='ddlstate']")));
List<WebElement> l3 = select3.getOptions();


for (int i=0;i<l.size();i++)
{
select.selectByIndex(i);
for(int i1=0;i1<l1.size();i1++)
{
select1.selectByIndex(i1);
for(int i2=0;i2<l2.size();i2++)
{
	select2.selectByIndex(i2);
	for(int i3=0;i3<l3.size();i3++)
	{
		select3.selectByIndex(i3);
driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
Thread.sleep(5000);
}
}
}
}

    }
    
@AfterTest
public void logout() throws Exception
{



	//Switching to main window

	driver.switchTo().defaultContent();
	
	Thread.sleep(10000);

	//Logout...
	driver.findElement(By.xpath(".//*[@id='drop7']/img")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath(".//*[@id='mini-nav']/li/ul/li[4]/div/input")).click();
	Thread.sleep(10000);
	  
}
}


	

    	
    
    

