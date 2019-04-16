package excelpractice;

import java.io.FileInputStream;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {
	
	public ArrayList<String> getData(String testcaseName) throws IOException{
ArrayList<String> a = new ArrayList<String>();
		
		FileInputStream f = new FileInputStream("C:\\Users\\WINDOWS_10\\Desktop\\Book1.xlsx");
	   XSSFWorkbook  x = new XSSFWorkbook(f);
	   int s=x.getNumberOfSheets();
	   for(int i=0;i<s;i++){
		 if(x.getSheetName(i).equalsIgnoreCase("Sheet1")){
		XSSFSheet xs= x.getSheetAt(i);
	Iterator<Row> rows=xs.iterator();
	Row firstrow = rows.next();
	Iterator<Cell> cell =firstrow.cellIterator();
	int k=0;
	int column=0;
	while(cell.hasNext()){
		Cell v=cell.next();
		if(v.getStringCellValue().equalsIgnoreCase("Testcases")){
			column =k;
		}
		k++;
	}
	
	while(rows.hasNext()){
		Row r=rows.next();
		if(r.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseName)){
			Iterator<Cell> c = r.iterator();
			while(c.hasNext()){
				Cell ca = c.next();
				if(ca.getCellTypeEnum()==CellType.STRING){
			a.add(ca.getStringCellValue());
				}
				else{
					a.add(NumberToTextConverter.toText(ca.getNumericCellValue()));
				}
		}
	}
		 }
	   }
	  
	}

	   return a;
	}
	}
