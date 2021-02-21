package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.Base;

public class ValidateTitle_NavigationBar extends Base
{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(ValidateTitle_NavigationBar.class);
	
	@BeforeTest
	public void Initialize() throws IOException
	{
		log.info("Starting the chrome driver!!");
		driver=initializeDriver();
		
	}
	
	@Test
	public void getTitle() throws IOException
	{
		  driver.get(prop.getProperty("URL"));
          LandingPage l=new LandingPage(driver);
          l.getNavigationBar().isDisplayed();
          log.info("Passing Assert statements!!");
          Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
          Assert.assertFalse(l.getNavigationBar().isDisplayed());
          
	}
	
	@AfterTest
  	public void tearDown() throws IOException
  	{
		log.info("Closing the Browser!!");
  		driver.quit();
  	}
}
