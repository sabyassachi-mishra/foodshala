package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Model.Customer;
import Model.CustomerUtil;
import Model.Restaurant;
import Model.RestaurantUtil;

/**
 * Servlet implementation class InsertRestaurant
 */
@WebServlet("/InsertRestaurant")
public class InsertRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRestaurant() {
        // TODO Auto-generated constructor stub
    }
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name= request.getParameter("fname");
		String pass= request.getParameter("fpass");
		Restaurant c=new Restaurant(name,pass);
		if (name != null && pass!= null)
		resUtil.insert(c);
		
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
