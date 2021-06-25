import java.io.IOException;

import resources.util.Library;

public class demo_calendar extends Library {
	public static void main(String[] args) throws IOException {
		String doj = "20/12/2021";   //dd/mm/yyyy
		String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		String arr[] = doj.split("/");
		String day = arr[0];
		String month = months[Integer.parseInt(arr[1])-1];
		String year = arr[2];
		
		String expMonthYear = month + " " + year;
		System.out.println(expMonthYear);
		
		driver = openBrowser();
		navigateURL();
		
		getElement("//input[@id='ctl00_mainContent_view_date1']").click();
		
		while (! expMonthYear.equalsIgnoreCase(getElement("//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']").getText())) {
			getElement("//span[@class='ui-icon ui-icon-circle-triangle-e']").click();
		}
		
		//body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/a
		//body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[*]/td[*]/a[text()=19]
		//body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[*]/td[*]/a[text()=   day   ]
		
		getElement("//table[1]/tbody[1]/tr[*]/td[*]/a[text()=" + day + "]").click();
		
	}
}
