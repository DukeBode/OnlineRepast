package com.icss.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.UserBiz;
import com.icss.cons.IRole;
import com.icss.entity.User;

/**
 * Servlet implementation class RegistSvl
 */
@WebServlet(name = "regist", urlPatterns = { "/regist" })
public class RegistSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String pwd = request.getParameter("password");
		User user = new User();
		user.setId(account);
		user.setPwd(pwd);
		user.setDate(new Date());
		user.setStatus((byte)10);
		user.setRole(IRole.USER);
		UserBiz biz = new UserBiz();
		try {
			biz.regist(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
