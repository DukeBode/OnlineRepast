package com.icss.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.RepastBiz;
import com.icss.biz.UserBiz;
import com.icss.entity.Repast;
import com.icss.entity.User;

/**
 * Servlet implementation class LoginSvl
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String ref = request.getHeader("referer");
//		request.getRequestDispatcher("/WEB-INF/main/sub/topnav.jsp").forward(request, response);
//		if (ref == null || ref == request.getRequestURL().toString()) {
//			// 返回登录页
//			 request.getRequestDispatcher("/WEB-INF/main/sub/topnav.jsp").forward(request, response);
//			// 返回主页
			response.sendRedirect(request.getContextPath());
//		} else {
//			// 返回来源页
//			response.sendRedirect(ref);
//		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
		UserBiz biz = new UserBiz();
		try {
			User user = biz.login(account, pwd);
			if (user != null) {
				request.getSession().setAttribute("user", user);
				out.print(0);
			} else {
				out.print(1);
			}
		} catch (Exception e) {
			out.print(-1);
			e.printStackTrace();
		}
	}

}
