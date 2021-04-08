package test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
	final  static Connection con=database.getDBConnection();
	static PreparedStatement ps = null;
 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
{
	String uname=req.getParameter("username");
	String pwd=req.getParameter("password");
	
	try {
		if(check(uname,pwd))
		{
			 res.sendRedirect("home.html");
		}	
		else {
			 res.sendRedirect("Login.html");
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
}
 static boolean check(String uname,String pwd) throws SQLException
 {
	 boolean r=false;
	 ps=con.prepareStatement("Select * from STUDENT where username=? and password=?");
	 ps.setString(1,uname);
	 ps.setString(2,pwd);
	 ResultSet rs=ps.executeQuery();
	 r=rs.next();
	 return r;
 }
}