package sn.isi.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.AcademieImpl;
import sn.isi.dao.ExamenImpl;
import sn.isi.dao.IAcademie;
import sn.isi.dao.IExamen;
import sn.isi.entities.Academie;
import sn.isi.entities.Examen;

/**
 * Servlet implementation class ExamenServlet
 */
@WebServlet( name = "examens", urlPatterns = {"/Examens", "/insertEx", "/deleteEx", "/updateEx", "/editEx", "/newEx"} )
public class ExamenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IExamen examendao;
	private IAcademie academiedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		examendao = new ExamenImpl();
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
			case "/newEx":
				showNewForm(request, response);
				break;
			case "/insertEx":
				add(request, response);
				break;
			case "/deleteEx":
				delete(request, response);
				break;
			case "/editEx":
				showEditForm(request, response);
				break;
			case "/updateEx":
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
		request.setAttribute("liste_academies", academiedao.getAll());
		request.setAttribute("liste_examens", examendao.getAll());
		request.getRequestDispatcher("WEB-INF/views/examen/list.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/examen/list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Examen examen = examendao.get(id);
		request.setAttribute("liste_academies", academiedao.getAll());
		request.setAttribute("liste_examens", examendao.getAll());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/examen/list.jsp");
		request.setAttribute("examen", examen);
		dispatcher.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int idAc = Integer.parseInt(request.getParameter("idAc"));
		String nom = request.getParameter("nom");
		Date dateEx = Date.valueOf(request.getParameter("dateEx"));
		Academie  academie = new Academie();
		academie  = academiedao.get(idAc);
		
		Examen examen = new Examen(nom, dateEx, academie);
		examendao.add(examen);
		
		response.sendRedirect("Examens");
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int idAc = Integer.parseInt(request.getParameter("idAc"));
		String nom = request.getParameter("nom");
		Date dateEx = Date.valueOf(request.getParameter("dateEx"));
		Academie  academie = new Academie();
		academie  = academiedao.get(idAc);
		
		Examen examen = new Examen(id, nom, dateEx, academie);
		examendao.update(examen);
		
		response.sendRedirect("Examens");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		examendao.delete(id);
		response.sendRedirect("Examens");

	}

}
