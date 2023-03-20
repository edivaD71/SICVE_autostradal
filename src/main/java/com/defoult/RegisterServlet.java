package com.defoult;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 // servlet RegisterServlet riceve i dati del form di una jsp

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// salvo i dati ricevuti dal form
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String cf = request.getParameter("cf");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = "User";
		String message="N";
		
		Users users = new Users(firstName,lastName,cf,email,password,role,message);
		
		RegisterDao rDao = new RegisterDao();
		// invio i dati a rDao.insert per inserire il nuovo user
		String result = rDao.insert(users);
		response.getWriter().print(result);
		response.sendRedirect("index.jsp");
	}

}
