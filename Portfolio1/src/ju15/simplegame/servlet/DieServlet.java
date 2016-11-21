package ju15.simplegame.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ju15.simplegame.bean.Player;
import ju15.simplegame.bean.Troll;

/**
 * Servlet implementation class DieServlet
 */
@WebServlet("/DieServlet")
public class DieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String s=null;
		try{
		  s=(String)request.getParameter("restart");
		}catch (Exception e){
			
		}

		if (s.equals("Restart")){
			session.invalidate();
			session=request.getSession();
			session.setAttribute("player", new Player());
			session.setAttribute("troll", new Troll());
			String url="/SimpleGame/play.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
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
