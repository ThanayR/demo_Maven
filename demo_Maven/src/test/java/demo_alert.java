import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.util.Library;

public class demo_alert extends Library {

	@BeforeMethod
	public void setup() throws IOException {
		driver = openBrowser();
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		//driver.quit();
	}
	
  @Test
  public void test_alert() throws IOException, InterruptedException {
		navigateURL();
		//Thread.sleep(20000);  // Minimum
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);  // Maximum //Global
		
		/*
		 * if(isElementPresent("//a[normalize-space()='moneycontrol.com']"))
		 * getElement("//a[normalize-space()='moneycontrol.com']").click();
		 */
		WebDriverWait wait = new WebDriverWait(driver, 35);   // Maximum
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='top_search_wrap']//a[@title='Submit']")));
		getElement("//div[@class='top_search_wrap']//a[@title='Submit']").click();
		
		Alert alt = driver.switchTo().alert();
		System.out.println( alt.getText() );
		Thread.sleep(3000);
		alt.accept();
		
		//Runtime.getRuntime().exec("notepad.exe");
		
		driver.findElement(By.xpath("//li[contains(@class,'menu_l1')]//a[@title='Coronavirus'][normalize-space()='Coronavirus123']")).click();
  }
}
