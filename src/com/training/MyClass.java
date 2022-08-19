package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object 
		String url = "jdbc:oracle:thin:@localhost:1521/orcl.iiht.tech";
		String userName = "scott";
		String password = "tiger";
		Connection con=DriverManager.getConnection(url, userName, password); 
		
		Statement stmt = con.createStatement();
		
		ResultSet rs =  stmt.executeQuery("select * from product");
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getInt(4));
		}

	}

}
