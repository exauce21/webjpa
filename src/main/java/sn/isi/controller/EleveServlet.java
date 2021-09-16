package sn.isi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.EleveImpl;
import sn.isi.dao.EtablissementImpl;
import sn.isi.dao.ExamenImpl;
import sn.isi.dao.IEleve;
import sn.isi.dao.IEtablissement;
import sn.isi.dao.IExamen;
import sn.isi.dao.IInscription;
import sn.isi.dao.InscriptionImpl;
import sn.isi.entities.Eleve;
import sn.isi.entities.Etablissement;
import sn.isi.entities.Examen;
import sn.isi.entities.Inscription;

/**
 * Servlet implementation class EleveServelet
 */
@WebServlet( name = "eleves", urlPatterns = {"/Eleves", "/insertEl", "/deleteEl", "/updateEl", "/editEl", "/newEl"} )
public class EleveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEtablissement etablissementdao;
	private IEleve elevedao;
	private IInscription inscriptiondao;
	private IExamen examendao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EleveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		etablissementdao = new EtablissementImpl();
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
				case "/newEl":
					showNewForm(request, response);
					break;
				case "/insertEl":
					add(request, response);
					break;
				case "/deleteEl":
					delete(request, response);
					break;
				case "/editEl":
					showEditForm(request, response);
					break;
				case "/updateEl":
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
		
		request.setAttribute("liste_eleves", elevedao.getAll());
		request.setAttribute("liste_etablissements", etablissementdao.getAll());
		request.setAttribute("liste_examens", examendao.getAll());
		request.getRequestDispatcher("WEB-INF/views/eleve/list.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/eleve/list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Eleve eleve = elevedao.get(id);
		
		request.setAttribute("liste_eleves", elevedao.getAll());
		request.setAttribute("liste_etablissements", etablissementdao.getAll());
		request.setAttribute("liste_examens", examendao.getAll());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/eleve/list.jsp");
		request.setAttribute("eleve", eleve);
		dispatcher.forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String matricule = request.getParameter("matricule");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String datenais = request.getParameter("datenais");
		String email = "";
		String password = "";
		
		
		int idEx = Integer.parseInt(request.getParameter("idEx"));
		Examen examen = new Examen();
		examen = examendao.get(idEx);
		
		
		int idEt = Integer.parseInt(request.getParameter("idEt"));
		Etablissement etablissement = new Etablissement();
		etablissement = etablissementdao.get(idEt);
		
		
		Eleve eleve = new Eleve(matricule, nom, prenom, email, password, datenais, etablissement);
		elevedao.add(eleve);
		
		
		LocalDate dateIns = LocalDate.now();
		java.sql.Date sqlDate = java.sql.Date.valueOf(dateIns);
		String numero = "I0" + idEt + "" + nom ;
		Inscription  inscription = new Inscription(numero, sqlDate, eleve, examen);
		inscriptiondao.add(inscription);
		
		response.sendRedirect("Eleves");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String matricule = request.getParameter("matricule");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String datenais = request.getParameter("datenais");
		//Date datenais = Date.valueOf(request.getParameter("datenais"));
		
		String email = "";
		String password = "";
		int idEt = Integer.parseInt(request.getParameter("idEt"));
		
		Etablissement etablissement = new Etablissement();
		etablissement = etablissementdao.get(idEt);
		
		Eleve eleve = new Eleve(id, matricule, nom, prenom, email, password, datenais, etablissement);
		elevedao.update(eleve);
		
		response.sendRedirect("Eleves");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		elevedao.delete(id);
		response.sendRedirect("Eleves");

	}

}
