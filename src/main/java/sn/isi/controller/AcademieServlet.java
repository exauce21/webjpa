package sn.isi.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.AcademieImpl;
import sn.isi.dao.IAcademie;
import sn.isi.entities.Academie;

/**
 * Servlet implementation class AcademieServelet
 */
@WebServlet(value = "/Academie", name = "academies")
public class AcademieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAcademie academiedao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcademieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		academiedao = new  AcademieImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("liste_academies", academiedao.getAll());
		request.getRequestDispatcher("WEB-INF/views/academie/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Academie  academie = new Academie();
		
		String nom = request.getParameter("nom");
		academie.setNom(nom);
		
		int ok = academiedao.add(academie);
		
		if (ok != 1) {
			response.sendRedirect("Academie");
		} else {
			response.sendRedirect("Academie");
		}
	}
	
	 /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idAcademie = request.getParameter("id");
        int id = Integer.parseInt(idAcademie);
        
        int ok = academiedao.delete(id);
        
        if (ok != 1) {
			response.sendRedirect("Academie");
		} else {
			response.sendRedirect("Academie");
		}
    }

}
