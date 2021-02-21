package resources;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport 
{
	public static ExtentReports extent;
	static WebDriver driver;
	static String path= System.getProperty("user.dir")+"//reports//Report.html";
	
    
    public static ExtentReports getReport()
    {
    	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
    	reporter.config().setReportName("Automation Report Status");
    	reporter.config().setDocumentTitle("First Report");
    	reporter.config().setTheme(Theme.DARK);
    	
    	extent=new ExtentReports();
    	extent.attachReporter(reporter);
    	extent.setSystemInfo("Tester", "Aditya Parasher");
    	return extent;
    }
    
    
    
}
