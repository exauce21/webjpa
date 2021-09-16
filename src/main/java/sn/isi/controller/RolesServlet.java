package sn.isi.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.isi.dao.IRoles;
import sn.isi.dao.RolesImpl;
import sn.isi.entities.Roles;

@WebServlet(value = "/Roles", name = "roles")
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoles roledao;
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public RolesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		roledao = new RolesImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("liste_roles", roledao.getAll());
		request.getRequestDispatcher("WEB-INF/views/roles/list.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Roles  role = new Roles();
		
		String nom = request.getParameter("nom");
		role.setNom(nom);
		
		int ok = roledao.add(role);
		
		if (ok != 1) {
			response.sendRedirect("Roles");
		} else {
			response.sendRedirect("Roles");
		}
		
	}
	
}
