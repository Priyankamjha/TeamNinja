package team.ninja.ds.algo.hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import team.ninja.ds.algo.driver.factory.DriverFactory;
import team.ninja.ds.algo.utilities.ConfigReader;
import team.ninja.ds.algo.utilities.LoggerLoad;
import static java.util.Objects.isNull;
public class Hooks {
	private static DriverFactory driverFactory;
	private static WebDriver driver;
	private static ConfigReader configReader;
	static Properties prop;
	static WebDriverWait wait ;
	
	
	@BeforeAll(order=0)//will execute 0 and then 1
	public static void beforeAll() throws IOException
	{   
		LoggerLoad.info("Loading Config Properties ");
		configReader =new ConfigReader();
		prop=configReader.init_prop();		
	    driver = DriverFactory.getDriver();
	    if(isNull(driver)) {
			String browserName=prop.getProperty("browser");
			String geturl=prop.getProperty("url");
			LoggerLoad.info("Initializing the DriverFactory class ");
		    LoggerLoad.info(browserName+ " browser is Launching");
			driver=DriverFactory.init_driver(browserName,geturl);	
	    }
	}
	
	@AfterAll(order=0)// will execute after "1" then order 0
	public static void afterAll()
	{
		LoggerLoad.info("Closing Browser");
		driver.quit();
	}


	@After(order=1)//for After it will start from 1 and then 0
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())//take ScreenShot;
		{	
			LoggerLoad.error("Steps Failed , Taking Screenshot");
			String screenShotName=scenario.getName().replaceAll("", "_");
			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath,"image/png", screenShotName);
		}
	}
}