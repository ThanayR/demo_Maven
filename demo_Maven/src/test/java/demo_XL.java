import resources.util.CONSTANTS;
import resources.util.Xlsx_Reader;

public class demo_XL {
	public static void main(String[] args) {
		Xlsx_Reader xlsx = new Xlsx_Reader(CONSTANTS.testDataFilePath);
		
		System.out.println( "Row Count: " + xlsx.getRowCount("Sheet1"));
		System.out.println( "Column Count: " + xlsx.getColumnCount("Sheet1") );
		
		//System.out.println( xlsx.getCellData("Sheet1", "EmpName", 3) );
		
		// Row Indexing = 1, Data => Row # 2
		// Col Indexing => 0
		System.out.println( xlsx.getCellData("Sheet1", 0, 2) );
		
		xlsx.setCellData("Sheet1", "Salary", 10, "Writing into Excel...");
	}

}
