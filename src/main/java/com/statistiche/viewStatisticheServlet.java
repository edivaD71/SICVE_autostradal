package com.statistiche;
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

import com.dao.avgVelocita;

//servlet per salvare la velocità media per ogni autostrada  

@WebServlet("/listaTratteServlet")
public class viewStatisticheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public viewStatisticheServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutor", "root", "Solouni");

			Statement st = con.createStatement();
			ResultSet ris = st.executeQuery(
					"select tratta.Nome_a, AVG(velocita) from tratta,attraversa where tratta.COD_T=attraversa.COD_T group by Nome_a ");
			int i = 0;
			ArrayList<avgVelocita> listMedia = new ArrayList<avgVelocita>();
			while (ris.next()) {
				i = i + 1;
				// salvo il nome dell'autostrada e la sua velocità media
				listMedia.add(new avgVelocita(ris.getString(1), ris.getDouble(2)));
			}
			con.close();
			request.setAttribute("listAVG", listMedia);
			// invio i dati da stampare alla jsp
			request.getRequestDispatcher("StampaStatistica.jsp").forward(request, response);

		} catch (Exception se) {
			se.printStackTrace();
		}
	}

}
