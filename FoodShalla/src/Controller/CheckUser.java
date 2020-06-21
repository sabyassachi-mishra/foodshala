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

import Model.RestaurantUtil;
import Model.Menu;
import Model.CustomerUtil;
import Model.Restaurant;
import Model.Customer;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        // TODO Auto-generated constructor stub
    }
	@Resource(name="jdbc/foodshala")
	private DataSource dataSource;

	@Resource(name="jdbc/foodshala")
	private DataSource dataSource1;
	RestaurantUtil resUtil;
	CustomerUtil cusUtil;


	public void init() throws ServletException {
		try{
			resUtil= new RestaurantUtil(dataSource);
			cusUtil = new CustomerUtil(dataSource1);
		}catch(Exception e)
		{
			throw new ServletException(e);
		}
     
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname= request.getParameter("funame");
		String pass= request.getParameter("fpass");
		if (uname == null && pass == null)
		response.sendRedirect("Login.jsp");
		else {
		Restaurant res= resUtil.CheckUser(uname,pass);
		Customer cus = cusUtil.CheckUser(uname,pass);
		if(res!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("resid",res.getId());
			session.setAttribute("resname",res.getName());
			session.setAttribute("respass",res.getPassword());
			List<Menu> menus=resUtil.getItems(res.getId());
			request.setAttribute("menulist",menus);
			RequestDispatcher rd= request.getRequestDispatcher("RestaurantHome.jsp");
			rd.forward(request, response);
		}
		else if(cus!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("cusid",cus.getId());
			session.setAttribute("cusname",cus.getName());
			session.setAttribute("cuspref",cus.getPref());
			session.setAttribute("cuspass",cus.getPassword());
			List<Menu> menus=cusUtil.getItems();
			request.setAttribute("menulist",menus);
			RequestDispatcher rd= request.getRequestDispatcher("CustomerHome.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("Login.jsp");

		}
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
