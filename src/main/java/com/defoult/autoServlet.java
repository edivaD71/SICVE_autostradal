package com.defoult;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// servlet per l'inserimento di un auto

@WebServlet("/autoServlet")
public class autoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public autoServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prendo i dati inseriti nel form della jsp
		String targa = request.getParameter("targa");
		String marca = request.getParameter("marca");
		String modello = request.getParameter("modello");
		int anno = Integer.parseInt(request.getParameter("anno"));
		String email = String.valueOf(request.getSession().getAttribute("mail"));
		
		autoBean autobean = new autoBean(targa,marca,modello,anno,email);
		
		autoDao aDao = new autoDao();
		// invio i dati a aDao.insertAuto per inserire l auto nel DB e mi ritorna un risultato
		String result = aDao.insertAuto(autobean);
		response.getWriter().print(result);
		response.sendRedirect("garageView");
	}

}
