package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.LoginBean;
import com.dao.LoginDao;
import com.defoult.Users;

// servlet per la gestione del login

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// richiamo e inizializzo le variabili da utilizzare
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Users users = new Users();
		String message = users.getMessage();
		LoginBean loginBean = new LoginBean();
		loginBean.setEmail(email);
		loginBean.setPassword(password);
		LoginDao loginDao = new LoginDao();
		try {
			// assegno a userValidate la risposta di loginDao.authenticateUser(loginBean)
			String userValidate = loginDao.authenticateUser(loginBean);
			// controllo l'autenticazione dell'login
			if (userValidate.equals("Admin_Role")) {
				// è un admin quindi lo reinderizzo all'area admin
				System.out.println("Admin's Home");

				HttpSession session = request.getSession();
				session.setAttribute("Admin", email);
				request.setAttribute("email", email);
				request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
			} else if (userValidate.equals("User_Role")) {
				// è un user quindi lo reinderizzo all'area user
				System.out.println("User's Home");

				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10 * 60);
				session.setAttribute("User", email);
				request.setAttribute("email", email);
				request.getSession().setAttribute("mail", email);
				request.getSession().setAttribute("sms", message);
				request.getRequestDispatcher("homeUser.jsp").forward(request, response);
			} else {
				// non sono stati inseriti correttamente i dati
				// lo reinderizzo alla stessa pagina con un messaggio di errore
				System.out.println("Error message = " + userValidate);
				request.setAttribute("errMessage", userValidate);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}