package office;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

abstract class FileHandler {
	public static List<Product> readTxt(String path) throws NumberFormatException, IOException{
		InputStream input = Main.class.getResourceAsStream(path);
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));

		List<Product> products = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {

            String[] parts = line.split(",");
            if (parts.length == 2) {
            	
                String name = parts[0].trim();
                String  priceInString = parts[1].trim();
                
                if(priceInString.equalsIgnoreCase("price"))continue;
                
                Double price = Double.parseDouble(priceInString);

                products.add(new Product(name, price));
            }
        }
        reader.close();
        return products;
	}
	
	public static void writeExcel(String path,String sheetName,List<Product> products) throws FileNotFoundException, IOException {
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
	
	
	public static List<Product> readExcel(String path,String sheetName) throws IOException{
	      List<Product> products = new ArrayList<>();
	      
//	      "./data.xlsx"
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
