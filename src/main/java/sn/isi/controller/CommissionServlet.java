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

import sn.isi.dao.AcademieImpl;
import sn.isi.dao.CommissionImpl;
import sn.isi.dao.IAcademie;
import sn.isi.dao.ICommision;
import sn.isi.entities.Academie;
import sn.isi.entities.Commission;

/**
 * Servlet implementation class CommissionServlet
 */
@WebServlet( name = "commissions", urlPatterns = {"/Commissions", "/insertCo", "/deleteCo", "/updateCo", "/editCo", "/newCo"} )
public class CommissionServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
     private ICommision commisiondao;
     private IAcademie academiedao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		commisiondao = new CommissionImpl();
		academiedao = new AcademieImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/newCo":
				showNewForm(request, response);
				break;
			case "/insertCo":
				add(request, response);
				break;
			case "/deleteCo":
				delete(request, response);
				break;
			case "/editCo":
				showEditForm(request, response);
				break;
			case "/updateCo":
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
		
		request.setAttribute("liste_commissions", commisiondao.getAll());
		request.setAttribute("liste_academies", academiedao.getAll());
		request.getRequestDispatcher("WEB-INF/views/commission/list.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/commission/list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Commission commission = commisiondao.get(id);;
		request.setAttribute("liste_commissions", commisiondao.getAll());
		request.setAttribute("liste_academies", academiedao.getAll());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/commission/list.jsp");
		request.setAttribute("commission", commission);
		dispatcher.forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String nom = request.getParameter("nom");
		int idacademie = Integer.parseInt(request.getParameter("idAc"));
		
		Academie academie = new Academie();
		academie = academiedao.get(idacademie);
		
		Commission commission = new Commission(nom, academie);
		commisiondao.update(commission);
		response.sendRedirect("Commissions");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		int idacademie = Integer.parseInt(request.getParameter("idAc"));
		
		Academie academie = new Academie();
		academie = academiedao.get(idacademie);
		
		Commission commission = new Commission(id, nom, academie);
		commisiondao.update(commission);
		response.sendRedirect("Commissions");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		commisiondao.delete(id);
		response.sendRedirect("Commissions");

	}

}
