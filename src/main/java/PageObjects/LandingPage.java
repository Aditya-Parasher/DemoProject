package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	
	
	//constructor:
    public LandingPage(WebDriver driver)
    {
   	 this.driver=driver;
   	 
    }
    
      //objects:
	
	  private By LoginClick=By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']"); 
	  //private is used to avoid these objects from getting accessed by other classes, to access these use public methods-encapsulation
	  private By Username=By.name("email");
	  private  By Password=By.name(" password");
	  private By Sign_in=By.cssSelector("input[name='commit']");
	//main page: 
	  private By Title=By.xpath("//div[@class='text-center']/h2");
	  private By NavigationBar=By.cssSelector("[class='nav navbar-nav navbar-right']"); 
	  
	  
	  public WebElement getTitle()
	     {
	    	return driver.findElement(Title); 
			
	     }
	  
	  public WebElement getNavigationBar()
	     {
	    	return driver.findElement(NavigationBar); 
			
	     }
   
     
     public WebElement Login()
     {
    	return driver.findElement(LoginClick); 
		
     }
     
     public WebElement getUsername()
     {
    	return driver.findElement(Username); 
		
     }
     
     public WebElement getPassword()
     {
    	return driver.findElement(Password); 
		
     }
     
     public WebElement signIn()
     {
    	return driver.findElement(Sign_in); 
		
     }
}
