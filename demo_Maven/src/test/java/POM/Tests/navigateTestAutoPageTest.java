package POM.Tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.Pages.PageActions.catalogueTestAutomationPage;
import POM.Pages.PageActions.homePage;
import resources.util.SeleniumDriver;

public class navigateTestAutoPageTest {
	static homePage hp;
	static catalogueTestAutomationPage ctap;
	
  @Test
  public void testNavigateTestAutoPage() throws InterruptedException, IOException {
	  SeleniumDriver.navigateURL();
	  //SeleniumDriver.getDriver().get("http://www.encartalabs.com/");
	  hp.hoverOnCoursesMenu();
	  ctap = hp.navigateToTestAutoPage();	  
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
		/*
		 * String chromeDriverPath = "D:\\SeleniumDump\\chromedriver.exe";
		 * System.setProperty("webdriver.chrome.driver", chromeDriverPath); driver = new
		 * ChromeDriver();
		 */
	  SeleniumDriver.setUpDriver();
	  
	  hp = new homePage();    // Page Objects
	  //hp = PageFactory.initElements(SeleniumDriver.getDriver(), homePageL.class);   // Page Factory
	  ctap = new catalogueTestAutomationPage();
  }

}
