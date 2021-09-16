package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.isi.entities.User;

@WebFilter("/*")
public class FilterSession implements Filter {
	

	public FilterSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//res.getWriter().println("Execution du filtre avant la requet ... ");
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user_session");
		String chemin = req.getServletPath();
		//String  methode = req.getMethod();
		
		if(user != null || chemin.equals("/") || chemin.equals("/Login")|| chemin.equals("/index.jsp") || chemin.startsWith("/public")) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect("Login");
		}
		
	}

}
