import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.util.Library;

public class iFrame_Test extends Library {
	@BeforeMethod
	public void setup() throws IOException {
		driver = openBrowser();
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		//driver.quit();
	}
	
	@Test
	public void test_iFrame() throws IOException {
		navigateURL();
		
		if(isElementPresent("//img[@class='popupCloseButton']"))
			getElement("//img[@class='popupCloseButton']").click();
		
		getElement("//button[@ng-if='mainctrl.userStatus == false ']").click();
		getElement("//a[@class='btn-primary login-url']").click();
		
		getElement("(//div[@class='pdtb25 text-center']/a)[1]").click();
		
		//driver.switchTo().frame(0);
		//driver.switchTo().frame("login_page");
		
		driver.switchTo().frame(getElement("//frame[@scrolling='yes']"));
		getElement("//input[@name='fldLoginUserId']").sendKeys("slk");		
		
		// Nested Frame
		//driver.switchTo().frame(getElement("//frame[@scrolling='yes']"));
		//getElement("").click();
		
		// Switching to Parent Frame
		//driver.switchTo().parentFrame();
		//getElement("").click();
		
		//driver.switchTo().window(getWindowHwndID());
		driver.switchTo().defaultContent();  // switching from a frame to Top Window or child frame to parent frame
	}
}
