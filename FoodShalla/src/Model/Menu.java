package Model;

public class Menu {

	private int mid;
	private int rid;
	private String rname;
	private String name;
	private String type;
	private int price;
	public Menu(int mid, int rid, String name,String rname, String type, int price) {
		super();
		this.mid = mid;
		this.rid = rid;
		this.name = name;
		this.rname = rname;
		this.type = type;
		this.price = price;
	}
	public Menu(int rid, String name, String rname, String type, int price) {
		super();
		this.rid=rid;
		this.name = name;
		this.rname = rname;
		this.type = type;
		this.price=price;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
