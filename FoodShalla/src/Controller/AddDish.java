package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Model.Restaurant;
import Model.RestaurantUtil;
import Model.Menu;

/**
 * Servlet implementation class AddDish
 */
@WebServlet("/AddDish")
public class AddDish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDish() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Resource(name="jdbc/foodshala")
	private DataSource dataSource;
	RestaurantUtil resUtil;


	public void init() throws ServletException {
		try{
			resUtil= new RestaurantUtil(dataSource);
		}catch(Exception e)
		{
			throw new ServletException(e);
		}
     
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String b =(String)session.getAttribute("resname"); 
		if(b==null) {
			response.sendRedirect("Login.jsp");
		}
		PrintWriter out=response.getWriter();
		String name= request.getParameter("fname");
		String pref= request.getParameter("preferance");
		int price= Integer.parseInt(request.getParameter("fprice"));
		int a=(Integer)session.getAttribute("resid");
		Menu c=new Menu(a,name,b,pref,price);
		resUtil.AddItem(c);
		List<Menu> menus=resUtil.getItems(a);
		request.setAttribute("menulist",menus);
		RequestDispatcher rd= request.getRequestDispatcher("RestaurantHome.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
