package team.ninja.ds.algo.step.definitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import team.ninja.ds.algo.driver.factory.DriverFactory;
import team.ninja.ds.algo.page.object.LandingPage;
import team.ninja.ds.algo.page.object.HomePage;

public class LandingPageStepDefinitions {

	private LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
	private HomePage homePage = HomePage.getInstance();
	private static String expected, actual;
	private WebDriver driver = DriverFactory.getDriver();
	public SoftAssert softAssert = new SoftAssert();

	@Given("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() { //LandingPage Assertion
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/");	
/*	  expected="https://dsportalapp.herokuapp.com/";
	  actual=DriverFactory.getDriver().getCurrentUrl();
	  assertEquals(expected, actual)  ;
*/	}

	@When("The user clicks the Get Started button") // Clicking the GetStarteed Action
	public void the_user_clicks_the_button() throws InterruptedException {
		//landingPage=new ALandingPage(DriverFactory.getDriver());
		homePage = landingPage.click_Btn();
		System.out.println("homePage :   " + DriverFactory.getDriver().getCurrentUrl());
	}

	@Then("The user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() throws InterruptedException { // HomePage Url Assertion
		expected = "https://dsportalapp.herokuapp.com/home";
		actual = DriverFactory.getDriver().getCurrentUrl();
		System.out.println("url chceck   " + expected + actual);
		Thread.sleep(3000);
		assertEquals(expected, actual);
		softAssert.assertEquals(expected, actual, "passed");
	}

	@Then("user gets the Page Title as {string}") // Homepage Title Assertion
	public void user_gets_the_page_title_as(String string) {
		expected = string;
		actual = landingPage.get_Title();
		System.out.println("title check   " + string + landingPage.get_Title());
		assertEquals(string, landingPage.get_Title());
	}
}
