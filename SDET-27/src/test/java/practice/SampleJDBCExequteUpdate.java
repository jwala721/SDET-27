package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExequteUpdate {
	
	public static void main(String[] args) throws SQLException {
		/*step1: Register the driver*/		
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
		/*step2: get connection with database - provide database name*/		
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
		/*step3: issue create statement*/		
				Statement state = con.createStatement();
		/*step4: execute a query - provide the table name*/	
				int result = state.executeUpdate("insert into employeeinfo(id,name,address)value(3,'jwala','banglore');");
				if(result==1)
				{
					System.out.println("data added successfully");
				}
				else
				{
					System.out.println("error");
				}
				con.close();
				
	}
}
