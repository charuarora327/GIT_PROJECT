package test;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class database {
	public static Connection getDBConnection()
	{
	Connection con = null;
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CHARU","12345");
	System.out.println("establised");
	}
	catch(ClassNotFoundException e)
	{
	System.out.println("Driver not loaded");
	}
	catch(SQLException e)
	{
	System.out.println("Connection not established");
	} 
	return con;
	}
}