package OracleDemo.OracleDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	 String dbUrl = "jdbc:oracle:thin:@10.51.11.165:1590/EEOCMPD1DR.tdeprdcl.internal";					

			////Database Username		
			String username = "EOC_READ";	
      
			//Database Password		
			String password = "eoc_read";				

			//Query to Execute		
			String query = "SELECT * FROM EOC.OM_ORDER_HEADER_POSTPAID WHERE STATUS='O_R_ERR' Fetch first 2 rows only";	
 	
			List<String> myList = new ArrayList<String>();
 
 		//Create Connection to DB		
  	Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs= stmt.executeQuery(query);							

		// While Loop to iterate through all data and print results		
			while (rs.next()){
		        										        
                  String myAge = rs.getString(2);
                  String orderId=rs.getString(2);
                  String order=rs.getString("CWORDERID");
                  myList.add("'"+orderId+"'");
                  System. out.println(order+"  "+myAge);		
          }		
			System. out.println(myList);
			
			 // closing DB Connection		
			con.close();

    }
}
