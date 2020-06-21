package Controller;
import java.io.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Model.CustomerUtil;
import Model.Customer;
import Model.*;

/**
 * Servlet implementation class InsertCustomer
 */
@WebServlet("/InsertCustomer")
public class InsertCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Resource(name="jdbc/foodshala")
	private DataSource dataSource;
	CustomerUtil cusUtil;

    public InsertCustomer() {
    }
	public void init() throws ServletException {
		try{
			 cusUtil= new CustomerUtil(dataSource);
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
		String pref=request.getParameter("preferance");
		String pass= request.getParameter("fpass");
		Customer c=new Customer(name,pref,pass);
		if (name != null && pass!= null && pref!= null)
		cusUtil.insert(c);
		
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
