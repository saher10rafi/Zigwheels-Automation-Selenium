package IdentifyBikesandCars;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ExcelUtils.writeBikesDetails;
import ExcelUtils.writeUsedCarsDetails;
import PageObjects.LoginPage;
import PageObjects.UpcomingBikesPage;
import PageObjects.UsedCarsPage;
import resources.base;

public class IdentifyBikesTest extends base

{
	public WebDriver driver;
	public Properties Prop;
	//UpcomingBikesPage ubp=new UpcomingBikesPage(driver);
	public static Logger log =LogManager.getLogger(IdentifyBikesTest.class);
	 
	
	@BeforeTest

	public void initialize() throws IOException
	{
		
		 driver =initializeDriver();
		 
			
		driver.get(prop.getProperty("URL"));
		log.info("Driver intiated");
	}
	@Test(priority=0)
	public void getTitle()
	{
		String Title=driver.getTitle();
		System.out.println(Title);
		log.info("**********Test case started************");
	}
	@Test(priority=1)
	public void Bikes() throws IOException, InterruptedException
	{
		UpcomingBikesPage ubp=new UpcomingBikesPage(driver,prop);
		Actions act=new Actions(driver);
		
		act.moveToElement(ubp.getNewBikes()).build().perform();
		log.info("Mouse hover to New Bikes");
	}
	@Test(priority=2)
	public void upcomingBikes()
	{
		UpcomingBikesPage ubp=new UpcomingBikesPage(driver,prop);
		ubp.getUpcomingBikes().click();
		log.info("Click on upcoming bikes");
		
	}
	
	
	@Test(priority=3)
	public void selectBrand()
	{  UpcomingBikesPage ubp=new UpcomingBikesPage(driver,prop);
		Select s=new Select(ubp.getBrand());
		s.selectByValue("52");
		log.info("Select the bike brand");
	}
		
		
	
	@Test(priority=4)
	public void getUpcomingBikes()
	{   UpcomingBikesPage ubp=new UpcomingBikesPage(driver,prop);
		List <WebElement>name=ubp.getName();
		List <WebElement>Price=ubp.getPrice();
		List <WebElement>dates=ubp.getDate();
		String[] names=new String[name.size()];
		String[] price=new String[Price.size()];
		String [] date=new String[dates.size()];
		for(int i=0;i<name.size();i++)
		{
		names[i]=name.get(i).getText();
		price[i]=Price.get(i).getText();
		date[i]=dates.get(i).getText();
		//System.out.println(name.get(i).getText()+" "+Price.get(i).getText()+" "+dates.get(i).getText());
		
		
		}
		writeBikesDetails wbd=new writeBikesDetails();
		wbd.bikeDetails(names,price, date);
		log.info("Fetching Upcoming Bikes of Specified Brand");
	}
	
	@Test (priority=5)
	public void usedCars()
	{
		driver.navigate().back();
		UsedCarsPage ucp=new UsedCarsPage(driver,prop);
		Actions act=new Actions(driver);
		
		act.moveToElement(ucp.getUsedCars()).build().perform();
		log.info("Select the used cars");
	}
	@Test(priority=6)
	public void getLocation()
	{  UsedCarsPage ucp=new UsedCarsPage(driver,prop);
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ucp.getLocation().click();
		log.info("Select the Location of used cars");
		}
	@Test(priority=7)
	public void getCarDetails()
	{    UsedCarsPage ucp=new UsedCarsPage(driver,prop);
		List<WebElement> carName=ucp.getCarNames();
		int count=carName.size();
		String[] cars=new String[carName.size()];
		for(int i=0;i<carName.size();i++)
		{
			cars[i]=carName.get(i).getText();
		}
		writeUsedCarsDetails wuc=new writeUsedCarsDetails();
		wuc.CarDetails(cars,count);
		log.info("Fetching Used cars in the selected location");
	}
	@Test(priority=8)
	public void loginInvalidEmail() throws InterruptedException, IOException
	{   driver.navigate().to(prop.getProperty("URL"));
	    //Thread.sleep(3000);
		LoginPage lp=new LoginPage(driver,prop);
		lp.getLogin().click();
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		Thread.sleep(3000);
		lp.getGoogle().click();
		
		String handle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(handle);
	   Thread.sleep(3000);
		lp.getEmail().sendKeys("joe@dfg");
		Thread.sleep(3000);
		lp.getNext().click();
		System.out.println(lp.getError().getText());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./LoginScreenShots/Screen.png"));
		System.out.println("the Screenshot is taken");
		
		driver.switchTo().window(parent);
		log.info("Login with Invalid Email");

	}
	@Test(priority=9)
	public void loginWithoutPassword() throws InterruptedException, IOException
	{  
		LoginPage lp=new LoginPage(driver,prop);
		String parent=driver.getWindowHandle();
		Thread.sleep(3000);
		
		//lp.getLogin().click();
		Thread.sleep(3000);
		lp.getGoogle().click();
		
		String handle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(handle);
	   Thread.sleep(3000);
		lp.getEmail().sendKeys("joshibarobert.jr@gmail.com");
		Thread.sleep(3000);
		lp.getNext().click();
		Thread.sleep(3000);
		lp.getPassword().sendKeys("1234");
		Thread.sleep(3000);
		lp.getNext2().click();
		Thread.sleep(3000);
		
	    lp.getCaptcha().sendKeys("2345esgs");
	    lp.getNext2().click();
	    Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./LoginScreenShots/withoutPassword.png"));
		System.out.println("the Screenshot is taken");
		driver.switchTo().window(parent);
		log.info("Login without the password");
	    
		//System.out.println(lp.getError().getText());
		
		//driver.close();
		
		
		
		
		
	}
	
	@Test(priority=10)
	public void loginWithoutEmail() throws InterruptedException, IOException
	{  
		LoginPage lp=new LoginPage(driver,prop);
		//lp.getLogin().click();
		String parent=driver.getWindowHandle();
		Thread.sleep(3000);
		lp.getGoogle().click();
		
		String handle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(handle);
	     Thread.sleep(3000);
		
		lp.getNext().click();
		System.out.println(lp.getError().getText());
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./LoginScreenShots/withoutEmail.png"));
		System.out.println("the Screenshot is taken");
		
		driver.switchTo().window(parent);
		
		log.info("Login withoud email address");
		
		
	}
	@Test(priority=11)
	public void loginWithoutCaptcha() throws InterruptedException, IOException
	{  
		LoginPage lp=new LoginPage(driver,prop);
		String parent=driver.getWindowHandle();
		//lp.getLogin().click();
		Thread.sleep(3000);
		lp.getGoogle().click();
		
		String handle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(handle);
	   Thread.sleep(3000);
		lp.getEmail().sendKeys("joshibarobert.jr@gmail.com");
		Thread.sleep(3000);
		lp.getNext().click();
		Thread.sleep(3000);
		lp.getPassword().sendKeys("1234");
		Thread.sleep(3000);
		lp.getNext2().click();
		Thread.sleep(3000);
		
		lp.getPassword().sendKeys("1234");
		Thread.sleep(3000);
	    lp.getNext2().click();
	    Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./LoginScreenShots/withoutCaptcha.png"));
		System.out.println("the Screenshot is taken");
	    
		//System.out.println(lp.getError().getText());
		
		driver.switchTo().window(parent);
		log.info("Login without the captcha");
	}

	
	@Test(priority=12)
	public void loginWithoutCaptchaandPassword() throws InterruptedException, IOException
	{  
		LoginPage lp=new LoginPage(driver,prop);
		String parent=driver.getWindowHandle();
		//lp.getLogin().click();
		Thread.sleep(3000);
		lp.getGoogle().click();
		
		String handle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(handle);
	   Thread.sleep(3000);
		lp.getEmail().sendKeys("joshibarobert.jr@gmail.com");
		Thread.sleep(3000);
		lp.getNext().click();
		Thread.sleep(3000);
		lp.getPassword().sendKeys("1234");
		Thread.sleep(3000);
		lp.getNext2().click();
		Thread.sleep(3000);
		
		
	    lp.getNext2().click();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./LoginScreenShots/withoutCaptchaPassword.png"));
		System.out.println("the Screenshot is taken");
	    
		//System.out.println(lp.getError().getText());
		driver.close();
		
		driver.switchTo().window(parent);
		log.info("Login without the Captcha and Password");
	}
	
	@Test(priority=13)
	public void loginTest() throws InterruptedException, IOException
	{  
		LoginPage lp=new LoginPage(driver,prop);
		String parent=driver.getWindowHandle();
		
		Thread.sleep(3000);
		lp.getFacebook().click();
		
		String handle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(handle);
	   Thread.sleep(3000);
		lp.getFmail().sendKeys("joshiba.r@gmail.com");
		
		Thread.sleep(3000);
		lp.getFLogin().click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/FbookInvalidMail.png"));
		System.out.println("the Screenshot is taken");
		driver.switchTo().window(parent);
		log.info("Login with facebook test1");
	    
		
		}
	
	@Test(priority=14)
	public void loginTest2() throws InterruptedException, IOException
	{  
		LoginPage lp=new LoginPage(driver,prop);
		String parent=driver.getWindowHandle();
		
		Thread.sleep(3000);
		lp.getFacebook().click();
		
		String handle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(handle);
	   Thread.sleep(3000);
		
		lp.getFLogin().click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/FbookInvalidMail2.png"));
		System.out.println("the Screenshot is taken");
		driver.switchTo().window(parent);
		log.info("Login with facebook test2");
	    
		}
	
	
	@Test(priority=15)
	public void loginTest3() throws InterruptedException, IOException
	{  
		LoginPage lp=new LoginPage(driver,prop);
		String parent=driver.getWindowHandle();
		
		Thread.sleep(3000);
		lp.getFacebook().click();
		
		String handle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(handle);
	   Thread.sleep(3000);
	   lp.getFmail().sendKeys("joshibarobert.jr@gmail.com");
	   Thread.sleep(3000);
	   lp.getFpass().sendKeys("123456");
	   
		
		lp.getFLogin().click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/FbookInvalidMail3.png"));
		System.out.println("the Screenshot is taken");
		driver.switchTo().window(parent);
		log.info("Login with facebook test3");
	    
		
		}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		log.info("Browser quit");
	}

}
