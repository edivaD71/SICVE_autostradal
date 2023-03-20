package com.defoult;

import java.io.IOException;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet per la modifica di una nuova tratta 
//tramite il passaggio dei dati da un form presente nella jsp

@WebServlet("/updateTrattaServlet")
public class updateTrattaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		String cod_t = request.getParameter("cod_t");
		String nome_a = request.getParameter("nome_a");
		String inizio_t = request.getParameter("inizio_t");
		String fine_t = request.getParameter("fine_t");
		Double lunghezza = Double.valueOf(request.getParameter("lunghezza"));
		Double limite = Double.valueOf(request.getParameter("limite"));
		int contr = Integer.valueOf(request.getParameter("con"));
		// verifico se sono stati inseriti tutti i dati
		if (cod_t == "" || nome_a == "" || inizio_t == "" || fine_t == "" || lunghezza == 0 || limite == 0) {
			request.setAttribute("t",
					"Tratta non modificata, per modificare una tratta devi inserire anche i dati che non vuoi modificare");
			request.getRequestDispatcher("rispostaUpdateTratta.jsp").forward(request, response);
		} else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutor", "root", "Solouni");

				Statement st = con.createStatement();
				// effettuo il corretto passaggio del codice della tratta da modificare
				ResultSet ri = st.executeQuery("select COD_T from tratta");
				String cod = "";
				int x = 0;
				while (ri.next()) {
					cod = ri.getString("COD_T");
					if (cod_t.equals(cod)) {
						// effettuo l'update
						PreparedStatement ps = con.prepareStatement(
								"UPDATE tutor.tratta SET Nome_a = ?, Inizio_t = ?, Fine_t = ?, Lunghezza = ?, Limite = ?, Controllo = ? WHERE COD_T ='"
										+ cod_t + "'");
						ps.setString(1, nome_a);
						ps.setString(2, inizio_t);
						ps.setString(3, fine_t);
						ps.setDouble(4, lunghezza);
						ps.setDouble(5, limite);
						ps.setDouble(6, contr);
						ps.executeUpdate();
						x = 1;

					}
				}
				con.close();
				if (x == 1) {

					request.setAttribute("t", "Tratta modificata");
					request.getRequestDispatcher("rispostaUpdateTratta.jsp").forward(request, response);
				} else {
					request.setAttribute("t", "Tratta non modificata, codice errato");
					request.getRequestDispatcher("rispostaUpdateTratta.jsp").forward(request, response);
				}

			} catch (Exception se) {
				se.printStackTrace();
			}
		}
	}
}