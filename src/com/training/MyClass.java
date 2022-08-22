package com.training;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class MyClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		  
		//step2 create  the connection object 
		String url = "jdbc:oracle:thin:@localhost:1521/orcl.iiht.tech";
		String userName = "scott";
		String password = "tiger";
		Connection con=DriverManager.getConnection(url, userName, password); 
		
		if(con != null) {
			System.out.println("Connected Successfully");
		}
		else {
			System.out.println("Connection Refused");
		}
		
		//Statement stmt = con.createStatement();
		
		String prdId= "EL101";
		String prdName="Test";
		
		CallableStatement cs = con.prepareCall(" {? = call GETPRICE(?)}");
		
		cs.registerOutParameter(1, Types.INTEGER);
		cs.setString(2, prdId);
		cs.execute();
		
		System.out.println("Price is: "+cs.getInt(1));
		
		//ResultSet rs =  stmt.executeQuery("select * from product");
		
		//while(rs.next()) {
			//System.out.println(rs.getString(1)+":"+rs.getString(2)+":"+rs.getInt(4));
		//}

	}

}
