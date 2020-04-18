package com.icss.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutSvl
 */
@WebServlet(name = "logout", urlPatterns = { "/logout" })
public class LogoutSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		String ref = request.getHeader("referer");		
		if (ref == null || ref == request.getRequestURL().toString()) {
			// 返回主页
			response.sendRedirect(request.getContextPath());
		} else {
			// 返回来源页
			response.sendRedirect(ref);
		}
	}

}
