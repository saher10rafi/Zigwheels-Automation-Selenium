package PageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LoginPage  {
	
	public WebDriver driver;
	public Properties prop;
	By login,google,email,next,error,password,captcha,next2,password1,next3 ,Facebook,FEmail,FPass,FLogin;
	
 
    
    
	public LoginPage(WebDriver driver,Properties prop1) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		prop=prop1;
		 login=By.xpath(prop.getProperty("login"));
		 google=By.xpath(prop.getProperty("google"));
		 email=By.xpath(prop.getProperty("email"));
		 next=By.xpath(prop.getProperty("next"));
		 error=By.xpath(prop.getProperty("error"));
	     password=By.xpath(prop.getProperty("password"));
	     captcha=By.xpath(prop.getProperty("captcha"));
	     next2=By.xpath(prop.getProperty("next2"));
         password1=By.xpath(prop.getProperty("password1"));
	     next3=By.xpath(prop.getProperty("next3"));
	     Facebook=By.xpath(prop.getProperty("facebook"));
	     FEmail=By.xpath(prop.getProperty("femail"));
		FPass=By.xpath(prop.getProperty("fpass"));
		FLogin=By.xpath(prop.getProperty("flogin"));
	}

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
    public WebElement getGoogle()
    {
    	return driver.findElement(google);
    }
    public WebElement getFacebook()
    {
    	return driver.findElement(Facebook);
    }
    public WebElement getEmail()
    {
    	return driver.findElement(email);
    }
    public WebElement getNext()
    {
    	return driver.findElement(next);
    }
    
    public WebElement getError()
    {
    	return driver.findElement(error);
    }
    public WebElement getPassword()
    {
    	return driver.findElement(password);
    }
    public WebElement getCaptcha()
    {
    	return driver.findElement(captcha);
    }
    public WebElement getNext2()
    {
    	return driver.findElement(next2);
    }
    
    public WebElement getNext3()
    {
    	return driver.findElement(next3);
    }
    public WebElement getFmail()
    {
    	return driver.findElement(FEmail);
    }
    public WebElement getFpass()
    {
    	return driver.findElement(FPass);
    }
    public WebElement getFLogin()
    {
    	return  driver.findElement(FLogin);
    }
    
    
    
}
