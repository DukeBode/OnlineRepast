package com.icss.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.RepastBiz;
import com.icss.biz.UserBiz;
import com.icss.entity.Record;
import com.icss.entity.Repast;
import com.icss.entity.User;
import com.icss.util.Log;

/**
 * Servlet implementation class CartSvl
 */
@WebServlet(name = "cart/detail", urlPatterns = { "/cart/detail" })
public class CartSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int id= Integer.parseInt(request.getParameter("id"));
		User user = (User)request.getSession().getAttribute("user");
		if(user!=null) {
		
		UserBiz userBiz = new UserBiz();
		RepastBiz repastBiz = new RepastBiz();
		Log.logger.info("购物车");
		try {
			Map<Integer,Integer> cart = userBiz.getCart(user.getId());
			List<Repast> repasts=repastBiz.getExistsRepasts(cart.keySet());
			request.setAttribute("repasts", repasts);
			request.setAttribute("cartmap", cart);
			request.getRequestDispatcher("/WEB-INF/main/Shopcar.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
