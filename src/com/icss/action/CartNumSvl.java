package com.icss.action;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.UserBiz;
import com.icss.entity.User;
import com.icss.util.Log;

/**
 * Servlet implementation class CartNumSvl
 */
@WebServlet(name = "cart/num", urlPatterns = { "/cart/num" })
public class CartNumSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartNumSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("user");
		String num = request.getParameter("num");
		int id= Integer.parseInt(request.getParameter("id"));
		if(user!=null && num!=null && id!=0) {
			UserBiz biz = new UserBiz();
			try {
				if(num.equals("add")) {
					Log.logger.info(num);
					biz.setCartRecord(user.getId(),id,1);
				}else if (num.equals("cut")) {
					Log.logger.info(num);
					biz.setCartRecord(user.getId(),id,-1);					
				}else if (num.equals("del")) {
					Log.logger.info(num);
					biz.setCartRecord(user.getId(), id, 0, true);
				}else {
					Log.logger.info(num);
					biz.setCartRecord(user.getId(), id, (int)Integer.parseInt(num), true);
				}
			} catch (Exception e) {
//				Log.logger.error(e.getMessage(),e);
				e.printStackTrace();
			}
//			request.getRequestDispatcher().forward(request, response);
			response.sendRedirect("detail");
		}else{
			response.sendRedirect(request.getContextPath());
		}
	}

}
