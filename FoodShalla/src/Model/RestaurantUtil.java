package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class RestaurantUtil {

	private DataSource dataSource;

	public RestaurantUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void insert(Restaurant c)
	{
	java.sql.Connection conn=null;
	java.sql.Statement st=null;
	ResultSet rs=null;
	try {
		conn=dataSource.getConnection();
		st=conn.createStatement();
		String st1= "INSERT INTO restaurant(name , pass) VALUES ('"+c.getName()+"','"+c.getPassword()+"')";	
		st.executeUpdate(st1);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		close(conn,st,rs);
	}
	}
	public Restaurant CheckUser(String name,String pass) {
		java.sql.Connection conn=null;
		java.sql.Statement st=null;
		ResultSet rs = null;
		Restaurant res = null;
		try {
			conn=dataSource.getConnection();
			st=conn.createStatement();
			String st1 = "SELECT * FROM restaurant where name = '"+name+"' AND  pass = '"+pass+"'";
			rs=st.executeQuery(st1);
			while(rs.next())
			{
				int id=rs.getInt("rid");
				String cname=rs.getString("name");
				String cpass=rs.getString("pass");
				res=new Restaurant(id,cname,cpass);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			close(conn,st,rs);
			return res;
		}
		
	}

	public List<Menu> getItems(int id)
	{
		List<Menu> menus= new ArrayList<>();
		java.sql.Connection conn=null;
		java.sql.Statement st=null;
		ResultSet rs=null;
		
		try {
			conn=dataSource.getConnection();
			st=conn.createStatement();
			String st1= "SELECT * FROM menu ";
			rs=st.executeQuery(st1);

			while(rs.next())
			{
				int mid= rs.getInt("mid");
				int rid= rs.getInt("rid");
				int price = rs.getInt("price");
				String name=rs.getString("name");
				String rname=rs.getString("rname");
				String type=rs.getString("type");
				menus.add(new Menu(mid,rid,name,rname,type,price));
				}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(conn,st,rs);
		}
		return menus;
	}
	public void AddItem(Menu c)
	{
	java.sql.Connection conn=null;
	java.sql.Statement st=null;
	ResultSet rs=null;
	try {
		conn=dataSource.getConnection();
		st=conn.createStatement();
		String st1= "INSERT INTO menu(rid , name , rname , type , price) VALUES ('"+c.getRid()+"','"+c.getName()+"','"+c.getRname()+"','"+c.getType()+"','"+c.getPrice()+"')";	
		st.executeUpdate(st1);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		close(conn,st,rs);
	}
	}
	
	private static void close(java.sql.Connection conn, java.sql.Statement st, ResultSet rs) {
		try {
		if(conn!=null)
		{
			conn.close();
		}
		if(st!=null)
		{
			st.close();
		}
		if(rs!=null)
		{
			rs.close();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
