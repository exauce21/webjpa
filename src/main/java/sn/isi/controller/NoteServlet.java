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
import sn.isi.dao.EpreuveImpl;
import sn.isi.dao.IEleve;
import sn.isi.dao.IEpreuve;
import sn.isi.dao.INote;
import sn.isi.dao.NoteImpl;
import sn.isi.entities.Eleve;
import sn.isi.entities.Epreuve;
import sn.isi.entities.Note;

/**
 * Servlet implementation class NoteServlet
 */
@WebServlet(name = "notes", urlPatterns = {"/Notes", "/insertNt", "/deleteNt", "/updateNt", "/editNt", "/newNt"})
public class NoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private INote notedao;
	private IEpreuve epreuvedao;
	private IEleve elevedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		epreuvedao = new EpreuveImpl();
		elevedao = new EleveImpl();
		notedao = new NoteImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
		    switch (action) {
		    case "/newNt":
		        showNewForm(request, response);
		        break;
		    case "/insertNt":
		        add(request, response);
		        break;
		    case "/deleteNt":
		        delete(request, response);
		        break;
		    case "/editNt":
		        showEditForm(request, response);
		        break;
		    case "/updateNt":
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
		request.setAttribute("liste_notes", notedao.getAll());
		request.setAttribute("liste_eleves", elevedao.getAll());
		request.getRequestDispatcher("WEB-INF/views/note/list.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/note/list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Note note = notedao.get(id);
		request.setAttribute("liste_epreuves", epreuvedao.getAll());
		request.setAttribute("liste_notes", notedao.getAll());
		request.setAttribute("liste_eleves", elevedao.getAll());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/note/list.jsp");
		request.setAttribute("note", note);
		dispatcher.forward(request, response);

	}
	

	private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int idEl= Integer.parseInt(request.getParameter("idEl"));
		Eleve eleve = new Eleve();
		eleve = elevedao.get(idEl);
		
		int idEp = Integer.parseInt(request.getParameter("idEp"));
		Epreuve  epreuve = new Epreuve();
		epreuve = epreuvedao.get(idEp);
		
		int valeur = Integer.parseInt(request.getParameter("valeur"));
		
		Note note = new Note(valeur, eleve, epreuve);
		
		notedao.add(note);
		
		response.sendRedirect("Notes");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int idEl= Integer.parseInt(request.getParameter("idEl"));
		Eleve eleve = new Eleve();
		eleve = elevedao.get(idEl);
		
		int idEp = Integer.parseInt(request.getParameter("idEp"));
		Epreuve  epreuve = new Epreuve();
		epreuve = epreuvedao.get(idEp);
		
		int valeur = Integer.parseInt(request.getParameter("valeur"));
		
		Note note = new Note(id, valeur, eleve, epreuve);
		
		notedao.update(note);
		
		response.sendRedirect("Notes");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		notedao.delete(id);
		response.sendRedirect("Notes");

	}

}
