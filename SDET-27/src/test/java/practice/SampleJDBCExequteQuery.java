package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExequteQuery {

	public static void main(String[] args) throws SQLException {
/*step1: Register the driver*/		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
/*step2: get connection with database - provide database name*/		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
/*step3: issue create statement*/		
		Statement state = con.createStatement();
/*step4: execute a query - provide the table name*/		
		 ResultSet result = state.executeQuery("select * from employeeinfo;");
		 
		 while(result.next())
		 {
			 System.out.println(result.getString(2)+" "+result.getString(3));
			 
		 }
/*close db*/
		 con.close();
		
		
		

	}

}
