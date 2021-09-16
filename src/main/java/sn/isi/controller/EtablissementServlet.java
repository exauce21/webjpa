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

import sn.isi.dao.EtablissementImpl;
import sn.isi.dao.IEtablissement;
import sn.isi.entities.Etablissement;

/**
 * Servlet implementation class EtablissementServlet
 */
@WebServlet(name = "etablissements",  urlPatterns = {"/Etablissements", "/insertEt", "/deleteEt", "/update", "/editEt", "/newEt"} )
public class EtablissementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEtablissement etablissementdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtablissementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		etablissementdao = new EtablissementImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/newEt":
				showNewForm(request, response);
				break;
			case "/insertEt":
				add(request, response);
				break;
			case "/deleteEt":
				delete(request, response);
				break;
			case "/editEt":
				showEditForm(request, response);
				break;
			case "/updateEt":
				update(request, response);
				break;
			default:
				listEtablissement(request, response);
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
	
	private void listEtablissement(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		request.setAttribute("liste_etablissements", etablissementdao.getAll());
		request.getRequestDispatcher("WEB-INF/views/ecole/list.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/ecole/list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Etablissement etablissement = etablissementdao.get(id);;
		request.setAttribute("liste_etablissements", etablissementdao.getAll());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/ecole/list.jsp");
		request.setAttribute("etablissement", etablissement);
		dispatcher.forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
		
		Etablissement etablissement = new Etablissement(name, adresse);
		etablissementdao.add(etablissement);
		response.sendRedirect("Etablissements");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("nom");
		String adresse = request.getParameter("adresse");

		Etablissement etablissement = new Etablissement(id, name, adresse);
		
		etablissementdao.update(etablissement);
		response.sendRedirect("Etablissements");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		etablissementdao.delete(id);
		response.sendRedirect("Etablissements");

	}

}
