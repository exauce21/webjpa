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

import sn.isi.dao.CommissionImpl;
import sn.isi.dao.EpreuveImpl;
import sn.isi.dao.ExamenImpl;
import sn.isi.dao.ICommision;
import sn.isi.dao.IEpreuve;
import sn.isi.dao.IExamen;
import sn.isi.entities.Commission;
import sn.isi.entities.Epreuve;
import sn.isi.entities.Examen;

/**
 * Servlet implementation class EpreuveServlet
 */
@WebServlet(name = "epreuves", urlPatterns = {"/Epreuves", "/insertEp", "/deleteEp", "/updateEp", "/editEp", "/newEp"})
public class EpreuveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ICommision commissiondao;
	private IEpreuve epreuvedao;
	private IExamen examendao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EpreuveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		commissiondao = new CommissionImpl();
		epreuvedao = new EpreuveImpl();
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
		    case "/newEp":
		        showNewForm(request, response);
		        break;
		    case "/insertEp":
		        add(request, response);
		        break;
		    case "/deleteEp":
		        delete(request, response);
		        break;
		    case "/editEp":
		        showEditForm(request, response);
		        break;
		    case "/updateEp":
		        update(request, response);
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
		request.setAttribute("liste_epreuves", epreuvedao.getAll());
		request.setAttribute("liste_commissions", commissiondao.getAll());
		request.setAttribute("liste_examens", examendao.getAll());
		request.getRequestDispatcher("WEB-INF/views/epreuve/list.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/epreuve/list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Epreuve epreuve = epreuvedao.get(id);
		request.setAttribute("liste_epreuves", epreuvedao.getAll());
		request.setAttribute("liste_commissions", commissiondao.getAll());
		request.setAttribute("liste_examens", examendao.getAll());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/epreuve/list.jsp");
		request.setAttribute("epreuve", epreuve);
		dispatcher.forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int idCo = Integer.parseInt(request.getParameter("idCo"));
		Commission commission = new Commission();
		commission = commissiondao.get(idCo);
		
		int idEx = Integer.parseInt(request.getParameter("idEx"));
		Examen  examen = new Examen();
		examen = examendao.get(idEx);
		
		int coef = Integer.parseInt(request.getParameter("coef"));
		String nom = request.getParameter("nom");
		
		Epreuve epreuve = new Epreuve(nom, coef, examen, commission);
		epreuvedao.add(epreuve);
		
		response.sendRedirect("Epreuves");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int idCo = Integer.parseInt(request.getParameter("idCo"));
		Commission commission = new Commission();
		commission = commissiondao.get(idCo);
		
		int idEx = Integer.parseInt(request.getParameter("idEx"));
		Examen  examen = new Examen();
		examen = examendao.get(idEx);
		
		int coef = Integer.parseInt(request.getParameter("coef"));
		String nom = request.getParameter("nom");
		
		Epreuve epreuve = new Epreuve(id, nom, coef, examen, commission);
		epreuvedao.update(epreuve);
		
		response.sendRedirect("Epreuves");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		epreuvedao.delete(id);
		response.sendRedirect("Epreuves");

	}

}
