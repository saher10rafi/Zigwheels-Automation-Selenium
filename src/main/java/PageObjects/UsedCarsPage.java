package PageObjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class UsedCarsPage  {
	public WebDriver driver;
	public Properties prop;
	By usedcars,location,carname;
	
	
	public UsedCarsPage(WebDriver driver,Properties prop1)
	{
		this.driver=driver;
		prop=prop1;
		
		 usedcars=By.xpath(prop.getProperty("usedCars"));
		 location=By.xpath(prop.getProperty("location"));
	     carname=By.xpath(prop.getProperty("carNames"));
	}
	public WebElement getUsedCars()
	{
		return driver.findElement(usedcars);
	}
	public 	WebElement getLocation()
	{
		return driver.findElement(location);
	}
	public List<WebElement> getCarNames()
	{
		return driver.findElements(carname);
	}

}
