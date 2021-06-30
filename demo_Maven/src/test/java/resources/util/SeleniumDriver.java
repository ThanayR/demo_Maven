package resources.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDriver {
	private static WebDriver driver;
	private static SeleniumDriver seleniumDriver;
	private static WebDriverWait wait;
	
	private SeleniumDriver() throws IOException {
		openBrowser();
		wait = new WebDriverWait(driver, Integer.parseInt(readConfigFile("timeout")));
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setUpDriver() throws IOException {
		if (seleniumDriver == null)
			seleniumDriver = new SeleniumDriver();
	}
	
	public void tearDown() {
		if (driver!=null) {
			driver.quit();
			driver = null;
			seleniumDriver = null;
		}
	}	
	
	private static WebDriver openBrowser() throws IOException {
		String browserName = readConfigFile("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", CONSTANTS.chromeDriverPath);			
			driver = new ChromeDriver(); 
		}else if (browserName.equalsIgnoreCase("ie")) {					  
			System.setProperty("webdriver.ie.driver", CONSTANTS.ieDriverPath);			
			driver = new InternetExplorerDriver();			
		}else if (browserName.equalsIgnoreCase("firefox")) {					  
			System.setProperty("webdriver.gecko.driver", CONSTANTS.geckoDriverPath);			
			driver = new FirefoxDriver(); 			
		}else
			System.out.println("Invalid Browser: " + browserName);
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public static String readConfigFile(String key) throws IOException {		
		FileInputStream fis = new FileInputStream(CONSTANTS.configFilePath);
		Properties prop = new Properties();
		prop.load(fis);
		
		return prop.getProperty(key);
	}
	
	public static void navigateURL() throws IOException {
		String url = readConfigFile("url");
		if (getResponseCode()==200 ) {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else {
			System.out.println("Invalid URL");
			System.exit(0);
			}
	}
	
	public static boolean isElementPresent( String xPathExpr) {
		try {
			driver.findElement(By.xpath(xPathExpr));			
		}catch(Exception e) {
			System.out.println("No Such Element: " + xPathExpr);
			return false;
		}
		return true;
	}
	
	public static WebElement getShadowRootElement(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (WebElement) js.executeScript("return arguments[0].shadowRoot",webElement);
	}
	
	public static WebElement getElement(String xPathExpr) {
		return driver.findElement(By.xpath(xPathExpr));
	}
	
	public static List<WebElement> getElements(String xPathExpr) {
		return driver.findElements(By.xpath(xPathExpr));
	}
	
	public static String getWindowHwndID() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String windowID = "";
		
		while(itr.hasNext()) {
			windowID = itr.next();
		}
		
		return windowID;
	}
	
	public static int getResponseCode() throws ClientProtocolException, IOException {
		return Request.Get(readConfigFile("url")).execute().returnResponse().getStatusLine().getStatusCode();
	}
}
