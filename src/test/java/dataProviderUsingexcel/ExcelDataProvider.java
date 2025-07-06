package dataProviderUsingexcel;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	@DataProvider(name="dp")
public String[][]  getData() throws IOException {
	FileInputStream file=new FileInputStream("D:\\SeleniumPractice\\SeleniumWebdriver\\testdata\\data2.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(file);
	XSSFSheet sheet=wb.getSheet("Sheet1");
	int noOfRows=sheet.getPhysicalNumberOfRows();
	System.out.println(noOfRows);
	int noOfColumns=sheet.getRow(0).getLastCellNum();
	System.out.println(noOfColumns);
	
	String[][] data=new String[noOfRows-1][noOfColumns];   //String[3][2] // (3 data rows, 2 columns per row)
	DataFormatter df=new DataFormatter();
	for(int i=0;i<noOfRows-1;i++) {      								//i is for rows. Starts from 0, To skip the header row, you access the sheet using i + 1.
		for(int  j=0;j<noOfColumns;j++) {
			
		data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));			//you access the sheet using i + 1.
		}
		
	}
wb.close(); 
file.close();
/*for(String[] dataArr : data) {
	System.out.println(Arrays.toString(dataArr));
}*/
return data;
}
}
