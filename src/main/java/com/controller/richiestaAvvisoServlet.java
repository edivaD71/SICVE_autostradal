package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// servlet per ricavare l'attributo messaggio di user tramite la sua email 

@WebServlet("/richiestaAvvisoServlet")
public class richiestaAvvisoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public richiestaAvvisoServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// connessione al DB
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutor","root","Solouni");
			String email=(String)request.getSession().getAttribute("mail");
			Statement st = con.createStatement();
			// interrogo il DB
	    	ResultSet ris = st.executeQuery("select messaggio from users where email='"+ email +"'");
	    	while(ris.next()){
	    		String mess=ris.getString(1);
	    		con.close();
	    		request.getSession().setAttribute("sms",mess);
	    		request.getRequestDispatcher("richiestaAvviso.jsp").forward(request, response);
	    	} 
    	}
    	catch(Exception se) {
            se.printStackTrace();
        }
		
	}

}
