package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
private static Connection conn;
	
	public static Connection getConn()
	{
		try {
		if(conn==null)
		{
			
				
				Class.forName("com.mysql.jdbc.Driver");

				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","root");
				
						}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;

}
	}
