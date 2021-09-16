package sn.isi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.CommissionImpl;
import sn.isi.dao.EnseignantImpl;
import sn.isi.dao.EtablissementImpl;
import sn.isi.dao.ICommision;
import sn.isi.dao.IEnseignant;
import sn.isi.dao.IEtablissement;
import sn.isi.entities.Commission;
import sn.isi.entities.Enseignant;
import sn.isi.entities.Etablissement;

/**
 * Servlet implementation class EnseignantServlet
 */
@WebServlet( name = "enseignants", urlPatterns = {"/Enseignants", "/insertEn", "/deleteEn", "/updateEn", "/editEn", "/newEn"} )
public class EnseignantServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IEnseignant enseignantdao;
	private ICommision commissiondao;
	private IEtablissement etablissementdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnseignantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		enseignantdao = new EnseignantImpl();
		commissiondao = new CommissionImpl();
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
			case "/newEn":
				showNewForm(request, response);
				break;
			case "/insertEn":
				add(request, response);
				break;
			case "/deleteEn":
				delete(request, response);
				break;
			case "/editEn":
				showEditForm(request, response);
				break;
			case "/updateEn":
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
		
		request.setAttribute("liste_enseignants", enseignantdao.getAll());
		request.setAttribute("liste_commissions", commissiondao.getAll());
		request.setAttribute("liste_etablissements", etablissementdao.getAll());
		request.getRequestDispatcher("WEB-INF/views/enseignant/list.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/enseignant/list.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Enseignant enseignant = enseignantdao.get(id);
		request.setAttribute("liste_enseignants", enseignantdao.getAll());
		request.setAttribute("liste_commissions", commissiondao.getAll());
		request.setAttribute("liste_etablissements", etablissementdao.getAll());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/enseignant/list.jsp");
		request.setAttribute("enseignant", enseignant);
		dispatcher.forward(request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String matricule = request.getParameter("matricule");
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
		int tel = Integer.parseInt(request.getParameter("tel"));
		String ville = request.getParameter("ville");
		String email = "";
		int idCo = Integer.parseInt(request.getParameter("idCo"));
		int idEt = Integer.parseInt(request.getParameter("idEt"));
		
		Commission commission = new Commission();
		commission = commissiondao.get(idCo);
		
		List<Etablissement> etablissementList = new ArrayList<Etablissement>();
		Etablissement etablissement = new Etablissement();
		etablissement = etablissementdao.get(idEt);
		
		etablissementList.add(etablissement);
		
		Enseignant enseignant = new Enseignant(matricule, nom, tel, adresse, ville, email, commission, etablissementList);
		enseignantdao.add(enseignant);
		response.sendRedirect("Enseignants");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String matricule = request.getParameter("matricule");
		String nom = request.getParameter("nom");
		String adresse = request.getParameter("adresse");
		int tel = Integer.parseInt(request.getParameter("tel"));
		String ville = request.getParameter("ville");
		String email = request.getParameter("email");

		Enseignant enseignant = new Enseignant(id, matricule, nom, tel, adresse, ville, email);
		
		enseignantdao.update(enseignant);
		response.sendRedirect("Enseignants");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		enseignantdao.delete(id);
		response.sendRedirect("Enseignants");

	}

}
