import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import resources.util.Library;

public class demo_Menu extends Library {
	public static void main(String[] args) throws IOException, InterruptedException {
		driver = openBrowser();
		navigateURL();
		
		//WebElement coursesMenu = getElement("//a[@target][normalize-space()='Courses']");
		//Actions actions = new Actions( driver );
		//actions.moveToElement(coursesMenu).perform();
		
		//Thread.sleep(3000);
		//getElement("//a[normalize-space()='Test Automation (123)']").click();
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click()",getElement("//a[normalize-space()='Test Automation (123)']"));
	}
}
