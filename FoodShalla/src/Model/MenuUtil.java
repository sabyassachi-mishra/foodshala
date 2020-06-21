package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class MenuUtil {
	private DataSource dataSource;

	public MenuUtil(DataSource dataSource) {
		this.dataSource = dataSource;
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
