package ju15.gold.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("trans").equals("Buy")){
			
		try{
			BigDecimal amount=new BigDecimal(request.getParameter("bamount"));
			String url="/gold/goldbuy.jsp";
			amount = amount.multiply(new BigDecimal(301.10));
			
			request.setAttribute("amount", amount.setScale(2, RoundingMode.HALF_UP));
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		}catch(Exception e){
			getServletContext().getRequestDispatcher("/gold/error.html").forward(request, response);
		}
		}
		if (request.getParameter("trans").equals("Sell")){
		 try{
			BigDecimal amount=new BigDecimal(request.getParameter("samount"));
			String url="/gold/goldsell.jsp";
			request.setAttribute("amount", amount.multiply(new BigDecimal(301.10*0.7)).setScale(2, RoundingMode.HALF_UP));
			getServletContext().getRequestDispatcher(url).forward(request, response);
		 }catch(Exception e){
			 getServletContext().getRequestDispatcher("/gold/error.html").forward(request, response);
		 }
		}
//		String url="/goldbuy.jsp";
//		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
