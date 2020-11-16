package PageObjects;

import resources.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpcomingBikesPage  {
	public WebDriver driver;
	public Properties prop;
	
	By newbikes,upcomingBikes,brand,bikeNames,bikePrice,bikeLaunch;
	
	
	
	
	//constructor
	public UpcomingBikesPage(WebDriver driver,Properties prop1)
	{
		this.driver=driver;
		prop=prop1;
		
		newbikes=By.xpath(prop.getProperty("newBikes"));
		upcomingBikes=By.xpath(prop.getProperty("upcomingbikes"));
		 brand=By.id(prop.getProperty("Brand"));
		 bikeNames=By.xpath(prop.getProperty("bikeName"));
		 bikePrice=By.xpath(prop.getProperty("bikeLaunchPrice"));
		 bikeLaunch=By.xpath(prop.getProperty("bikeLaunchDate"));
		
		
	}
	
	
	public WebElement getNewBikes()
	{
		return driver.findElement(newbikes);
	}
	
    public WebElement getUpcomingBikes()
    {
    	return driver.findElement(upcomingBikes);
    }
    
    public WebElement getBrand()
    {
    	return driver.findElement(brand);
    }
    
    
    
    public List<WebElement> getName()
    {
    	return driver.findElements(bikeNames);
    }
    public List<WebElement> getPrice()
    {
    	return driver.findElements(bikePrice);
    }
    public List<WebElement> getDate()
    {
    	return driver.findElements(bikeLaunch);
    }
}
