package com.defoult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// creo la class autoDao

public class autoDao {
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
	
	public String insertAuto(autoBean autoBean) 
	{
		// inserimento auto nel DB
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data entered successfully";
		String query = "insert into autoveicolo values(?,?,?,?,?)";
		
		PreparedStatement ps; 
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, autoBean.getTarga());
			ps.setString(2, autoBean.getMarca());
			ps.setString(3, autoBean.getModello());
			ps.setInt(4, autoBean.getAnno());
			ps.setString(5, autoBean.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}
}
