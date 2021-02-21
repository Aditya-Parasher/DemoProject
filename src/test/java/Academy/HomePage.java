package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.Base;

public class HomePage extends Base
{
	public static Logger log=LogManager.getLogger(HomePage.class);
	public WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException
	{
		
		driver=initializeDriver();
		log.info("Chrome Driver getting started!!");
		
	}
	
	
   @Test(dataProvider="getData")
   public void basePageNavigation(String username,String password) throws IOException
   {
	  //object for LandingPage created in main under PageObject package:
	   log.info("Entering UserName and Password!!");
	   driver.get(prop.getProperty("URL"));
	   LandingPage l=new LandingPage(driver);
	   l.Login().click();
	   
	   l.getUsername().sendKeys(username);
	   l.getPassword().sendKeys(password);
	   l.signIn().click();
   }
   
   
   @AfterTest
 	public void tearDown() throws IOException
 	{
	   
 		driver.quit();
 		log.info("Closing the driver!!");
 	}
   
   //Data Provider for parametrization:
      @DataProvider
      public Object[][] getData()
      {
    	  Object[][] data =new Object[2][2];
    	  data[0][0]="AdityaP786";
    	  data[0][1]="12344";
    	  
    	  data[1][0]="AdityaP01";
    	  data[1][1]="113124";
    	  
    	  return data;
      }
  
}
