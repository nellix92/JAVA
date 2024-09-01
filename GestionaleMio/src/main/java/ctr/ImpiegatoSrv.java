package ctr;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImpiegatoDaoImpl;
import model.Impiegato;

/**
 * Servlet implementation class ImpiegatoSrv
 */
@WebServlet("/ImpiegatoSrv")
public class ImpiegatoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImpiegatoSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Sono dentro al doGet");
		ImpiegatoDaoImpl impdao = new ImpiegatoDaoImpl();
		String operazione = request.getParameter("operazione");
		if (operazione.equals("operazione")) {

			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String codicefiscale = request.getParameter("codicefiscale");
			String matr = request.getParameter("matricola");
			int matricola = Integer.parseInt(matr);
			Impiegato imp = new Impiegato();
			imp.setNome(nome);
			imp.setCognome(cognome);
			imp.setCodiceFiscale(codicefiscale);
			imp.setMatricola(matricola);
			try {
				impdao.insert(imp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
