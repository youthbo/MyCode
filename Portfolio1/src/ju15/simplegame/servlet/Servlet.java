package ju15.simplegame.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ju15.simplegame.bean.Ant;
import ju15.simplegame.bean.Goblin;
import ju15.simplegame.bean.Monster;
import ju15.simplegame.bean.Player;
import ju15.simplegame.bean.Troll;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		// Monster[] monster = {new Ant(),new Goblin(),new Troll()};
		Player p = (Player) session.getAttribute("player");

		if (p == null) {
			p = new Player();
			session.setAttribute("player", p);

		}
		String output = (String) session.getAttribute("output");
		if (output == null) {
			session.setAttribute("output", " ");
		}
		Ant ant = null;
		Goblin g = null;
		Troll troll = null;
		if (session.getAttribute("troll") == null) {
			troll = new Troll();
			session.setAttribute("troll", troll);
		}
		String who = request.getParameter("submit");
		if (who == null) {
			// session.setAttribute("thp", 100);
			String url = "/SimpleGame/play.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			// System.out.println("in who is null");

		}

		if (who != null) {
			int myhp = p.getHp();
			int myexp = p.getExp();

			if (myhp > 0) {

				if (who.equals("Ant")) {
					try {
						ant = (Ant) session.getAttribute("ant");
					} catch (Exception e) {
					}
					if (ant == null) {
						ant = new Ant();
						session.setAttribute("ant", ant);
					}
					//myhp = myhp - ant.getDamage();
					ant.attack(p);
					output = (String) session.getAttribute("output");
					session.setAttribute("output",  "You killed an ant.Got 1exp." + "<br>"+output);

					if (p.getHp() > 0) {
						//p.setHp(myhp);
						p.attack(ant);
						if (ant.getHp()<0) {
							//output = session.getAttribute("output").toString();
							session.setAttribute("antout",  "Ant did an attack!You lost 2hp.");
							session.setAttribute("trollout",  "");
							session.setAttribute("goout",  "");
							p.setExp(myexp + 1);
							String url = "/SimpleGame/play.jsp";
							getServletContext().getRequestDispatcher(url).forward(request, response);
						}
					} else {
						p.setHp(0);
						String url = "/SimpleGame/die.jsp";
						getServletContext().getRequestDispatcher(url).forward(request, response);

					}
				} else if (who.equals("Goblin")) {
					try {
						g = (Goblin) session.getAttribute("goblin");
					} catch (Exception e) {
					}
					if (g == null) {
						g = new Goblin();
						session.setAttribute("goblin", g);
					}
					g.attack(p);
					//myhp = myhp - g.getDamage();
					output = (String) session.getAttribute("output");
					session.setAttribute("output",  "You killed a goblin.Got 6exp." + "<br>"+output);

					if (p.getHp() > 0) {
						//p.setHp(myhp);
                        p.attack(g);
						if (g.getHp()< 0) {
							p.setExp(myexp + 6);
							//output = session.getAttribute("output").toString();
							session.setAttribute("goout", "Goblin did an attack!You lost 6hp." );
							session.setAttribute("antout",  "");
							session.setAttribute("trollout",  "");
							String url = "/SimpleGame/play.jsp";
							getServletContext().getRequestDispatcher(url).forward(request, response);
						}
					} else {
						p.setHp(0);
						String url = "/SimpleGame/die.jsp";
						getServletContext().getRequestDispatcher(url).forward(request, response);

					}
				} else if (who.equals("Troll")) {
					try {
						troll = (Troll) session.getAttribute("troll");
					} catch (Exception e) {
					}
					if (troll == null) {
						troll = new Troll();
						session.setAttribute("troll", troll);
					}
//					int thp = troll.getHp();
					//int tdam = troll.getDamage();
//					myhp = myhp - tdam;
					if (troll.getHp()<=0){
						troll.setHp(100);
						session.setAttribute("trollout", "A new troll comes.");
						String url = "/SimpleGame/play.jsp";
						getServletContext().getRequestDispatcher(url).forward(request, response);
					}
					else{
						troll.attack(p);
						session.setAttribute("trollout", "Troll did an attack!You lost " + (myhp- p.getHp())+"hp.");
						session.setAttribute("antout",  "");
						session.setAttribute("goout",  "");

					if (p.getHp() > 0) {
						//p.setHp(myhp);
						// attack back
						p.attack(troll);
						output = session.getAttribute("output").toString();
						session.setAttribute("output",  "You attack troll!Troll lost 12hp."+ "<br>"+output);
						if (troll.getHp() <= 0) {					
							output = session.getAttribute("output").toString();
							session.setAttribute("output",  "You killed a troll!Got 50exp."+ "<br>"+output);
							session.setAttribute("antout",  "");
							session.setAttribute("goout",  "");
							session.setAttribute("trollout",  "");
							p.setExp(myexp + 50);
							troll.setHp(0);
							
						}
					
						String url = "/SimpleGame/play.jsp";
						getServletContext().getRequestDispatcher(url).forward(request, response);
					} else {
						p.setHp(0);
						String url = "/SimpleGame/die.jsp";

						getServletContext().getRequestDispatcher(url).forward(request, response);

					}
				  
				}
			} else {
				String url = "/SimpleGame/die.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);

			}
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
