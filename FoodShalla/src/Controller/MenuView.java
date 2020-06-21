package Controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Model.RestaurantUtil;
import Model.Menu;
import Model.MenuUtil;


/**
 * Servlet implementation class MenuView
 */
@WebServlet("/MenuView")
public class MenuView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Resource(name="jdbc/foodshala")
	private DataSource dataSource;
	MenuUtil menUtil;


	public void init() throws ServletException {
		try{
			menUtil= new MenuUtil(dataSource);
		}catch(Exception e)
		{
			throw new ServletException(e);
		}
	}
    public MenuView() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> menus=menUtil.getItems();
		request.setAttribute("menulist",menus);
		RequestDispatcher rd= request.getRequestDispatcher("MenuListView.jsp");
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
