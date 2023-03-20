package com.simulazione;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.emailUtility;
import com.util.DBConnection;

// servlet per la simulazione di un attraversamento random

@WebServlet("/simulazioneServlet")
public class simulazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public simulazioneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con = null;
		con = DBConnection.createConnection();
		// query per ricavare una targa e propritario random
		String query = "select targa, email from autoveicolo order by rand() limit 1; ";
		int c = 0;
		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String targa = rs.getString("targa");
				String email = rs.getString("email");
				int min = 100; // Minimum value of range
				int max = 150; // Maximum value of range
				int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
				// query per ricavare un tratta random
				String query2 = "select * from tratta order by rand() limit 1; ";
				try (Statement stm = con.createStatement()) {
					ResultSet rsl = stm.executeQuery(query2);
					while (rsl.next()) {

						String cod = rsl.getString("COD_T");
						String nome = rsl.getString("Nome_a");
						String inizio = rsl.getString("Inizio_t");
						int cont = rsl.getInt("Controllo");
						// inserisco l'attraversamento nel DB
						PreparedStatement ps = con.prepareStatement("insert into attraversa values(null,?,?,?)");
						ps.setString(1, targa);
						ps.setString(2, cod);
						ps.setInt(3, random_int);
						c = ps.executeUpdate();
						// controllo se la tratta è controllata da tutor
						if (cont == 1) {
							request.setAttribute("c", " è controllata da tutor");
							Statement stt = con.createStatement();
							ResultSet rslt = stt
									.executeQuery("select messaggio from users where email='" + email + "'");
							String message = "N";
							while (rslt.next()) {
								message = rslt.getString(1);
							}
							// controllo se l'user deve ricevere l'e-mail oppure no
							// se message è uguale a Y alloro invio e-mail
							if (message.equals("Y")) {
								String recipient = email;
								String subject = "Tutor ti informa";
								String content = "Gentile " + email + " sei entrato nella tratta " + inizio
										+ " la quale è controllata da tutor";
								ServletContext context = getServletContext();
								String host = context.getInitParameter("host");
								String port = context.getInitParameter("port");
								String user = context.getInitParameter("user");
								String pass = context.getInitParameter("pass");

								String resultMessage = "";

								try {
									emailUtility.sendEmail(host, port, user, pass, recipient, subject, content);
									resultMessage = "Email inviata correttamente a " + email;
								} catch (Exception ex) {
									ex.printStackTrace();
									resultMessage = "Email da inviare a " + email + " con errore: " + ex.getMessage();
								} finally {
									String Message = resultMessage;
									System.out.println(Message);
								}
							}
						} else
							request.setAttribute("c", " non è controllata da tutor");
						con.close();
						request.setAttribute("s",
								"L'auto targata " + targa + " appartenente a " + email + " viaggia alla velocità di "
										+ random_int + "Km/h <br> nella tratta " + inizio + " appartenente all'" + nome
										+ " che ");

					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (c > 0)
			System.out.println("Attraversamento inserito");
		else
			System.out.println("Attraversamento non inserito");
		request.getRequestDispatcher("stampaSimulazione.jsp").forward(request, response);
	}

}
