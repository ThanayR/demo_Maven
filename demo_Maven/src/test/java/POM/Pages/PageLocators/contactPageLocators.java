package POM.Pages.PageLocators;

import org.openqa.selenium.support.PageFactory;

import resources.util.SeleniumDriver;

public class contactPageLocators {
	public contactPageLocators() {
		PageFactory.initElements(SeleniumDriver.getDriver(), contactPageLocators.class);
	}
}
