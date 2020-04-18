package com.icss.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
 * Servlet implementation class CheckoutSvl
 */
@WebServlet(name = "cart/checkout", urlPatterns = { "/cart/checkout" })
public class CheckoutSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user!=null) {
		
		UserBiz userBiz = new UserBiz();
		RepastBiz repastBiz = new RepastBiz();
		Log.logger.info("购物车");
		try {
			Map<Integer,Integer> cart = userBiz.getCart(user.getId());
			List<Repast> repasts = repastBiz.getExistsRepasts(cart.keySet());
			request.setAttribute("repasts", repasts);
			request.setAttribute("cartmap", cart);
			double allpay=0;
			List<Record> records = new ArrayList<>();
			for (Repast repast : repasts) {
				allpay = allpay + repast.getPrice() * cart.get(repast.getId());
				Record record = new Record();
				record.setRepastid(repast.getId());
				record.setNumber(cart.get(repast.getId()));
				record.setPiece(repast.getPrice());
				records.add(record);
			}
			request.setAttribute("allpay", allpay);
			request.getSession().setAttribute("records", records);
			request.getSession().setAttribute("allpay", allpay);
			request.getRequestDispatcher("/WEB-INF/main/checkout.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
