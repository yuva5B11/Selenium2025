package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvidersTest {
	
	@DataProvider(name = "CreateAR")
	public Object[][] getData() throws IOException {
		String patth=".//testData/Automation_TestData.xlsx";
		ExcelUtility xlUtil=new ExcelUtility(patth);
		int rowCount=xlUtil.getRowCount("ARCreation");
		int cellCount=xlUtil.getCellCount("ARCreation", 1);
		
		Object arData[][]=new Object[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				arData[i-1][j]=xlUtil.getCellData("ARCreation", i, j);
			}
		}
		return arData;
	}

}
