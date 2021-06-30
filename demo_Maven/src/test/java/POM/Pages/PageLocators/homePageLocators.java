package POM.Pages.PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class homePageLocators {
	
	@CacheLookup
	@FindBy(xpath="//a[normalize-space()='Test Automation (123)']")
	public static WebElement testAutoSubMenu;
	
	@CacheLookup
	@FindBy(xpath="//a[@target][normalize-space()='Courses']")
	public static WebElement coursesMenu;	
	
}
