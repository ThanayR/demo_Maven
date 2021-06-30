package POM.Pages.PageActions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import POM.Pages.PageLocators.homePageLocators;
import resources.util.SeleniumDriver;

public class homePage {
	static homePageLocators hplocators = new homePageLocators();
	
	//static WebElement coursesMenu = driver.findElement(By.xpath("//a[@target][normalize-space()='Courses']"));
	//static WebElement testAutoSubMenu = driver.findElement(By.xpath("//a[normalize-space()='Test Automation (123)']"));	
	
	public homePage() {
		PageFactory.initElements(SeleniumDriver.getDriver(), hplocators);
	}
	
	public homePage search() {	
		return new homePage();
	}
	
	public homePage hoverOnCoursesMenu() throws InterruptedException {			
		//WebElement coursesMenu = driver.findElement(By.xpath("//a[@target][normalize-space()='Courses']"));
		Actions actions = new Actions( SeleniumDriver.getDriver() );
		actions.moveToElement(hplocators.coursesMenu).perform();
		Thread.sleep(3000);		
		return this;
	}
	
	public catalogueTestAutomationPage navigateToTestAutoPage() {		
		//driver.findElement(By.xpath("//a[normalize-space()='Test Automation (123)']")).click();
		hplocators.testAutoSubMenu.click();
		return new catalogueTestAutomationPage();
	}
}
