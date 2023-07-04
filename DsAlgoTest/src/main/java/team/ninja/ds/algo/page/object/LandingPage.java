package team.ninja.ds.algo.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import team.ninja.ds.algo.driver.factory.DriverFactory;

public class LandingPage {
private WebDriver driver=DriverFactory.getDriver();
	
	
	@FindBy(xpath="//button[text()='Get Started']")
	WebElement getStarted_btn;
	
	@FindBy(xpath="//a[text()='NumpyNinja']")
	WebElement getTitle;
	
    public LandingPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    public HomePage click_Btn() throws InterruptedException
    {   Thread.sleep(3000);
    	getStarted_btn.click();
		return new HomePage(driver);    	
    }
    
    public String get_Title()
    {    	
    	return getTitle.getText();    			
    }
}
