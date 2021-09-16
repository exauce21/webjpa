package sn.isi.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.EleveImpl;
import sn.isi.dao.ExamenImpl;
import sn.isi.dao.IEleve;
import sn.isi.dao.IExamen;
import sn.isi.dao.IInscription;
import sn.isi.dao.InscriptionImpl;
import sn.isi.entities.Inscription;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet( name = "inscriptions", urlPatterns = {"/Inscriptions", "/insertIn", "/deleteIn", "/updateIn", "/editIn", "/newIn"} )
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IInscription inscriptiondao;
	private IEleve elevedao;
	private IExamen examendao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		inscriptiondao = new InscriptionImpl();
		elevedao = new EleveImpl();
		examendao = new ExamenImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/newIn":
				showNewForm(request, response);
				break;
			case "/deleteIn":
				delete(request, response);
				break;
			case "/editIn":
				showEditForm(request, response);
				break;
			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		request.setAttribute("liste_eleves", elevedao.getAll());
		request.setAttribute("liste_examens", examendao.getAll());
		request.setAttribute("liste_inscriptions", inscriptiondao.getAll());
		request.getRequestDispatcher("WEB-INF/views/isncription/list.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/isncription/list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Inscription inscription = inscriptiondao.get(id);
		
		request.setAttribute("liste_eleves", elevedao.getAll());
		request.setAttribute("liste_examens", examendao.getAll());
		request.setAttribute("liste_inscriptions", inscriptiondao.getAll());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/isncription/list.jsp");
		request.setAttribute("inscription", inscription);
		dispatcher.forward(request, response);

	}

	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		inscriptiondao.delete(id);
		response.sendRedirect("Inscriptions");

	}

}
