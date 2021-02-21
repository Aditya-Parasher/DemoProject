package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base 
{
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
        prop=new Properties();
        FileInputStream fis=new FileInputStream("C:\\Users\\aditya\\workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");// this will trigger the browser from data.properties file but if we want to trigger this from 
        //maven then use 
        //String browserName=System.getProperty("browser");
        //use command mvn test -Dbrowser=chrome in CMD
        
        if(browserName.contains("chrome"))
        {
        	System.setProperty("webdriver.chrome.driver", "C://Users//aditya//Documents//BrowserDrivers//chromedriver.exe");
        	
        	if(browserName.contains("headless"))
        	{
        	   ChromeOptions co=new ChromeOptions();
        	   co.addArguments("--headless"); //to run in headless mode
        	   driver=new ChromeDriver(co);
        	}
        	else{
            driver=new ChromeDriver();
            }
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
        	System.setProperty("webdriver.gecko.driver", "C://Users//aditya//Documents//BrowserDrivers//geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("Internet Explorer"))
        {
        	System.setProperty("webdriver.ie.driver", "C://Users//aditya//Documents//BrowserDrivers//IEDriverServer.exe");
            driver=new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
        return driver;
	}   
	
	
	//screenshot: 
	public String Screenshots(String TestCaseName,WebDriver driver) throws IOException
	{
		String name=System.getProperty("user.dir")+"//Screenshots//"+TestCaseName+".png";
		
		//import commons.io dependency
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(name));
		return name;
	}
   
}
