package office;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	public List<Product> raed(String path,String sheetName) throws IOException{
      List<Product> products = new ArrayList<>();
      
//      "./data.xlsx"
      XSSFWorkbook workbook = new XSSFWorkbook(path);
      XSSFSheet sheet =  workbook.getSheet(sheetName);
      
      for (Row row : sheet) {
          String name = row.getCell(0).getStringCellValue();
          double price = row.getCell(1).getNumericCellValue();
          products.add(new Product(name, price));
      }

      workbook.close();
      
      return products;
	}
}
