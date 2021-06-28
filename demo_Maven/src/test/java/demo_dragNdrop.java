import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import resources.util.Library;

public class demo_dragNdrop extends Library {
	public static void main(String[] args) throws IOException {
		driver = openBrowser();
		navigateURL();

		JavascriptExecutor js = (JavascriptExecutor) driver;		
		//js.executeScript("arguments[0].scrollIntoView()",getElement("//iframe"));
		js.executeScript("window.scrollBy(0, 200)");
		
		driver.switchTo().frame(getElement("//iframe"));		
		
		WebElement draggable = getElement("//div[@id='draggable']");
		WebElement droppable = getElement("//div[@id='droppable']");

		Actions actions = new Actions( driver );
		actions.dragAndDrop(draggable, droppable).build().perform();		
	}
}
