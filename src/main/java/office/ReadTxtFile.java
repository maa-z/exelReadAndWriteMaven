package office;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxtFile {
	public List<Product> read(String path) throws NumberFormatException, IOException{
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
}
