package com.defoult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// class RegisterDao che gestisce l'insermineto di un nuovo user

public class RegisterDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/tutor";
	private String dbUname = "root";
	private String dbPassword ="Solouni";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public String insert(Users users) 
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data entered successfully";
		String query = "insert into users values(NULL,?,?,?,?,?,?,?)";
		String role = "User";
		String message="N";
		
		PreparedStatement ps; 
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, users.getFirstName());
			ps.setString(2, users.getLastName());
			ps.setString(3, users.getCf());
			ps.setString(4, users.getEmail());
			ps.setString(5, users.getPassword());
			ps.setString(6, role);
			ps.setString(7,message);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}
}
