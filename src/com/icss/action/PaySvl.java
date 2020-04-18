package com.icss.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.UserBiz;
import com.icss.entity.Record;
import com.icss.entity.User;
import com.icss.util.Log;

/**
 * Servlet implementation class PaySvl
 */
@WebServlet(name = "user/pay", urlPatterns = { "/user/pay" })
public class PaySvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaySvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		double allpay = (double) request.getSession().getAttribute("allpay");
		List<Record> records = (List<Record>) request.getSession().getAttribute("records");
		UserBiz biz = new UserBiz();
		try {
			biz.payMoney(user, allpay, records);
			user.setStatus((byte)(user.getStatus()-(byte)allpay));
			request.getSession().setAttribute("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("allpay", allpay);
		request.getSession().removeAttribute("allpay");
		request.getSession().removeAttribute("records");
		request.getRequestDispatcher("/WEB-INF/main/payOK.jsp").forward(request, response);
	}

}
