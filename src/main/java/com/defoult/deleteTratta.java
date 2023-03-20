package com.defoult;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// servlet per l'eliminazione di una tratta

@WebServlet("/deleteTratta")
public class deleteTratta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cod = request.getParameter("c");
		
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutor","root","Solouni");
	    	
	    	Statement st = con.createStatement();
	    	st.executeUpdate("delete from tratta where COD_T='"+ cod+"'");
	        con.close();
	        request.getRequestDispatcher("viewTratteServlet").forward(request, response);
	        
	    }
	    catch(Exception se) {
	        se.printStackTrace();
	    }
	}

}
