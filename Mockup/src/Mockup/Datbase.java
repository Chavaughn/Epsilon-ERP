package Mockup;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class Datbase {

    /**
     * Create a new table in the test database
     *
     */
	
	public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:workspace.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
               
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	
	
	
    public static void createNewTable() {
    
    	String url = "jdbc:sqlite:workspace.db";
    	
    	String sql1 = "CREATE TABLE IF NOT EXISTS Customers (\n"
		                + "	customer_id integer AUTO_INCREMENT PRIMARY KEY,\n"
		                + "	company_name text NOT NULL,\n"
		                + "	address text NOT NULL,\n"
		                + "	customer_code text NOT NULL,\n"
		                + ");";
		String sql2 = "CREATE TABLE IF NOT EXISTS Sales_Invoice (\n"
		                + "	inv_no integer  NOT NULL AUTO_INCREMENT PRIMARY KEY,\n"
		                + "	name text NOT NULL,\n"
		                + "	customer_id integer,\n"
		                + "	FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),\n"
		                + "	price real\n"
		                + ");";
		
		String sql3 = "CREATE TABLE IF NOT EXISTS Inventory (\n"
                + "	product_id integer  NOT NULL AUTO_INCREMENT PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	customer_id integer,\n"
                + "	FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),\n"
                + "	price real\n"
                + ");";
//		String sql3 = "CREATE TABLE IF NOT EXISTS Purchases_Invoice (\n"
//		                + "	id integer PRIMARY KEY,\n"
//		                + "	customer_id integer,\n"
//		                + "	product_id integer,\n"
//		                + "	quantity integer,\n"
//		                + "	FOREIGN KEY (customer_id) REFERENCES Customers(id),\n"
//		                + "	FOREIGN KEY (product_id) REFERENCES Products(id)\n"
//		                + ");";
//        
        
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}