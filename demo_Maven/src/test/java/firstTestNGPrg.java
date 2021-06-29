import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firstTestNGPrg {
	// Annotations
	//Test abc = new Test();
	
	@BeforeTest    
	public void test_before() {
		
		System.out.println("Inside 1st testNG Class $$$$$ beforeTest");
	}
	
	@AfterTest  	
	public void test_after() {
		System.out.println("Inside 1st testNG Class $$$$$ afterTest");
	}
	
	@BeforeSuite    
	public void suite_before() {
		System.out.println("Inside 1st testNG Class ######## beforeSuite");
	}
	
	@AfterSuite  	
	public void suite_after() {
		System.out.println("Inside 1st testNG Class ######## afterSuite");
	}
	
	@BeforeClass (alwaysRun = true)   // once before 1st Test
	public void class_before() {
		System.out.println("Inside 1st testNG Class ******* beforeClass => DB Connectivity");
	}
	
	@AfterClass  	// once after last Test
	public void class_after() {
		System.out.println("Inside 1st testNG Class ******* afterClass => DB Disconnected");
	}
	
	/*
	 * @Parameters({"browser"})
	 * 
	 * @BeforeMethod (alwaysRun = true) // before each test public void
	 * method_before(String browserName) { System.out.
	 * println("Inside 1st testNG Class ======== beforeMethod => Open Browser " +
	 * browserName); }
	 */

	@BeforeMethod(groups = {"PerformanceTest"}) 
	public void method_before() {
		System.out.println("Inside 1st testNG Class ======== beforeMethod => PerformanceTests");
	}
	
	@AfterMethod  	// after each test
	public void method_after() {
		System.out.println("Inside 1st testNG Class ======== afterMethod => Close Browser");
	}
	
	//@Test(groups = {"SanityTest"})
	@Test(priority = 5)
	public void test1() {
		
		System.out.println("Inside 1st testNG Class => Test Case # 1");
		
	}
	
	//@Test(enabled = false)
	//@Test(groups = {"PerformanceTest"})
	@Test(priority = 0, groups = {"PerformanceTest"})
	public void test2() {
		
		System.out.println("Inside 1st testNG Class => Test Case # 2");
	}
	
}
