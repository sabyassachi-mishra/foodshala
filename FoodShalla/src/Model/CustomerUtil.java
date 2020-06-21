package Model;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import java.sql.*;
import java.sql.*;
public class CustomerUtil {

private DataSource dataSource;

public CustomerUtil(DataSource dataSource) {
	this.dataSource = dataSource;
}
public void insert(Customer c)
{
java.sql.Connection conn=null;
java.sql.Statement st=null;
ResultSet rs=null;
try {
	conn=dataSource.getConnection();
	st=conn.createStatement();
	String st1= "INSERT INTO customer(name , pass , pref) VALUES ('"+c.getName()+"','"+c.getPassword()+"','"+c.getPref()+"')";	
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
public Customer CheckUser(String name, String pass) {
	java.sql.Connection conn=null;
	java.sql.Statement st=null;
	ResultSet rs = null;
	Customer cus = null;
	try {
		conn=dataSource.getConnection();
		st=conn.createStatement();
		String st1 = "SELECT * FROM customer where name = '"+name+"' AND  pass = '"+pass+"'";
		rs=st.executeQuery(st1);
		while(rs.next())
		{
			int id=rs.getInt("cid");
			String cname=rs.getString("name");
			String cpass=rs.getString("pass");
			String cpref=rs.getString("pref");
			cus=new Customer(id,cname,cpass,cpref);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		close(conn,st,rs);
	}	
	return cus;

}


public List<Menu> getItems()
{
	List<Menu> menus= new ArrayList<>();
	java.sql.Connection conn=null;
	java.sql.Statement st=null;
	ResultSet rs=null;
	
	try {
		conn=dataSource.getConnection();
		st=conn.createStatement();
		String st1= "SELECT * FROM menu order by rid";
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
