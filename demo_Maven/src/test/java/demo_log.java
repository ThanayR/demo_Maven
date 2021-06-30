import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class demo_log {
	public static void main(String[] args) throws InterruptedException {
		String logConfigPath = "C:\\Users\\Ravi\\git\\demo_Maven\\demo_Maven\\src\\test\\java\\resources\\config\\log4j.properties";
		PropertyConfigurator.configure(logConfigPath);
		Logger log = Logger.getLogger("slkLogger");
		
		//Logger log = Logger.getLogger(demo_log.class);
		//BasicConfigurator.configure();
		
		log.debug("It is time for a Tea Break..");
		Thread.sleep(1000);
		
		log.debug("It is time for a Tea Break..2...");
		Thread.sleep(1000);
		
		log.debug("It is time for a Tea Break..3....");
		
		System.out.println("End of Script");
	}
}
