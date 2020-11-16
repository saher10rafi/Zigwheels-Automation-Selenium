package IdentifyBikesandCars;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import resources.base;

public class report {
	ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/automation.html");
	//reporter.config().setReportName("Web Automation Results");
	//reporter.config().setDocumentTitle("Test Results");
	
	  ExtentReports extent =new ExtentReports();
	  public static WebDriver driver;
	  public static Properties prop;
	  @BeforeSuite
	  private  void setup() 
	  {
	  	 try{
	  	// TODO Auto-generated method stub
	  	 extent.attachReporter(reporter);
	  	 ExtentTest Test1 = extent.createTest("Test1", "Test to validate functionality of opening chrome");
	  	 Test1.log(Status.INFO, "Starting the 1st Testcase");
	  	 IdentifyBikesTest implement = new IdentifyBikesTest();
	  	 Test1.info("Opening chrome");
	  	 implement.initialize();
	  	 Test1.pass("Passed");
	  	 driver=base.initializeDriver();
	  	 }
	  	 catch(Exception e){
	  		 e.printStackTrace();
	  	 }
	   }
	   @Test(priority = 0)
	  	public void Title() {
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test2 = extent.createTest("Test1", "Test to validate functionality get the tiltles for upcoming bikes ");
	  		 Test2.log(Status.INFO, "Starting the 2nd Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test2.info("This will get the tiltles for upcoming bikes");
	  		 implement.getTitle();
	  		 Test2.pass("Passed");
	  }
	   @Test(priority = 0)
	  	public void Bikes() throws IOException, InterruptedException {
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test3 = extent.createTest("Test1", "Test to validate functionality of Bikes tab ");
	  		 Test3.log(Status.INFO, "Starting the 3rd Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test3.info("Help to choose Bikes");
	  		 implement.Bikes();
	  		 Test3.pass("Passed");
	  }
	   
	  @Test(priority = 2)
	  	public void upcomingBikes() {
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test4 = extent.createTest("Test1", "Test to validate functionality choosing upcoming bikes ");
	  		 Test4.log(Status.INFO, "Starting the 4th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test4.info("to choose upcoming bikes");
	  		 implement.upcomingBikes();
	  		 Test4.pass("Passed");
	  }
	   @Test(priority = 3)
	  	public void selectBrand() {
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test5 = extent.createTest("Test1", "Test to validate functionality of choosing manufacture brands ");
	  		 Test5.log(Status.INFO, "Starting the 5th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test5.info("To choose the manufacture Brand");
	  		 implement.selectBrand();
	  		 Test5.pass("Passed");
	  }
	   @Test(priority = 4)
	  	public void getUpcomingBikes() {
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test6 = extent.createTest("Test1", "Test to validate functionality get the details of upcoming bikes ");
	  		 Test6.log(Status.INFO, "Starting the 6th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test6.info("This will get the details of upcoming bikes");
	  		 implement.getUpcomingBikes();
	  		 Test6.pass("Passed");
	  }
	   @Test(priority = 5)
	  	public void usedCars() {
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test7 = extent.createTest("Test1", "Test to validate functionality to choose used cars ");
	  		 Test7.log(Status.INFO, "Starting the 7th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test7.info("To choose udes cars");
	  		 implement.usedCars();
	  		 Test7.pass("Passed");
	  }
	   @Test(priority = 6)
	  	public void getLocation() {
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test8 = extent.createTest("Test1", "Test to validate functionality get location ");
	  		 Test8.log(Status.INFO, "Starting the 8th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test8.info("This will get the location");
	  		 implement.getLocation();
	  		 Test8.pass("Passed");
	  }
	   @Test(priority = 7)
	  	public void getCarDetails() {
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test9 = extent.createTest("Test1", "Test to validate functionality get details of used cars ");
	  		 Test9.log(Status.INFO, "Starting the 9th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test9.info("This will get the details of used cars ");
	  		 implement.getCarDetails();
	  		 Test9.pass("Passed");
	  }
	   
	   @Test(priority = 8)
	  	public void loginInvalidEmail() 
	   {
	  	 try{
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test10 = extent.createTest("Test1", "Test to validate functionality of login with invalid email ");
	  		 Test10.log(Status.INFO, "Starting the 10th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test10.info("login with invalid email");
	  		 implement.loginInvalidEmail();
	  		 Test10.pass("Passed");
	  	 }catch(Exception e){
	  		 e.printStackTrace();
	  	 }
	  }
	   @Test(priority = 9)
	  	public void loginWithoutPassword()  
	   {
	  	 try{
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test11 = extent.createTest("Test1", "Test to validate functionality login without password ");
	  		 Test11.log(Status.INFO, "Starting the 11th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test11.info("login without password");
	  		 implement.loginWithoutPassword();
	  		 Test11.pass("Passed");
	   }
	   catch(Exception e)
	   {
	  	 e.printStackTrace();
	   }
	  }
	   @Test(priority = 10)
	  	public void loginWithoutEmail() 
	   {
	  	 try{
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test12 = extent.createTest("Test1", "Test to validate functionality of login without email ");
	  		 Test12.log(Status.INFO, "Starting the 12th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test12.info("login without email");
	  		 implement.loginWithoutEmail();
	  		 Test12.pass("Passed");
	  	 }catch(Exception e)
	  	 {
	  		 e.printStackTrace();
	  	 }
	  }
	   @Test(priority = 11)
	  	public void loginWithoutCaptcha() 
	   {
	  	 try{
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test13 = extent.createTest("Test1", "Test to validate functionality for login without captcha ");
	  		 Test13.log(Status.INFO, "Starting the 13th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test13.info("login without captcha ");
	  		 implement.loginWithoutCaptcha();
	  		 Test13.pass("Passed");
	  	 }catch(Exception e)
	  	 {
	  		 e.printStackTrace();
	  	 }
	  }
	   @Test(priority = 12)
	  	public void loginWithoutCaptchaandPassword() 
	   {
	  	 try{
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test14 = extent.createTest("Test1", "Test to validate functionality login without capture and password");
	  		 Test14.log(Status.INFO, "Starting the 14th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test14.info("login without capture and password");
	  		 implement.loginWithoutCaptchaandPassword();
	  		 Test14.pass("Passed");
	  	 }
	  	 catch(Exception e)
	  	 {
	  		 e.printStackTrace();
	  	 }
	  }
	   @Test(priority = 13)
	  	public void loginTest() 
	  {
	  	 try{
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test15 = extent.createTest("Test1", "Test to validate functionality for login test ");
	  		 Test15.log(Status.INFO, "Starting the 15th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test15.info("login test");
	  		 implement.loginTest();
	  		 Test15.pass("Passed");
	  	 }catch(Exception e){
	  		 e.printStackTrace();
	  	 }
	  }
	   @Test(priority = 14)
	  	public void loginTest2() 
	   {
	  	 try{
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test16 = extent.createTest("Test1", "Test to validate functionality for login test ");
	  		 Test16.log(Status.INFO, "Starting the 16th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test16.info("login test");
	  		 implement.loginTest2();
	  		 Test16.pass("Passed");
	  	 }
	  	 catch(Exception e)
	  	 {
	  		 e.printStackTrace();
	  	 }
	  }
	   @Test(priority = 14)
	  	public void loginTest3()  
	   {
	  	 try{
	  		 extent.attachReporter(reporter);
	  		 ExtentTest Test17 = extent.createTest("Test1", "login test ");
	  		 Test17.log(Status.INFO, "Starting the 17th Testcase");
	  		 IdentifyBikesTest implement = new IdentifyBikesTest();
	  		 Test17.info("login test");
	  		 implement.loginTest3();
	  		 Test17.pass("Passed");
	  	 }catch(Exception e){
	  		 e.printStackTrace();
	  	 }
	  }
	   
	   
	   @AfterSuite
	  	public void closeBrowser() 
	  	{
	  	    extent.flush();

	  		driver.quit();
	  	}
}
