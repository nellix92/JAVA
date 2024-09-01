package srv;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticoloDao;
import model.Articolo;

/**
 * Servlet implementation class ArticoloSrv
 */
@WebServlet("/ArticoloSrv")
public class ArticoloSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticoloSrv() {
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
		ArticoloDao aDao = new ArticoloDao();

		String operazione = request.getParameter("operazione");

		if (operazione.equals("insert")) {

			String descrizione = request.getParameter("descrizione");
			String qnt = request.getParameter("quantita");
			int quantita = Integer.parseInt(qnt);
			Articolo a = new Articolo();
			a.setDescrizione(descrizione);
			a.setQuantita(quantita);
			try {
				aDao.insert(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		if (operazione.equals("update")) {
			String descrizione = request.getParameter("descrizione");
			String qnt = request.getParameter("quantita");
			int quantita = Integer.parseInt(qnt);
			String cod = request.getParameter("codice");
			int codice = Integer.parseInt(cod);
			Articolo a = new Articolo();
			a.setCodice(codice);
			a.setDescrizione(descrizione);
			a.setQuantita(quantita);
			try {
				aDao.update(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		if (operazione.equals("delete")) {
			String cod = request.getParameter("codice");
			int codice = Integer.parseInt(cod);
			try {
				aDao.delete(codice);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		if (operazione.equals("findbyid")) {
			String cod = request.getParameter("codice");
			int codice = Integer.parseInt(cod);
			aDao.getByCodice(codice);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());

		if (operazione.equals("getAll")) {

			List<Articolo> articoli;
			articoli = aDao.getAll();
			request.getSession().setAttribute("elencoArticoli", articoli);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/elenco.jsp");
			dispatcher.forward(request, response);
		} else
			response.getWriter().append("Served at: ").append(request.getContextPath());

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
