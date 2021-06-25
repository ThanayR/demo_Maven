import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import resources.util.Library;

public class demo_google extends Library {
	public static void main(String[] args) throws IOException, InterruptedException {
		driver = openBrowser();
		navigateURL();
		
		getElement("//input[@name='p']").sendKeys("SLK Software");
		
		Thread.sleep(1000);		
		List<WebElement> items = getElements("//div[@class='_yb_1p7i0' ]/ul/li/span");
		System.out.println("Count of Items: " + items.size());
		
		for(WebElement element: items)
			System.out.println(element.getText());
	} 
}
