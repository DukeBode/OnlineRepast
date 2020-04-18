package com.icss.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.biz.RepastBiz;
import com.icss.util.Log;

/**
 * Servlet implementation class HomeSvl
 */
@WebServlet(name = "home", urlPatterns = { "/home" })
public class HomeSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RepastBiz biz = new RepastBiz();
		try {
			request.setAttribute("repasts", biz.getAllRepasts());
			request.getRequestDispatcher("/WEB-INF/main/index.jsp").forward(request, response);
		} catch (Exception e) {
			Log.logger.info("访问异常");
			Log.logger.error(e.getMessage(), e);
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
