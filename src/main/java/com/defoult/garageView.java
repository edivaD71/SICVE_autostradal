package com.defoult;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.auto;

// servlet per visualizzare le auto di proprieta dell'user

@WebServlet("/garageView")
public class garageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public garageView() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		try {
			String posta = String.valueOf(request.getSession().getAttribute("mail"));
			Statement st = con.createStatement();
            ResultSet ris = st.executeQuery("select * from autoveicolo where email ='"+ posta  + "' order by anno");
           
            ArrayList<auto> showAuto = new ArrayList<auto>();
            while(ris.next())
            {
                // salvo le auto dell'user
                showAuto.add(new auto(ris.getString(1),ris.getString(2),ris.getString(3),ris.getInt(4),ris.getString(5)));
            }
            con.close();
            // invio le auto alla jsp che me mostrerà
            request.setAttribute("showAuto",showAuto);
            request.getRequestDispatcher("showAuto.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
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

}
