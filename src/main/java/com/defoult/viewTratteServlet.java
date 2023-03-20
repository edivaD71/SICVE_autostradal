package com.defoult;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.dao.Tratta;

// servlet per salvare tutte le tratte e inviarle alla jsp che le stamperà

@WebServlet("/viewTratteServlet")
public class viewTratteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutor", "root", "Solouni");

			Statement st = con.createStatement();
			ResultSet ris = st.executeQuery("select * from tratta order by Nome_a");
			int i = 0;
			ArrayList<Tratta> infoTratta = new ArrayList<Tratta>();
			while (ris.next()) {
				i = i + 1;
				// salvo i dati delle tratte
				infoTratta.add(new Tratta(ris.getString(1), ris.getString(2), ris.getString(3), ris.getString(4),
						ris.getDouble(5), ris.getDouble(6), ris.getInt(7)));
			}
			con.close();
			request.setAttribute("ListTr", infoTratta);
			request.getRequestDispatcher("viewTratte.jsp").forward(request, response);

		} catch (Exception se) {
			se.printStackTrace();
		}
	}
}
