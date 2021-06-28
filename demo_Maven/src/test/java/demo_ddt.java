import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.util.CONSTANTS;
import resources.util.Xlsx_Reader;

public class demo_ddt {
	
  @Test(dataProvider = "dp1")
  public void test5(String name, String salary) {
	  System.out.println(name + " ---- " + salary);
  }
  
  @DataProvider(name = "dp1")
  public Object[][] supplyData() {	 
		Xlsx_Reader xlsx = new Xlsx_Reader(CONSTANTS.testDataFilePath);
		int rowCount = xlsx.getRowCount("Sheet1");
		int colCount = xlsx.getColumnCount("Sheet1");
		
		System.out.println( "Row Count: " + rowCount);
		System.out.println( "Column Count: " + colCount );
		
	  Object[][] data = new Object[rowCount-1][colCount];	
	  
	  for(int rowNum = 2; rowNum <= rowCount; rowNum++)
		  for(int colNum = 0; colNum < colCount; colNum++)
			  data[rowNum-2][colNum] = xlsx.getCellData("Sheet1", colNum, rowNum);
	  
	  return data;
		/*
		 * Object[][] data = new Object[3][2]; data[0][0] = "Nupur"; data[0][1] = 10000;
		 * 
		 * data[1][0] = "Ganesh"; data[1][1] = 15000;
		 * 
		 * data[2][0] = "Mayuresh"; data[2][1] = 30000;
		 * 
		 * return data;
		 */
  }
  
  @DataProvider
  public Object[][] supplyDate2() {
	  Object[][] data = new Object[3][2];
	  return data;
  }
  
  
}
