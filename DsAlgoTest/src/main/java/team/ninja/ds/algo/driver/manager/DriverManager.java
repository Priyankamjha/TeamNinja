package team.ninja.ds.algo.driver.manager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public WebDriver driver;
	WebDriverWait explicit_wait_Example;
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public static WebDriver init_driver(String browser, String url) {
		System.out.println("driver : initializing the driver first");

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			threadLocalDriver.set(new ChromeDriver(options));
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			threadLocalDriver.set(new EdgeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			threadLocalDriver.set(new FirefoxDriver());
		} else {
			System.out.println("Please pass in the browser");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return threadLocalDriver.get();
	}
}
