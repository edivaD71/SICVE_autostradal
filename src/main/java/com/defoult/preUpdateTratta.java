package com.defoult;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Tratta;

// servlet per ricavare i dati della tratta per poi essere modificati

@WebServlet("/preUpdateTratta")
public class preUpdateTratta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cod = request.getParameter("c");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutor", "root", "Solouni");

			Statement st = con.createStatement();
			ResultSet ris = st.executeQuery("select * from tratta where COD_T='" + cod + "'");
			ArrayList<Tratta> infoT = new ArrayList<Tratta>();
			while (ris.next()) {
				// salvo i dati della tratta e poi li invio alla jsp contenente il form per
				// l'update
				infoT.add(new Tratta(ris.getString(1), ris.getString(2), ris.getString(3), ris.getString(4),
						ris.getDouble(5), ris.getDouble(6), ris.getInt(7)));
			}
			con.close();
			request.setAttribute("ListT", infoT);
			request.getRequestDispatcher("updateTratta.jsp").forward(request, response);

		} catch (Exception se) {
			se.printStackTrace();
		}
	}
}
