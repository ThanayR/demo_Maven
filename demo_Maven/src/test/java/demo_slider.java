import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import resources.util.Library;

public class demo_slider extends Library {
	public static void main(String[] args) throws IOException {
		driver = openBrowser();
		navigateURL();

		driver.switchTo().frame(getElement("//iframe[@class='demo-frame']"));		
		
		WebElement slider = getElement("//div[@id='slider']/span");
		WebElement holder = getElement("//div[@id='slider']");

		Actions actions = new Actions( driver );
		//actions.dragAndDropBy(slider, holder.getSize().getWidth()/2, 0).perform();
		actions.clickAndHold(slider).moveByOffset(200, 0).release().perform();
	}
}
