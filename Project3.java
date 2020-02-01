import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;
/**
 *The project3 class implements the other classes with the tree object.  first the 
 *class inputs the Countries4.csv and splits the data by the comma and the splits the data into 
 *separate fields and finds the GDP per Capita. It then traverses the tree inorder. 
 *Then it deletes Australia, Norway, and Tunisia. The traverses the tree with preorder
 *Next it searches for Sri Lanka, North Cyprus and, Tunisia. Then we delete 
 *Malawi, Somalia, Ireland, Greece and, Singapore. Then we traverse the tree in postOrder
 *and print the bottom 10 and top 10 countries by GDP per Capita.
 * 
 * @author <Chase Goodband>
 * @version<11/16/2019>
 * 
 *
 */

public class Project4 {
	
	static BinarySearchTree t = new BinarySearchTree();
	//static BinarySearchTree ten = new BinarySearchTree();
	
	
	
	public static void main(String[] args) throws IOException {
		
		 FileInputStream fstream = new FileInputStream("Countries4.csv");
		 BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));

		 String strLine = reader.readLine(); //Title line
		 
		 while ((strLine = reader.readLine()) != null)   {
			 String[] parts = strLine.split(Pattern.quote(","));
			 
			    String  name = parts[0];
			   String code = parts[1]; 
		       String capital = parts[2];
			   long population = Long.parseLong(parts[3]); 
		     double  gdp = Double.valueOf(parts[4]).doubleValue(); 
			    int hapRank = Integer.parseInt(parts[5]);
			    
			   
			    
			    
			    double gdpPerCapita = (gdp / population);
			 
			 t.insert(name, gdpPerCapita);
			// ten.gdpInsert(name, gdpPerCapita);
			 
			 
			 
	}
		 //System.out.println(t.find("Zimbabwe"));
		 
		
		System.out.println("Inorder Traversal:\n----------------------------------- ");
		 t.printinOrder(t.root);
		 
		 t.delete("Australia");
		 t.delete("Tunisia");
		 t.delete("Norway");
		 
		// ten.delete("Australia");
		// ten.delete("Tunisia");
		// ten.delete("Norway");
		 
		 System.out.println("Preorder Traversal:\n----------------------------------- ");

		 t.printpreOrder(t.root);
		 
		 t.find("Sri Lanka");
		 t.find("North Cyprus");
		 t.find("Tunisia");
		 
		 
		 t.delete("Malawi");
		 t.delete("Somalia");
		 t.delete("Ireland");
		 t.delete("Greece");
		 t.delete("Singapore");
		 
		// ten.delete("Malawi");
		// ten.delete("Somalia");
		// ten.delete("Ireland");
		// ten.delete("Greece");
		// ten.delete("Singapore");
		 
		 System.out.println("Postorder Traversal:\n----------------------------------- ");
		
		 t.printpostOrder(t.root);
		 
		 System.out.println("Bottom ten: \n------------------------------------------");
	//	 ten.tenprintinOrder(ten.root);
		 t.print();
		
		 System.out.println("Top ten: \n------------------------------------------");
		 t.remove();
		 

}
	
	
	
	
}
