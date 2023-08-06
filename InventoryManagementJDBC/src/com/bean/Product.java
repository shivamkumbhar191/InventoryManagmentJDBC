package com.bean;

public class Product {
	private int pid;
	private String pname;
	private int cid;
	private int price;
	
	public Product() {
		super();
	}

	public Product(int pid, String pname, int cid, int price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cid = cid;
		this.price = price;
	}
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", cid=" + cid + ", price=" + price + "]";
	}
	
	

}
