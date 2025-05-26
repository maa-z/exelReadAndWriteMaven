package office;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main extends FileHandler {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		"C:\\Users\\Thinkpad\\eclipse-workspace\\office\\src\\main\\resources\\data.txt"
		
//		ReadTxtFile rtf = new ReadTxtFile();
//		List<Product> products = rtf.read("./data.txt");
//        
//		
//		WriteInExcel wie = new WriteInExcel();
//		wie.write("./data.xlsx", "Products", products);
//
//		List<Product> productsExcel = new ArrayList<>();	
//		ReadFromExcel rfe = new ReadFromExcel();
//		productsExcel = rfe.raed("./data.xlsx","Products");
//        
//
//      for(Product p : productsExcel) {
//    	System.out.println(p.getName()+" "+p.getPrice());
//      }

		List<Product> products = null;
		try {
			products = readTxt("./data.txt");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeExcel("./data.xlsx", "Products", products);
		
		List<Product> productsExcel = new ArrayList<>();
		productsExcel = readExcel("./data.xlsx","Products");
		
		for(Product p : productsExcel) {
	    	System.out.println(p.getName()+" "+p.getPrice());
	      }
		
	}

}
