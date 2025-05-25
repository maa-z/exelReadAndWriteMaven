package office;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteInExcel {
	public void write(String path,String sheetName,List<Product> products) throws FileNotFoundException, IOException {
	      XSSFWorkbook workbook = new XSSFWorkbook();
	      XSSFSheet sheet =  workbook.createSheet(sheetName);
//	      "Products"
	      int rowCount = 0;
	      for (Product product : products) {
	          Row row = ((XSSFSheet) sheet).createRow(rowCount++);
	          row.createCell(0).setCellValue(product.getName());
	          row.createCell(1).setCellValue(product.getPrice());
	      }
	      
	      
	      try (FileOutputStream fos = new FileOutputStream(path)) {
	          workbook.write(fos);
	      }
//	      "./data.xlsx"
	      workbook.close();
	      
	}
}
