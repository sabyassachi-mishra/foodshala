package Model;

public class Customer {

	private int id;
	private String name;
	private String pref;
	private String password;
	public Customer(int id, String name, String pref, String password) {
		super();
		this.id = id;
		this.name = name;
		this.pref = pref;
		this.password = password;
	}
	public Customer(String name, String pref, String password) {
		super();
		this.name = name;
		this.pref = pref;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPref() {
		return pref;
	}
	public void setPref(String pref) {
		this.pref = pref;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
