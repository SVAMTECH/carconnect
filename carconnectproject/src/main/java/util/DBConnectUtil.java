package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtil {
	
	public static Connection getConnection()
	{
		Connection con=null;
		String connString=DBPropertyUtil.getConnString("./src/main/resources/db.properties");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded..");
			con=DriverManager.getConnection(connString);
			System.out.println("Connected...");
		}catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Driver Loading Failed");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println("Not Connected to Database");
		}
		return con;
	}
	
}



