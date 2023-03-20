package com.defoult;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// servlet per l'inserimento di una nuova tratta 
// tramite il passaggio dei dati da un form presente nella jsp

@WebServlet("/newTrattaServlet")
public class newTrattaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		String cod = request.getParameter("cod_t");
		String nome_a = request.getParameter("nome_a");
		String inizio_t = request.getParameter("inizio_t");
		String fine_t = request.getParameter("fine_t");
		Double lunghezza = Double.valueOf(request.getParameter("lunghezza"));
		Double limite = Double.valueOf(request.getParameter("limite"));
		int controllo = Integer.valueOf(request.getParameter("con"));
		// verifico se sono stati inseriti tutti i dati
		if (cod == "" || nome_a == "" || inizio_t == "" || fine_t == "" || lunghezza == 0 || limite == 0) {
			request.setAttribute("t", "Tratta non inserita, non sono stati riempiti tutti i campi");
			request.getRequestDispatcher("rispostaNewTratta.jsp").forward(request, response);
		} else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutor", "root", "Solouni");

				Statement st = con.createStatement();
				// verifico se la tratta è già presente
				ResultSet ris = st.executeQuery("select count(COD_T) from tratta where COD_T='" + cod + "' and Nome_a='"
						+ nome_a + "' and Inizio_t='" + inizio_t + "' and Fine_t='" + fine_t + "'");
				int i = 0;
				while (ris.next()) {
					i = ris.getInt(1);
				}
				if (i != 0) {
					con.close();
					request.setAttribute("t", "Tratta non aggiunta poichè già presente");
					request.getRequestDispatcher("rispostaNewTratta.jsp").forward(request, response);
				} else {
					Statement sta = con.createStatement();
					ResultSet risu = sta.executeQuery("select count(COD_T) from tratta where COD_T='" + cod + "'");
					int z = 0;
					while (risu.next()) {
						z = risu.getInt(1);
					}
					if (z != 0) {
						con.close();
						request.setAttribute("t", "Tratta non inserita, codice già utilizzato");
						request.getRequestDispatcher("rispostaNewTratta.jsp").forward(request, response);
					} else {
						// inserisco la tratta
						PreparedStatement ps = con.prepareStatement("insert into tratta values(?,?,?,?,?,?,?)");
						ps.setString(1, cod);
						ps.setString(2, nome_a);
						ps.setString(3, inizio_t);
						ps.setString(4, fine_t);
						ps.setDouble(5, lunghezza);
						ps.setDouble(6, limite);
						ps.setDouble(7, controllo);
						int c = ps.executeUpdate();

						if (c > 0) {
							con.close();
							request.setAttribute("t", "Tratta inserita corettamente");
							request.getRequestDispatcher("rispostaNewTratta.jsp").forward(request, response);
						} else {
							con.close();
							request.setAttribute("t", "Tratta non inserita");
							request.getRequestDispatcher("rispostaNewTratta.jsp").forward(request, response);
						}
						con.close();
					}
				}

			} catch (Exception se) {
				se.printStackTrace();
			}
		}
	}
}
