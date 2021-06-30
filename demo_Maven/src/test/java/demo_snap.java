import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import resources.util.Library;

public class demo_snap extends Library {
	public static void main(String[] args) throws IOException, InterruptedException {
		driver = openBrowser();
		navigateURL();
		
		File dest = new File("d:\\slk.png");	
		TakesScreenshot snap = ((TakesScreenshot) driver);		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].scrollIntoView()",getElement("//body/div[@id='__next']/section[@id='pane-main']/section[@id='main-container']/div[@class='page-match-finder']/div[@class='container']/div[@class='row']/div[@class='col-16 col-md-16 col-lg-12 main-content-x']/div[@class='match-finder-body']/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a[1]/div[1]/div[1]"));
		//js.executeScript("window.scrollBy(0, 500)");	
		Thread.sleep(2000);
		
		File temp = snap.getScreenshotAs(OutputType.FILE);
		//System.out.println( temp.getAbsolutePath() );		
		
		//FileUtils.copyFile(temp, dest);   // Whole Page		

		WebElement snapArea = getElement("(//div[@class='match-info match-info-FIXTURES'])[10]");

		File subImage = snapArea.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(subImage, dest);
		
		/*
		 * int x = snapArea.getLocation().getX(); int y = snapArea.getLocation().y; int
		 * w = snapArea.getSize().width; int h = snapArea.getSize().getHeight();
		 * 
		 * BufferedImage bf = ImageIO.read(temp); BufferedImage subImage =
		 * bf.getSubimage(x, y, w, h);
		 * 
		 * ImageIO.write(subImage, "", dest);
		 */
	}
}
