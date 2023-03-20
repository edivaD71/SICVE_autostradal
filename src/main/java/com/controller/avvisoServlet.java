package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Creo la servelt che gestisce la modifica del user se vuole ricere una notifica oppre no 
// quando entra in una tratta controllata da tutor

@WebServlet("/avvisoServlet")
public class avvisoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public avvisoServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// richiamo le variabili interessate
		
		String message=(String) request.getSession().getAttribute("sms");
		String email=(String) request.getSession().getAttribute("mail");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//connessione al DB
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutor","root","Solouni");
			
			// controllo la variabile message per poi cambiarla : da N a Y oppure da Y a N
			
			if(message.equals("N")){
				message="Y";
				request.getSession().setAttribute("sms",message);
				
				// inizializzo l'update
				
				PreparedStatement ps = con.prepareStatement("UPDATE `tutor`.`users` SET `messaggio` = ? WHERE (`email` = ?);");
	        	ps.setString(1, message);
	        	ps.setString(2, email);
	        	
	        	// eseguo l'update
	        	
	        	ps.executeUpdate();
			}
			else {
				message="N";
				request.getSession().setAttribute("sms",message);
				// inizializzo l'update
				PreparedStatement ps = con.prepareStatement("UPDATE `tutor`.`users` SET `messaggio` = ? WHERE (`email` = ?);");
	        	ps.setString(1, message);
	        	ps.setString(2, email);
	        	// eseguo l'update
	        	ps.executeUpdate();
			}
    	}
    	catch(Exception se) {
            se.printStackTrace();
        }
		request.getRequestDispatcher("richiestaAvviso.jsp").forward(request, response);
	}

}
